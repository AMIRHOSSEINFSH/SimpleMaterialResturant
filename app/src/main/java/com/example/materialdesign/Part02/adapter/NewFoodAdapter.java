package com.example.materialdesign.Part02.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.Part01.DetailBookActivity;
import com.example.materialdesign.Part02.DetailFoodActivity;
import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewFoodAdapter extends RecyclerView.Adapter<NewFoodAdapter.MyFoodViewHolder> {

    Context context;
    List<Food> foodList;

    public NewFoodAdapter(Context context, List<Food> foodList){
        this.context=context;
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public MyFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyFoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_new_food,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyFoodViewHolder holder, final int position) {
        holder.name.setText(foodList.get(position).getName());
        holder.count.setText("("+foodList.get(position).getCount()+")");
        holder.price.setText(foodList.get(position).getPrice());
        holder.rating.setText(foodList.get(position).getRation());
        holder.ratingBar.setRating(Float.parseFloat(foodList.get(position).getRation()));
        Picasso.get().load(foodList.get(position).getLink_img()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailFoodActivity.class);
                intent.putExtra("name",holder.name.getText());
                intent.putExtra("price",holder.price.getText());
                intent.putExtra("link_Img",foodList.get(position).getLink_img());
                intent.putExtra("rating",holder.rating.getText());
                intent.putExtra("count",holder.count.getText());
                intent.putExtra("description",foodList.get(position).getDescription());

                ActivityOptions options=null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    options=ActivityOptions.makeSceneTransitionAnimation((Activity) context,holder.img,"img_new_food");
                    context.startActivity(intent,options.toBundle());
                }else
                    context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class MyFoodViewHolder extends RecyclerView.ViewHolder {
        TextView  name,count,price,rating;
        RatingBar ratingBar;
        ImageView img;
        public MyFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            count=itemView.findViewById(R.id.count);
            price=itemView.findViewById(R.id.price);
            rating=itemView.findViewById(R.id.txt_rating);
            ratingBar=itemView.findViewById(R.id.ratingBar);
            img=itemView.findViewById(R.id.img);
        }
    }
}
