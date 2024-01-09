package onur.example.harmony;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class ToDo extends AppCompatActivity {

    private LinearLayout dailyContainer;
    private LinearLayout weeklyContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        setTitle("To-Do List");

        dailyContainer = findViewById(R.id.dailyContainer);
        weeklyContainer = findViewById(R.id.weeklyContainer);

    }

    public void onDailyAddButtonClick(View view) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("daily tofo");
        dailyContainer.addView(checkBox);
    }

    public void onDailyDeleteButtonClick(View view) {
        int childCount = dailyContainer.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            View child = dailyContainer.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) child;
                if (checkBox.isChecked()) {
                    dailyContainer.removeViewAt(i);
                }
            }
        }
    }

    public void onWeeklyAddButtonClick(View view) {
        CheckBox checkBox = new CheckBox(this);
        checkBox.setText("weekly ofot");
        weeklyContainer.addView(checkBox);
    }

    public void onWeeklyDeleteButtonClick(View view) {
        int childCount = weeklyContainer.getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            View child = weeklyContainer.getChildAt(i);
            if (child instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) child;
                if (checkBox.isChecked()) {
                    weeklyContainer.removeViewAt(i);
                }
            }
        }
    }

}