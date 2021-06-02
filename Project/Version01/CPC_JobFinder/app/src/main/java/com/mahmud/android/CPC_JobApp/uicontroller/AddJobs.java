package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mahmud.android.CPC_JobApp.entity.JobInfoModel;

import java.util.List;

public class AddJobs extends Fragment {
    EditText positionname, jobdetail, jobtype, salary;
    Button submitButton, updateButton;

  private List<JobInfoModel> jobInfoModelList;
  JobItemAdapter jobItemAdapter;
  JobInfoModel jobInfoModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jobItemAdapter = new jobItemAdapter(jobInfoModelList, getContext());
        jobItemAdapter.setTaskModelList(jobInfoModelList);
        jobInfoModelList = PrefConfig.readListFromPref(getContext());

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
                    JobInfoModel = new JobInfoModel(positionname.getText().toString(),
                            jobdetail.getText().toString(),
                            jobtype.getText().toString(),
                            salary.getText().toString());
                    jobInfoModelList.set(bundle.getInt("position"), JobInfoModel);


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