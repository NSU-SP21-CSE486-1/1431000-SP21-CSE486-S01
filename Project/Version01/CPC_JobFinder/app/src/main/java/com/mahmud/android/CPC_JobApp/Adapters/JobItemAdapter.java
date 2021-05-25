package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mahmud.android.CPC_JobApp.entity.JobInfoViewModel;

import java.util.List;

public class JobItemAdapter extends RecyclerView.Adapter<JobItemAdapter.viewHolder> {

    List<JobInfoViewModel> list;
    Context context;

    public JobItemAdapter(List<JobInfoViewModel> list){
        this.list = list;
        this.context = context;
    }

    public void setTaskModelList(List<JobInfoViewModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        return new viewHolder(view);
        return null;
    }
}
