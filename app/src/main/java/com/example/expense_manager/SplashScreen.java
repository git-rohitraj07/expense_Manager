package com.example.expense_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        getActionBar().hide();
        Objects.requireNonNull(getSupportActionBar()).hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(FirebaseAuth.getInstance().getCurrentUser()!=null){
                    startActivity(new Intent(getApplicationContext(),ContentActivity.class));
                    finish();

                }
                else{
                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                    finish();
                }
            }
        },1000);
    }
}