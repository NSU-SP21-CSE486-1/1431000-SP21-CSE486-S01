package com.mahmud.android.CPC_JobApp.uicontroller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.mahmud.android.CPC_JobApp.Adapters.JobItemAdapter;
import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.JobInfo;

import java.util.List;

public class JobDashboard extends Fragment {

    Button addJobButton;
    private List<JobInfo> JobInfoList;
    RecyclerView recyclerView;
    JobItemAdapter jobItemAdapter;

    @Nullable
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JobInfoList = PrefConfig.readListFromPref(getContext());
        JobItemAdapter = new JobItemAdapter(JobInfoList, getContext());
        JobItemAdapter.setTaskModelList(JobInfoList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_job_dashboard, container, false );

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        recyclerView = view.findViewById(R.id.jobLists);
        addJobButton = view.findViewById(R.id.dash_post_job);

        recyclerView.setHasFixedSize(true);

        addJobButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new AddFoodItemsFrag());
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(jobItemAdapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }
}