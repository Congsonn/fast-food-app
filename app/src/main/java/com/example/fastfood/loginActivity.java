package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fastfood.databinding.ActivityLoginBinding;



public class loginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    Sql_database sql_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sql_database = new Sql_database(this );

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if(email.equals("") || password.equals(""))
                    Toast.makeText(loginActivity.this, "Vui Lòng Nhập Thông Tin.", Toast.LENGTH_SHORT).show();
                else{
                    boolean check_email_password = sql_database.check_email_password( email, password);

                    if(check_email_password == true){
                        Toast.makeText(loginActivity.this, "Đăng Nhập Thành Công.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this, "Mật Khẩu Không Khớp.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });
    }
}