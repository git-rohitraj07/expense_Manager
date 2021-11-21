package com.example.expense_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPass;
    private Button btnLogin;
    private TextView mForgetPassword;
    private TextView mSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginDetails();
    }
    private void loginDetails()
    {
        mEmail=findViewById(R.id.email_login);
        mPass=findViewById(R.id.password_login);
        btnLogin=findViewById(R.id.btn_login);
        mForgetPassword=findViewById(R.id.forgot_password);
        mSignUp=findViewById(R.id.signup_reg);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mEmail.getText().toString().trim();
                String pass=mPass.getText().toString().trim();
                if(TextUtils.isEmpty(email))
                {
                    mEmail.setError("Email Required..");
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    mPass.setError("Password Required..");
                    return;
                }

            }
        });
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Registration.class));
            }
        });
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Reset.class ));
            }
        });
    }
}