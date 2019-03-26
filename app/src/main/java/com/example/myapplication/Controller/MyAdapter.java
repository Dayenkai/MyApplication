package com.example.myapplication.Controller;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Sandwich;
import com.example.myapplication.R;
import com.example.myapplication.Vue.GalleryActivity;
import com.example.myapplication.Vue.SecondActivity;

import java.nio.channels.Channel;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Sandwich> sandwichesList;
    private Context context;
    private static  final   String  image_name = "image_name";
    private static  final   String  image_url = "image_url";

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public ImageView imageView;
        public ConstraintLayout parentLayout;
        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.textView);
            imageView = v.findViewById(R.id.imageView);
            parentLayout = v.findViewById(R.id.parent_layout);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, List<Sandwich> sandwichesList) {
        this.context = context;
        this.sandwichesList = sandwichesList ;

    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_row, parent, false);

        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        Sandwich sandwich = sandwichesList.get(position);
        holder.textView.setText(sandwich.getName());
        Glide.with(context)
                .load(sandwich.getUrl())
                .into(holder.imageView);
        //holder.textView.setText(sandwichesList.get(position).getName());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra(image_name, sandwichesList.get(position).getName());
                intent.putExtra(image_url, sandwichesList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {

        return sandwichesList.size();
    }

    public Context getContext() {
        return context;
    }
    public List<Sandwich> getSandwichesList(){
        return sandwichesList;
    }
}