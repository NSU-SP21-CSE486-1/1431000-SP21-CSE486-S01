package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.JobInfoViewModel;

import java.util.ArrayList;

public class JobCompanyAdapter extends RecyclerView.Adapter<JobCompanyAdapter.viewholder> {

    ArrayList<JobInfoViewModel> list;
    Context context;

    public JobCompanyAdapter(ArrayList<JobInfoViewModel> list, Context context){


    }


}
