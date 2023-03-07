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

public class danhsachdoanAdapter extends RecyclerView.Adapter<danhsachdoanAdapter.ViewHolder> {
    ArrayList<danhsachdoan> danhsachdoans;

    public danhsachdoanAdapter(ArrayList<danhsachdoan> danhsachdoans) {
        this.danhsachdoans = danhsachdoans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_danhsachdoan,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull danhsachdoanAdapter.ViewHolder holder, int position) {
        holder.danhsachdoanName.setText(danhsachdoans.get(position).getTitle());
        String piUrl="";
        switch (position){
            case 0:{
                piUrl = "cat_1";
                break;
            }
            case 1:{
                piUrl = "cat_2";
                break;
            }
            case 2:{
                piUrl = "cat_3";
                break;
            }
            case 3:{
                piUrl = "cat_4";
                break;
            }
            case 5:{
                piUrl = "cat_5";
                break;
            }
        }
        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(piUrl,"drawabble",
                        holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.danhsachdoanPic);
    }

    @Override
    public int getItemCount() {
        return danhsachdoans.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView danhsachdoanName;
        ImageView danhsachdoanPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            danhsachdoanName = itemView.findViewById(R.id.danhsachdoanName);
            danhsachdoanPic = itemView.findViewById(R.id.danhsachdoanPic);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
