package com.mahmud.cpc_jobportal.ui;

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
import com.mahmud.cpc_jobportal.R;

public class StudentLoginActivity extends AppCompatActivity {

    private EditText email, password;

    private Button btn_login_student;
    private Button btn_register_student;

    private FirebaseAuth mAuth; //Firebase auth
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);

        //Created Separate Function for code readability
        LoginFunction();
    }

    private void LoginFunction(){
        email = findViewById(R.id.email_login_student);
        password = findViewById(R.id.password_login_student);

        btn_login_student = findViewById(R.id.button_login_student);
        btn_register_student = findViewById(R.id.button_register_student);

        btn_login_student.setOnClickListener(new View.OnClickListener() {
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
                            startActivity(new Intent(getApplicationContext(), StudentDashboardActivity.class));

                            mDialog.dismiss();
                        }else{
                            Toast.makeText(getApplicationContext(), "Login Failed. Enter Again!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        btn_register_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentRegisterActivity.class));

            }
        });


    }
}