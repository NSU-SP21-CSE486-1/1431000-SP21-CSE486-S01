package com.mahmud.android.CPC_JobApp.uicontroller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.datasource.local.room.database.DBHelper;
import com.mahmud.android.CPC_JobApp.entity.StudentApplyModel;

import java.util.ArrayList;

public class StudentApplyFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_student_apply_fragment, container,false);
        recyclerView = view.findViewById(R.id.)
        recyclerView = view.findViewById(R.id.orderedRecyclerView);


        DBHelper helper = new DBHelper(getContext());
        ArrayList<StudentApplyModel> list = helper.getOrders();


        CustomerOrderAdapter adapter = new CustomerOrderAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }