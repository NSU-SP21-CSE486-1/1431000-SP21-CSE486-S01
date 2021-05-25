package com.mahmud.android.CPC_JobApp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.mahmud.android.CPC_JobApp.viewmodel.JobInfoViewModel;

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
