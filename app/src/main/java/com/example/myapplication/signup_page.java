package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup_page extends AppCompatActivity {
    private EditText Email;
    private EditText Password;
    private EditText Name;
    private Button Signup;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        firebaseAuth=FirebaseAuth.getInstance();
        Signup=(Button)findViewById(R.id.submit);
        Name=(EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.password);
        Email=(EditText)findViewById(R.id.email);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=Email.getText().toString().trim();
                String name=Name.getText().toString().trim();
                String password=Password.getText().toString().trim();
                if(TextUtils.isEmpty(name))
                {
                    Toast.makeText(getApplicationContext(),"Name Field can't be blank",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(TextUtils.isEmpty(email))
                    {
                        Toast.makeText(getApplicationContext(),"Email Field can't be blank",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(TextUtils.isEmpty(password))
                        {
                            Toast.makeText(getApplicationContext(),"Password Field can't be blank",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(signup_page.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                        if(task.isSuccessful())
                                        {
                                            Toast.makeText(getApplicationContext(),"Task Sucessfull ",Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(getApplicationContext(),"Task Sucessfull ",Toast.LENGTH_SHORT).show();
                                        }
                                }
                            });
                        }
                    }
                }
            }
        });

    }
}
