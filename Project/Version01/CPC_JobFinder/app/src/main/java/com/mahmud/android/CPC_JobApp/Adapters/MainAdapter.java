package com.mahmud.android.CPC_JobApp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.entity.MainModel;
import com.mahmud.android.CPC_JobApp.uicontroller.OfferedJobFrag;

import java.util.ArrayList;



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //Inflate layout
        View view = LayoutInflater.from(context).inflate(R.layout.sample_student_home_job_fragment, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        //data bind
        final MainModel model = list.get(position);
        holder.DashboardjobImage.setImageResource(model.getImage());
        holder.DashboardpositionName.setText(model.getName());
        holder.DashboardJobDescription.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment thisfragment = new Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OfferedJobFrag()).addToBackStack(null).commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView DashboardjobImage;
        TextView DashboardpositionName, DashboardJobDescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            DashboardjobImage = (ImageView) itemView.findViewById(R.id.job_image);
            DashboardpositionName = (TextView) itemView.findViewById(R.id.companyname);
            DashboardJobDescription = (TextView) itemView.findViewById(R.id.job_bio);
        }
    };
}
