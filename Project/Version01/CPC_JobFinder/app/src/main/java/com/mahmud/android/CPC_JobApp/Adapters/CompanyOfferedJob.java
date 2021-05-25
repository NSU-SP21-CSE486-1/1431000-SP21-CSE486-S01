package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyOfferedJob extends RecyclerView.Adapter<CompanyOfferedJob.viewHolder> {

   ArrayList<CompanyOfferedJob> list;
   Context context;

   public CompanyOfferedJob(ArrayList<CompanyOfferedJob> list, Context context){
       this.list = list;
       this.context = context;
   }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(android.R.layout.)
    }
}
