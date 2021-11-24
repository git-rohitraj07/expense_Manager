package com.example.expense_manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Registration extends AppCompatActivity {
    private EditText mEmail;
    private EditText mPass;
    private Button btnReg;
    private TextView mSignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mEmail=findViewById(R.id.email_reg);
        mPass=findViewById(R.id.password_reg);
        btnReg=findViewById(R.id.btn_reg);
        mSignin=findViewById(R.id.signin_here);
        mSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
    }
    private void registration()
    {
        String email=mEmail.getText().toString().trim();
        String pass=mPass.getText().toString().trim();
        if(TextUtils.isEmpty(email))
        {
            mEmail.setError("Email required..");
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            mPass.setError("Password required..");
            return;
        }
        FirebaseAuth mauth=FirebaseAuth.getInstance();
        mauth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "User Account Created Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),ContentActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Network error occurred", Toast.LENGTH_SHORT).show();
//                            Log.e("signup failed")
                        }
                    }
                });
    }
}