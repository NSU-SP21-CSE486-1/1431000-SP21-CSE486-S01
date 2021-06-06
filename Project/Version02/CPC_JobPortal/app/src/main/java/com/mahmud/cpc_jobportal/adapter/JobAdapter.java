package com.mahmud.cpc_jobportal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.mahmud.cpc_jobportal.Model.JobData;
import com.mahmud.cpc_jobportal.R;


public class JobAdapter extends FirebaseRecyclerAdapter<JobData, JobAdapter.myviewholder> {

    public JobAdapter(@NonNull FirebaseRecyclerOptions<JobData> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull JobData model) {
        holder.position_name.setText(model.getPosition());
        holder.date_added.setText(model.getDate());
        holder.description.setText(model.getDescription());
        holder.salary.setText(model.getSalary());
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_post_item, parent, false);
        return new myviewholder(view);

    }

    class myviewholder extends RecyclerView.ViewHolder{

        TextView position_name, date_added, description, salary;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            position_name = (TextView)itemView.findViewById(R.id.job_name);
            date_added =(TextView)itemView.findViewById(R.id.job_post_date);
            description = (TextView) itemView.findViewById(R.id.job_description);
            salary = (TextView) itemView.findViewById(R.id.job_salary);


        }
    }

}
