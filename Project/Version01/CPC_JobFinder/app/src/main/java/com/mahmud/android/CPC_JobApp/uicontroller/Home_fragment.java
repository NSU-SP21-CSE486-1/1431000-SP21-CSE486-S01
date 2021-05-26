package com.mahmud.android.CPC_JobApp.uicontroller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.Adapters.MainAdapter;
import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.MainModel;

import java.util.ArrayList;

public class Home_fragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_fragment, container,false);
        recyclerView = view.findViewById(R.id.customerchefHomeFrag);

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.UXDesigner, "GrameenPhone", "UX Designer needed"));
        list.add(new MainModel(R.drawable.DataAnalyst, "Airtel",  "Looking for a Data Analyst"));
        list.add(new MainModel(R.drawable.softwareengineer, "Telco Co.",  "Needed a backend Software Engineer"));
        list.add(new MainModel(R.drawable.UXDesigner, "Soft Co.", "Need a creative UX/UI designer"));

        MainAdapter adapter = new MainAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;

    }
}