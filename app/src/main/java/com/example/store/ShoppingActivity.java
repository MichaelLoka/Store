package com.example.store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity
{
    public static int[] productIds ={
            R.drawable.iphone_xs, R.drawable.samsung_a50, R.drawable.dell_g3,
            R.drawable.dell_g5, R.drawable.airpods, R.drawable.ps4_controller,
            R.drawable.lenovo_p11_pro, R.drawable.ideapad_g3, R.drawable.i7,
            R.drawable.gtx
    };
    List<String> Descriptions;
    List<Integer> images;
    List<String> Price;
    RecyclerView datalist;
    Adapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        datalist = findViewById(R.id.datalist);

        Descriptions = new ArrayList<>();
        images = new ArrayList<>();
        Price = new ArrayList<>();

        Descriptions.add("IPhone XS");
        Descriptions.add("Samsung A50");
        Descriptions.add("Laptop Dell G3");
        Descriptions.add("Laptop Dell G5");
        Descriptions.add("Apple Airpods");
        Descriptions.add("PS4 Controller");
        Descriptions.add("Lenovo Tablet P11 Pro");
        Descriptions.add("Lenovo Ideapad Gaming 3");
        Descriptions.add("Intel Core i7 7700K");
        Descriptions.add("Geforce GTX 1660Ti");

        images.add(R.drawable.iphone_xs);
        images.add(R.drawable.samsung_a50);
        images.add(R.drawable.dell_g3);
        images.add(R.drawable.dell_g5);
        images.add(R.drawable.airpods);
        images.add(R.drawable.ps4_controller);
        images.add(R.drawable.lenovo_p11_pro);
        images.add(R.drawable.ideapad_g3);
        images.add(R.drawable.i7);
        images.add(R.drawable.gtx);

        Price.add("$11000");
        Price.add("$5500");
        Price.add("$13000");
        Price.add("$17000");
        Price.add("3500");
        Price.add("$900");
        Price.add("$6000");
        Price.add("$17000");
        Price.add("$7500");
        Price.add("6600");

        myadapter = new Adapter(this,Descriptions,images,Price);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2,RecyclerView.VERTICAL,false);
        datalist.setLayoutManager(gridLayoutManager);
        datalist.setAdapter(myadapter);
    }
}