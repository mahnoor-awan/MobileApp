package com.example.clothinghouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class LoginIntro extends AppCompatActivity {
    FirebaseAuth user;
    Button btn_get_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_intro);
        user = FirebaseAuth.getInstance();
        if(user.getCurrentUser()!=null) {
            Toast.makeText(LoginIntro.this,"User is already Logged In!", Toast.LENGTH_SHORT).show();
            redirect("MAIN");
        }

        btn_get_start = findViewById(R.id.btnGetStarted);
        btn_get_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirect("LOGIN");
            }
        });
    }

    private void redirect(String name) {
        if(name.equals("LOGIN")){
            Intent intent = new Intent(LoginIntro.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }

        else if(name.equals("MAIN")){
            Intent intent=new Intent(LoginIntro.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            throw new java.lang.RuntimeException("this is not quite as bad");
        }
    }
}