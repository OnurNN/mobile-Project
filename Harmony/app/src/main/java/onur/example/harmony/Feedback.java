package onur.example.harmony;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;


public class Feedback extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        setTitle("FEEDBACK");

        RatingBar feedbackRating = findViewById(R.id.feedback_rating);
        EditText feedbackMessage = findViewById(R.id.feedback_message);
        Button feedbackButton = findViewById(R.id.feedback_button);

    }

}