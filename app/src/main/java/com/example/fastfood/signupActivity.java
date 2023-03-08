package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signupActivity extends AppCompatActivity {
    EditText signupname, signupemail , signuppassword, signupusername;
    TextView textreadsignup;
    Button btn_signup;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupname = findViewById(R.id.signup_name);
        signupemail = findViewById(R.id.signup_email);
        signuppassword = findViewById(R.id.signup_password);
        signupusername = findViewById(R.id.signup_user);
        textreadsignup = findViewById(R.id.textread_signup);
        btn_signup = findViewById(R.id.btn_signup);

        btn_signup.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupname.getText().toString();
                String email = signupemail.getText().toString();
                String username = signupusername.getText().toString();
                String password = signuppassword.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username,password);
                reference.child(name).setValue(helperClass);

                Toast.makeText(signupActivity.this, "Bạn đã đăng kí thành công", Toast.LENGTH_SHORT).show();
                Intent mhMain= new Intent(signupActivity.this, loginActivity.class);
                startActivity(mhMain);
                return false;
            }
        });

        textreadsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mhMain= new Intent(signupActivity.this, loginActivity.class);
                startActivity(mhMain);
            }
        });

    }
}