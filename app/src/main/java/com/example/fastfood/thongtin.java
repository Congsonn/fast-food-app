package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class thongtin extends AppCompatActivity {
    LinearLayout clicklogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);

        clicklogin = findViewById(R.id.click_login);
        clicklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent click_login = new Intent(thongtin.this, loginActivity.class);
                startActivity(click_login);
            }
        });

    }
}