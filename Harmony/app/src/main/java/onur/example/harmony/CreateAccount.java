package onur.example.harmony;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {


    EditText password,passwordAgain,username,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        setTitle("CREATE ACCOUNT");

        password=findViewById(R.id.password);
        passwordAgain=findViewById(R.id.password_again);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
    }
    public boolean checkConditions() {
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        passwordAgain=findViewById(R.id.password_again);

        if(!PasswordValidator.validate(password.getText().toString())){
            Toast.makeText(getApplicationContext(),"Please use one [0-9], [a-z], [A-Z] and at least 8 char!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!PasswordValidator.matching(password.getText().toString(),passwordAgain.getText().toString())) {
            Toast.makeText(getApplicationContext(),"Passwords does not match!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(username.getText())){
            Toast.makeText(getApplicationContext(),"Username cannot be empty!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(email.getText())){
            Toast.makeText(getApplicationContext(),"Email cannot be empty!",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(password.getText())){
            Toast.makeText(getApplicationContext(),"Password cannot be empty",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}