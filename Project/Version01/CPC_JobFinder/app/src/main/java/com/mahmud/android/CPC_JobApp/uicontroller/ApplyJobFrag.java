package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.Button;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mahmud.android.CPC_JobApp.R;

import com.mahmud.android.CPC_JobApp.Adapters.JobItemAdapter;
import com.mahmud.android.CPC_JobApp.datasource.local.room.database.DBHelper;

import static java.security.AccessController.getContext;

public class ApplyJobFrag extends AppCompatActivity {

    TextView name, salary, description;
    ImageView image;
    Button applyJobBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);;
    }

    private Bundle bundle;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.bundle = getArguments();
        if (bundle != null) {
            final String jobname = bundle.getString("jobname");
            final String jobsalary = bundle.getString("jobsalary");
            final String jobdesc = bundle.getString("jobdesc");
            final int jobimage = bundle.getInt("jobimage");

            name.setText(jobname);
            salary.setText(jobsalary);
            description.setText(jobdesc);
            image.setImageResource(jobimage);
        }

        else Toast.makeText(getContext(), "jjjj", Toast.LENGTH_SHORT).show();
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_apply_job_frag, container, false);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        name = view.findViewById(R.id.detail_postName);
        salary = view.findViewById(R.id.totalSalary);
        description = view.findViewById(R.id.detailDescription);
        image = view.findViewById(R.id.detailsImage);
        applyJobBtn= view.findViewById(R.id.applyJobBtn);

        DBHelper dbHelper = new DBHelper(getContext());

        applyJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dbHelper.insertJob(bundle.getString("foodprice"), bundle.getInt("foodimage"),
                        bundle.getString("jobdescription"),
                        bundle.getString("jobname")
                );
                if(isInserted){
                    Toast.makeText(getContext(), "You have successfully applied the post", Toast.LENGTH_SHORT).show();}


                else {
                    Toast.makeText(getContext(), "Error applying the job. Try again!", Toast.LENGTH_SHORT).show();}
            }
        });
    }


}