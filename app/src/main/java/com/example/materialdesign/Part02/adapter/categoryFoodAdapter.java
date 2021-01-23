package com.example.materialdesign.Part02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;

import java.util.List;

public class categoryFoodAdapter extends RecyclerView.Adapter<categoryFoodAdapter.MyFoodViewHolder> {

    Context context;
    List<Food> foodList;

    public categoryFoodAdapter(Context context, List<Food> foodList){
        this.context=context;
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public MyFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category_food,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyFoodViewHolder holder, int position) {
        holder.name.setText(foodList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyFoodViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public MyFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_category);
        }
    }
}
