package onur.example.harmony;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        setTitle("HOME PAGE");

        Button profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, Profile.class);
                startActivity(intent);
            }
        });

        Button myRoutineBtn = findViewById(R.id.myRoutinebtn);
        myRoutineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, MyRoutine.class);
                startActivity(intent);
            }
        });

        Button toDoBtn = findViewById(R.id.toDoBtn);
        toDoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePage.this, ToDo.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedback:
                Intent intentFeedback= new Intent(HomePage.this,Feedback.class);
                startActivity(intentFeedback);
                return true;
            case R.id.aboutUs:
                Intent intentAboutUs = new Intent(HomePage.this, AboutUs.class);
                startActivity(intentAboutUs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}