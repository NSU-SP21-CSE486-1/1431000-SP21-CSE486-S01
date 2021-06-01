package com.mahmud.android.CPC_JobApp.uicontroller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mahmud.android.CPC_JobApp.R;

public class LoginActivity extends AppCompatActivity {


    //private static String LOG_TAG = "login_log"; //LOG


    private EditText email, password;
    private Button login;
    private TextView registerUser;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFunction();

    }

    private void LoginFunction(){

        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);

        login = findViewById(R.id.login_button);
        registerUser = findViewById(R.id.register_user);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        registerUser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

           }
       });

    }

}