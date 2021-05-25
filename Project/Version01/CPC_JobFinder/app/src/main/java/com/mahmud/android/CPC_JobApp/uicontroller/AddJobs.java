package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mahmud.android.CPC_JobApp.datasource.local.room.entity.JobInfo;

import java.util.List;

public class AddJobs extends Fragment {
    EditText positionname, jobdetail, jobtype, salary;
    Button submitButton, updateButton;

  private List<JobInfo> JobInfoList;
  JobItemAdapter jobItemAdapter;
  JobInfo jobInfo;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobItemAdapter = new jobItemAdapter(JobInfoList, getContext());
        jobItemAdapter.setTaskModelList(JobInfoList);
        JobInfoList = PrefConfig.readListFromPref(getContext());

    }

    private Bundle bundle;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.bundle = getArguments();

        if(bundle != null){
            final String positionnameFinal = bundle.getString("positionname");
            final String jobdetailFinal = bundle.getString("jobdetail");
            final String jobtypeFinal = bundle.getString("jobtype");
            final String salaryFinal = bundle.getString("salary");
            final int position = bundle.getInt("position");

            positionname.setText(positionnameFinal);
            jobdetail.setText(jobdetailFinal);
            jobtype.setText(jobtypeFinal);
            salary.setText(salaryFinal);

            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    JobInfo = new JobInfo(positionname.getText().toString(),
                            jobdetail.getText().toString(),
                            jobtype.getText().toString(),
                            salary.getText().toString());
                    JobInfoList.set(bundle.getInt("position"), JobInfo);
                    jobItemAdapter

                }
            });

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_jobs);
    }
}