package com.mahmud.cpc_jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    private EditText name_reg, id_reg, email_reg, password_reg;
    private Button btn_reg;
    private Button btn_login;

    //Firebase Authentication//
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        //Created separate function for readability
        Registration();

    }

    private void Registration() {
        name_reg = findViewById(R.id.name_register);
        id_reg = findViewById(R.id.id_register);
        email_reg = findViewById(R.id.email_register);
        password_reg = findViewById(R.id.password_register);

        btn_reg = findViewById(R.id.button_register);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = email_reg.getText().toString().trim();
                String pass = password_reg.getText().toString().trim();

                //Validation
                if(TextUtils.isEmpty(email)) {
                    email_reg.setError("Empty Field!");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password_reg.setError("Empty field!");
                    return;
                }
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                // onClick of button perform this simplest code.
                if (email.matches(emailPattern)) {
                    Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                }

                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Successful Register!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), DashboardActivity.class));

                        }

                    }
                });

            }
        });


        btn_login = findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Redirecting to the Login screen
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));


            }
        });







    }


}