package com.example.fastfood;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class doanphobienAdapter extends RecyclerView.Adapter<doanphobienAdapter.ViewHolder> {
    ArrayList<doanphobien> doanphobiens;

    public doanphobienAdapter(ArrayList<doanphobien> doanphobiens) {
        this.doanphobiens = doanphobiens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_doanphobien,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull doanphobienAdapter.ViewHolder holder, int position) {
        holder.title.setText(doanphobiens.get(position).getTitle());
        holder.fee.setText(String.valueOf(doanphobiens.get(position).getFee()));

        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(doanphobiens.get(position).getPic(),"drawabble",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return doanphobiens.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,fee;
        ImageView pic;
        ImageView addBtn;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.title);
            pic = itemView.findViewById(R.id.pic);
            fee = itemView.findViewById(R.id.fee);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
