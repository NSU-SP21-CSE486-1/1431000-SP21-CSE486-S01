package com.mahmud.android.CPC_JobApp.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmud.android.CPC_JobApp.R;
import com.mahmud.android.CPC_JobApp.datasource.local.room.database.DBHelper;

import com.mahmud.android.CPC_JobApp.entity.StudentApplyModel;

import java.util.ArrayList;

public class StudentApplyAdapter  extends RecyclerView.Adapter<StudentApplyAdapter.viewHolder>{


    ArrayList<StudentApplyModel> list;
    Context context;

    public StudentApplyAdapter(ArrayList<StudentApplyModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_student_apply, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final StudentApplyModel model = list.get(position);
        holder.appliedJobImage.setImageResource(model.getApplyImage());
        holder.appliedJobSalary.setText(model.getSalary());
        holder.appliedJobName.setText(model.getAppliedJob());
        holder.appliedID.setText(model.getApplyNumber());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DBHelper dbHelper = new DBHelper(context);
                new AlertDialog.Builder(context).setTitle("Delete")
                        .setIcon(R.drawable.ic_remove).setMessage("Are you sure you want to delete this Job application?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.deleteJob(model.getApplyNumber());
                                Toast.makeText(context, "Your job application was removed!", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                }).show();


                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView appliedJobImage;
        TextView appliedJobSalary, appliedJobName, appliedID;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            appliedJobImage = (ImageView) itemView.findViewById(R.id.orderedImageView);
            appliedJobSalary = (TextView) itemView.findViewById(R.id.appliedjobSalary);
            appliedID = (TextView) itemView.findViewById(R.id.ApplyID);
            appliedJobName = (TextView) itemView.findViewById(R.id.appliedJobName);
        }


    }

}
