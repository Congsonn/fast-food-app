package com.example.fastfood;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class danhsachdoanAdapter extends RecyclerView.Adapter<danhsachdoanAdapter.ViewHolder> {

    updatedapb updatedapb;
    Activity activity;
    ArrayList<danhsachdoan> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public danhsachdoanAdapter(updatedapb updatedapb, Activity activity, ArrayList<danhsachdoan> list) {
        this.updatedapb = updatedapb;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_danhsachdoan,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull danhsachdoanAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       holder.imageView.setImageResource(list.get(position).getPic());
       holder.name.setText(list.get(position).getName());

       if (check) {
           ArrayList<doanphobien> doanphobiens = new ArrayList<>();
           doanphobiens.add(new doanphobien(R.drawable.pizza1, "Pizza rau củ ", "10:00 - 23:00", "5.0", "85.000VNĐ"));
           doanphobiens.add(new doanphobien(R.drawable.pizza2, "Pizza xúc xích", "10:00 - 23:00", "5.0", "100.000VNĐ"));
           doanphobiens.add(new doanphobien(R.drawable.pizza3, "Pizza hải sản", "10:00 - 23:00", "5.0", "125.000VNĐ"));
           doanphobiens.add(new doanphobien(R.drawable.pizza4, "Pizza thập cẩm", "10:00 - 23:00", "5.0", "150.000VNĐ"));

           updatedapb.callBack(position, doanphobiens);
           check = false;
       }
           holder.cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   row_index = position;
                   notifyDataSetChanged();

                   if (position == 0){

                       ArrayList<doanphobien> doanphobiens = new ArrayList<>();
                       doanphobiens.add(new doanphobien(R.drawable.pizza1,"Pizza rau củ ","10:00 - 23:00","5.0","55.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.pizza2,"Pizza xúc xích","10:00 - 23:00","5.0","100.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.pizza3,"Pizza hải sản ","10:00 - 23:00","5.0","125.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.pizza4,"Pizza thập cẩm ","10:00 - 23:00","5.0","150.000VNĐ"));

                       updatedapb.callBack(position,doanphobiens);
                   }
                   else if (position == 1){

                       ArrayList<doanphobien> doanphobiens = new ArrayList<>();
                       doanphobiens.add(new doanphobien(R.drawable.burger1,"HamBurger sốt me ","10:00 - 23:00","5.0","27.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.burger2,"HamBurger sốt trứng ","10:00 - 23:00","5.0","30.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.burger4,"HamBurger  kẹp bơ","10:00 - 23:00","5.0","35.000VNĐ"));

                       updatedapb.callBack(position,doanphobiens);

                   }
                   else if (position == 2){

                       ArrayList<doanphobien> doanphobiens = new ArrayList<>();
                       doanphobiens.add(new doanphobien(R.drawable.banhmi1,"Bánh mì bate ","10:00 - 23:00","5.0","12.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.banhmi2,"Bánh mì sá xíu ","10:00 - 23:00","5.0","15.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.banhmi3,"Bánh mì thập cẩm ","10:00 - 23:00","5.0","17.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.banhmi4,"Bánh mì thịt  ","10:00 - 23:00","5.0","20.000VNĐ"));

                       updatedapb.callBack(position,doanphobiens);

                   }
                   else if (position == 3){

                       ArrayList<doanphobien> doanphobiens = new ArrayList<>();
                       doanphobiens.add(new doanphobien(R.drawable.drink1,"Bạc xỉu ","10:00 - 23:00","5.0","35.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.drink2,"Cam ép ","10:00 - 23:00","5.0","30.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.drink3,"Sinh tố dưa hấu ","10:00 - 23:00","5.0","30.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.drink4,"Sinh tố bơ ","10:00 - 23:00","5.0","30.000VNĐ"));

                       updatedapb.callBack(position,doanphobiens);

                   }
                   else if (position == 4){

                       ArrayList<doanphobien> doanphobiens = new ArrayList<>();
                       doanphobiens.add(new doanphobien(R.drawable.duiga1,"Đùi gà sốt tương ","10:00 - 23:00","5.0","30.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.duiga2,"Đùi gà chiên xù ","10:00 - 23:00","5.0","25.000VNĐ"));
                       doanphobiens.add(new doanphobien(R.drawable.duiga3,"Đùi gà bơ ","10:00 - 23:00","5.0","30.000VNĐ"));

                       updatedapb.callBack(position,doanphobiens);

                   }
               }
           });

           if (select){
               if (position == 0){
                   holder.cardView.setBackgroundResource(R.drawable.change_btron);
                   select = false;

               }
           }
           else {
               if(row_index == position){
                   holder.cardView.setBackgroundResource(R.drawable.change_btron);

               }else {
                   holder.cardView.setBackgroundResource(R.drawable.default_btron);
               }
           }
       }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.danhsachdoanPic);
            name = itemView.findViewById(R.id.danhsachdoanName);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
