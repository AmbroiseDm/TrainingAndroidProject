package com.example.javarecyclerviewapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ListItems> listItems = new ArrayList<>();
    private ArrayList<ListItems> fullList = new ArrayList<>();
    private boolean filtered = false;

    public RecyclerViewAdapter(Context contxt, ArrayList<ListItems> listItms) {
        this.context = contxt;
        this.listItems = listItms;
        this.fullList = listItms;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.text.setText(listItems.get(position).getText());
            Picasso.get().load(listItems.get(position).getImage()).into(holder.image);
            holder.layout.setBackgroundColor(listItems.get(position).getColor());
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            text = itemView.findViewById(R.id.textView);
            layout = itemView.findViewById(R.id.relativeLayout);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (filtered == false) {
                        filter(listItems.get(getAdapterPosition()).getColor());
                    }
                    else {
                        listItems = fullList;
                        filtered = false;
                        notifyDataSetChanged();
                    }
                }
            });
        }

    }
    private void filter(int color)
    {
        ArrayList<ListItems> filteredList = new ArrayList<>();

        for (ListItems item : listItems) {
            if (item.getColor() == color) {
                filteredList.add(item);
            }
        }
        listItems = filteredList;
        filtered = true;
        notifyDataSetChanged();
    }
}
