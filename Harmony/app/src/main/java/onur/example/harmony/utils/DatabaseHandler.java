package onur.example.harmony.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

import onur.example.harmony.model.ToDoModel;

public class DatabaseHandler {

    private DatabaseReference databaseReference;

    public DatabaseHandler(FragmentActivity activity) {
        // Initialize Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("todo"); // Change "todo" to your desired Firebase database node
    }

    public void openDatabase() {
        this.readData();
    }

    public void readData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                // Retrieve data from the dataSnapshot
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String data = snapshot.getValue(String.class);
                    System.out.println("Read data: " + data);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                System.out.println("Failed to read data. Error: " + error.getMessage());
            }
        });
    }

    public void insertTask(ToDoModel task) {
        String key = databaseReference.push().getKey();
        assert key != null;
        task.setId(Integer.parseInt(key));
        databaseReference.child(key).setValue(task);
    }

    public List<ToDoModel> getAllTasks() {
        final List<ToDoModel> taskList = new ArrayList<>();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                taskList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ToDoModel task = snapshot.getValue(ToDoModel.class);
                    if (task != null) {
                        taskList.add(task);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });

        return taskList;
    }

    public void updateStatus(String id, int status) {
        databaseReference.child(id).child("status").setValue(status);
    }

    public void updateTask(String id, String task) {
        databaseReference.child(id).child("task").setValue(task);
    }

    public void deleteTask(String id) {
        databaseReference.child(id).removeValue();
    }
}
