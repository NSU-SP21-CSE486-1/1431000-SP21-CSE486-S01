package com.mahmud.cpc_jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;

    private Button btn_login;
    private Button btn_register;

    private FirebaseAuth mAuth; //Firebase auth
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

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
                String mEmail = email.getText().toString().trim();
                String mPassword = password.getText().toString().trim();

                if(TextUtils.isEmpty(mEmail)){
                    email.setError("Empty Field!");
                    return;
                }
                if(TextUtils.isEmpty(mPassword)){
                    password.setError("Empty Field!");
                    return;
                }

                mDialog.setMessage("Processing!");
                mDialog.show();
                mAuth.signInWithEmailAndPassword(mEmail, mPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Correct Credentials, Successful!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), JobDashboardActivity.class));

                                mDialog.dismiss();
                            }else{
                                Toast.makeText(getApplicationContext(), "Login Failed. Enter Again!", Toast.LENGTH_SHORT).show();
                            }
                            
                    }
                });

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