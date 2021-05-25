package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.viewmodel.JobInfoViewModel;

import java.util.ArrayList;
import java.util.List;

public class CompanyOfferedJob extends RecyclerView.Adapter<CompanyOfferedJob.viewHolder> {

   ArrayList<CompanyOfferedJob> list;
   Context context;

   public CompanyOfferedJob(ArrayList<CompanyOfferedJob> list, Context context){
       this.list = list;
       this.context = context;
   }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_student_dashboard, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final JobInfoViewModel model = list.get(position);



    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView offJobImage;
        TextView offPositionName, offSalary, offJobDescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            offJobImage = (ImageView) itemView.findViewById(R.id.food_image);
            offPositionName = (TextView) itemView.findViewById(R.id.postName);
            offSalary = (TextView) itemView.findViewById(R.id.salary_tv);
            offJobDescription = (TextView) itemView.findViewById(R.id);
        }
    }
    ;
}

