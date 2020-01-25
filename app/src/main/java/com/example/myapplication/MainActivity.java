package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.loginbt);
        signup=(Button) findViewById(R.id.signupbt);

        System.out.println("Hello World");
        System.out.println(login);
        System.out.println(signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup_page();
            }
        });




    }

    public void login()
    {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }

    public void signup_page()
    {
        System.out.println("Hello");
        Intent intent=new Intent(this,signup_page.class);
        startActivity(intent);
    }
}
