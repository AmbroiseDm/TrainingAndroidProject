package com.example.javarecyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> imageList = new ArrayList<>();
    private ArrayList<String> textList = new ArrayList<>();
    private ArrayList<Integer> colorList = new ArrayList<>();

    private ArrayList<ListItems> listItems = new ArrayList<>();

    private int listSize = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLists();
        initRecyclerView();
    }

    private void initLists()
    {

        for (int n = 1; n <= listSize; n++)
        {
            String url = "https://dummyimage.com/30x30/ffffff/000000.png&text=" + n;
            String txt = "Voici l'élément numéro " + n + " de cette liste";
            int color;
            if(n %3 == 1) {
                color = Color.BLUE;
            }
            else if (n % 3 == 2) {
                color = Color.GREEN;
            }
            else {
                color = Color.YELLOW;
            }
            listItems.add(new ListItems(url, txt, color));
        }
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}