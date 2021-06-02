package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.entity.CompanyOfferedJobModel;

import com.mahmud.android.CPC_JobApp.R;

import java.util.ArrayList;

public class CompanyOfferedJobAdapter extends RecyclerView.Adapter<CompanyOfferedJobAdapter.viewHolder> {

   ArrayList<CompanyOfferedJobModel> list;
   Context context;

   public CompanyOfferedJobAdapter(ArrayList<CompanyOfferedJobAdapter> list, Context context){
       this.list = list;
       this.context = context;
   }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.sample_student_dashboard, parent, false);
       return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final CompanyOfferedJobModel model = list.get(position);
        holder.offJobImage.setImageResource(model.getOfferedJobImage());
        holder.offPositionName.setText(model.getOfferedPositionName());
        holder.offSalary.setText(model.getOfferedSalary());
        holder.offJobDescription.setText(model.getOfferedJobDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();

            }
        });




    }




    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView offJobImage;
        TextView offPositionName, offSalary, offJobDescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            offJobImage = (ImageView) itemView.findViewById(R.id.food_image);
            offPositionName = (TextView) itemView.findViewById(R.id.postName);
            offSalary = (TextView) itemView.findViewById(R.id.salary_tv);
            offJobDescription = (TextView) itemView.findViewById(R.id.job_bio);
        }


    }
    ;
}

