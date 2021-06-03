package com.mahmud.cpc_jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;

    private Button btn_login;
    private Button btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Created Separate Function for code readability
        LoginFunction();
    }

    private void LoginFunction(){
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);

        btn_login = findViewById(R.id.button_login);
        btn_register = findViewById(R.id.button_register);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                
            }
        });


    }
}