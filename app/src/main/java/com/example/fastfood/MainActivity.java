package com.example.fastfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewdanhsachdoanList,recyclerViewdoanphobienList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewdanhsachdoan();
        recyclerViewdoanphobien();
    }

    private void recyclerViewdoanphobien() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewdoanphobienList = findViewById(R.id.view2);
        recyclerViewdoanphobienList.setLayoutManager(linearLayoutManager);

        ArrayList<doanphobien> doanphobienlist = new ArrayList<>();
        doanphobienlist.add(new doanphobien("Pepperoni pizza","pizza1","slices peperoni,mozzarella cheese,fresh oregano,ground black pepper,pizza sauce", 135.000,5,20,1000));
        doanphobienlist.add(new doanphobien("Cheese Burger ","burger","beef,Gouda Cheese,Special sauce,Lettuce,tomato", 35.000,4,18,1500));
        doanphobienlist.add(new doanphobien("Vagetable pizza","pizza3","olive oil,Vegetable oil,pitted Kalamata,cherry tomatoes,fresh oregano,basil", 125.000,3,16,800));

        adapter2 = new doanphobienAdapter(doanphobienlist);
        recyclerViewdoanphobienList.setAdapter(adapter2);
    }

    private void recyclerViewdanhsachdoan() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewdanhsachdoanList = findViewById(R.id.view1);
        recyclerViewdanhsachdoanList.setLayoutManager(linearLayoutManager);

        ArrayList<danhsachdoan> danhsachdoanList = new ArrayList<>();
        danhsachdoanList.add(new danhsachdoan("Pizza","cat_1"));
        danhsachdoanList.add(new danhsachdoan("Burger","cat_2"));
        danhsachdoanList.add(new danhsachdoan("Hotdog","cat_3"));
        danhsachdoanList.add(new danhsachdoan("Drink","cat_4"));
        danhsachdoanList.add(new danhsachdoan("Donut","cat_5"));

        adapter = new danhsachdoanAdapter(danhsachdoanList);
        recyclerViewdanhsachdoanList.setAdapter(adapter);
    }
}