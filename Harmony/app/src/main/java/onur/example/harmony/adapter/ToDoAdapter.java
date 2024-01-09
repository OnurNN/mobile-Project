package onur.example.harmony.adapter;

import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import onur.example.harmony.AddNewTask;
import onur.example.harmony.MyRoutine;
import onur.example.harmony.R;
import onur.example.harmony.model.ToDoModel;
import onur.example.harmony.utils.DatabaseHandler;


public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MyRoutine myRoutine;
    private DatabaseHandler db;

    public ToDoAdapter(DatabaseHandler db, MyRoutine routine) {
        this.db = db;
        this.myRoutine = routine;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout, parent, false);
        return new ViewHolder(itemView);
    }

    public void onBindViewHolder(ViewHolder wh, int position) {
        ToDoModel item = todoList.get(position);
        wh.task.setText(item.getTask());
        wh.task.setChecked(toBoolean(item.getStatus()));
        wh.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    db.updateStatus(String.valueOf(item.getId()), 1);
                } else {
                    db.updateStatus(String.valueOf(item.getId()), 0);
                }
            }
        });
    }

    public boolean toBoolean(int i) {
        return i!=0;
    }

    public Context getContext() {
        return myRoutine;
    }

    public void setTasks(List<ToDoModel> todoList) {
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        ToDoModel item = todoList.get(position);
        db.deleteTask(String.valueOf(item.getId()));
        todoList.remove(position);
        notifyItemRemoved(position);
    }

    public int getItemCount() {
        return todoList.size();
    }

    public void editItem(int position) {
        ToDoModel item = todoList.get(position);
        Bundle bundle = new Bundle();
        bundle.putInt("id", item.getId());
        bundle.putString("task", item.getTask());
        AddNewTask fragment = new AddNewTask();
        fragment.setArguments(bundle);
        fragment.show(myRoutine.getSupportFragmentManager(), AddNewTask.TAG);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox task;

        ViewHolder(View view) {
            super(view);
            task = view.findViewById(R.id.todoCheckBox);
        }
    }

}