package com.example.fastfood;

import static android.app.PendingIntent.getActivity;

import static java.security.AccessController.getContext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements updatedapb {
    RecyclerView danhsachdoanRec,doanphobienRec;
    ArrayList<danhsachdoan> danhsachdoanList;
    danhsachdoanAdapter danhsachdoanAdapter;

    ArrayList<doanphobien> doanphobienList;

    doanphobienAdapter doanphobienAdapter;

    ImageView imgToi, giohang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhsachdoanRec =  findViewById(R.id.view1);
        doanphobienRec = findViewById(R.id.view2);

        danhsachdoanList = new ArrayList<>();
        danhsachdoanList.add(new danhsachdoan(R.drawable.cat_1,"Pizza"));
        danhsachdoanList.add(new danhsachdoan(R.drawable.cat_2,"HamBurger"));
        danhsachdoanList.add(new danhsachdoan(R.drawable.bread,"Bánh mì"));
        danhsachdoanList.add(new danhsachdoan(R.drawable.cat_4,"Drink"));
        danhsachdoanList.add(new danhsachdoan(R.drawable.duiga,"Đùi gà"));

        danhsachdoanAdapter = new danhsachdoanAdapter((updatedapb) this, (Activity) getActivity(),danhsachdoanList);
        danhsachdoanRec.setAdapter(danhsachdoanAdapter);
        danhsachdoanRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        danhsachdoanRec.setHasFixedSize(true);
        danhsachdoanRec.setNestedScrollingEnabled(false);

        doanphobienList = new ArrayList<>();

        doanphobienAdapter = doanphobienAdapter(getActivity(),doanphobienList);
        doanphobienRec.setAdapter(doanphobienAdapter);
        doanphobienRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


        imgToi = (ImageView)findViewById(R.id.imgToi);
        imgToi.setOnClickListener(v -> {
            Intent mhtt = new Intent(MainActivity.this,thongtin.class);
            startActivity(mhtt);
        });

        giohang = (ImageView)findViewById(R.id.btn_giohang);
        giohang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,GiohangActivity.class);
            startActivity(intent);
        });


    }

    private com.example.fastfood.doanphobienAdapter doanphobienAdapter(Context activity, List<doanphobien> doanphobienList) {
        return new doanphobienAdapter(activity, (ArrayList<doanphobien>) doanphobienList);
    }


    private Context getActivity() {
        return null;
    }


    @Override
    public void callBack(int position, ArrayList<doanphobien> list) {

        doanphobienAdapter = new doanphobienAdapter(getActivity(),list);
        doanphobienAdapter.notifyDataSetChanged();
        doanphobienRec.setAdapter(doanphobienAdapter);

    }
}