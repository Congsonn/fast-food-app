package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.fastfood.databinding.ActivitySignupBinding;

public class signupActivity extends AppCompatActivity {

    ActivitySignupBinding binding;
    Sql_database sql_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sql_database = new Sql_database(this );

        binding.btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String signup_confirm = binding.signupConfirm.getText().toString();
                //System.out.println("hop la con bo: " + "|" + email + "|" + password + "|" + signup_confirm);

                if(email.equals("") || password.equals("") || signup_confirm.equals(""))
                    Toast.makeText(signupActivity.this, "nhập gì đó ....", Toast.LENGTH_SHORT).show();
                else {
                    if(password.equals(signup_confirm)){
                        boolean check_useremail = sql_database.check_email(email);

                        if (check_useremail == false){
                            boolean insert = sql_database.insertData(email, password);

                            if (insert == true){
                                Toast.makeText(signupActivity.this, "Đăng Kí Thành Công.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(signupActivity.this, "Đăng Kí Thất Bại.", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(signupActivity.this, "Tài Khoản đã tồn tại.", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(signupActivity.this, "Mật Khẩu Không Khớp", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.loginText.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext() , loginActivity.class);
            startActivity(intent);
        }
    });
    }
}