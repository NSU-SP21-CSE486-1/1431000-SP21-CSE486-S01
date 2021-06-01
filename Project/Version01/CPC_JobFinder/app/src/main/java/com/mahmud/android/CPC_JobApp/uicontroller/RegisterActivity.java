package com.mahmud.android.CPC_JobApp.uicontroller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mahmud.android.CPC_JobApp.R;

import java.util.HashMap;



public class RegisterActivity extends AppCompatActivity {


    private EditText name;
    private EditText email;
    private EditText password;
    private Button register;
    private TextView loginUser;

    //Firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        Registration();



    }

    private void Registration() {
        name = findViewById(R.id.name_registration);
        email = findViewById(R.id.email_registration);
        password = findViewById(R.id.password_registration);

        register = findViewById(R.id.register_button);
        loginUser = findViewById(R.id.login_user);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if(TextUtils.isEmpty(em)){
                    email.setError("Required Field");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.setError("Required Field");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(em, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Successful Registration", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext()), Home_fragment.class);
                        }

                    }
                });


            }
        });

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });

    }
}