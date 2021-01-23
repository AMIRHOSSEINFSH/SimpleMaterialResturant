package com.example.materialdesign.Part02.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class typeFoodAdapter extends RecyclerView.Adapter<typeFoodAdapter.MyFoodViewHolder> {

    Context context;
    List<Food> foodList;

    public typeFoodAdapter(Context context, List<Food> foodList){
        this.context=context;
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public MyFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_type_food,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyFoodViewHolder holder, int position) {
        holder.name.setText(foodList.get(position).getName());
        Picasso.get().load(foodList.get(position).getLink_img()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyFoodViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        CircleImageView img;
        public MyFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_type);
            img=itemView.findViewById(R.id.img);
        }
    }
}
