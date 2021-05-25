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

import com.mahmud.android.CPC_JobApp.entity.MainModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter>.viewholder {

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
        View view = LayoutInflater.from(context).inflate(R.layout.sample_customer_home_chef_fragment, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        //data bind
        final MainModel model = list.get(position);
        holder.DashboardfoodImage.setImageResource(model.getImage());
        holder.DashboardfoodName.setText(model.getName());
        holder.Dashboarddescription.setText(model.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                Fragment myFragment = new Fragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Offered_food_items_fragment()).addToBackStack(null).commit();

            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        ImageView DashboardfoodImage;
        TextView DashboardfoodName, Dashboarddescription;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            DashboardfoodImage = (ImageView) itemView.findViewById(R.id.chef_food_image);
            DashboardfoodName = (TextView) itemView.findViewById(R.id.chefOutletName);
            Dashboarddescription = (TextView) itemView.findViewById(R.id.chef_bio);
        }
    };
}
