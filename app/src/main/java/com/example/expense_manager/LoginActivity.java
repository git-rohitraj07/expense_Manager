package com.example.expense_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPass;
    private Button btnLogin;
    private TextView mForgetPassword;
    private TextView mSignUp;
    private FirebaseAuth mauth;
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
                FirebaseAuth mauth=FirebaseAuth.getInstance();
                mauth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    startActivity(new Intent(getApplicationContext(),ContentActivity.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(),"Error occured",Toast.LENGTH_LONG).show();
                                }
                            }
                        });

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