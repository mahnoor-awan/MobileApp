package com.example.clothinghouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    String email, password, confirm_password;
    EditText user_email, user_password, user_confirm_password;
    Button signUp_button;
    FirebaseAuth user;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        user = FirebaseAuth.getInstance();
//        text under SignUp Button
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signUp_button = findViewById(R.id.btnSignUp);
        signUp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
    }

    private void signUpUser(){
        user_email = findViewById(R.id.etEmailAddress);
        user_password = findViewById(R.id.etPassword);
        user_confirm_password = findViewById(R.id.etConfirmPassword);
        email = user_email.getText().toString();
        password = user_password.getText().toString();
        confirm_password = user_confirm_password.getText().toString();

        if (email.isEmpty() || password.isEmpty() || confirm_password.isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Email and Password can't be empty", Toast.LENGTH_SHORT).show();
            return;
        }


        if (!password.equals(confirm_password)){
            Log.d("mahnoor",password);
            Log.d("mahnoor",confirm_password);
            Toast.makeText(SignUpActivity.this, "Password do not match", Toast.LENGTH_SHORT).show();
            return;

        }

        user.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(SignUpActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    Log.d("mahnoor", "createUserWithEmail:success");
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("mahnoor", "createUserWithEmail:failure", task.getException());
                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}