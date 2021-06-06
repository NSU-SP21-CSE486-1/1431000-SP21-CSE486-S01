package com.mahmud.cpc_jobportal.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mahmud.cpc_jobportal.R;

public class MainActivity extends AppCompatActivity {

    Button companyJoin, studentJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        companyJoin = findViewById(R.id.btn_companyjoin);
        studentJoin = findViewById(R.id.btn_studentjoin);

        companyJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CompanyLoginActivity.class));
            }
        });

        studentJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StudentLoginActivity.class));

            }
        });

    }
}