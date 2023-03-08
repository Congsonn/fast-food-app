package com.example.fastfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class loginActivity extends AppCompatActivity {

    EditText loginuser, loginpassword;
    Button btnlogin;
    TextView textreadlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginuser = findViewById(R.id.login_user);
        loginpassword = findViewById(R.id.login_password);
        btnlogin = findViewById(R.id.btn_login);
        textreadlogin = findViewById(R.id.textread_login);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validatepassword()){
                }else {
                    checkuser();
                }
            }
        });

        textreadlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });

    }

    public boolean validateUsername(){
        String val = loginuser.getText().toString();
        if (val.isEmpty()){
            loginuser.setError("Tên đăng nhập chưa đúng");
            return false;
        }else {
            loginuser.setError(null);
            return true;
        }
    }

    public boolean validatepassword(){
        String val = loginpassword.getText().toString();
        if (val.isEmpty()){
            loginpassword.setError("Mật Khẩu chưa đúng");
            return false;
        }else {
            loginpassword.setError(null);
            return true;
        }
    }

    public void checkuser(){
        String username = loginuser.getText().toString().trim();
        String password = loginpassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        Query checkUserDataBase = reference.orderByChild("username").equalTo(username);

        checkUserDataBase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.exists()){
                    loginuser.setError(null);
                    String PasswordFormDB = snapshot.child(username).child("password").getValue(String.class);

                    if (!Objects.equals(PasswordFormDB,password)){
                        loginuser.setError(null);
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }else{
                        loginpassword.setError("Invallit Credentials");
                        loginpassword.requestFocus();
                    }
                }else {
                    loginpassword.setError("user do not exist!");
                    loginpassword.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}