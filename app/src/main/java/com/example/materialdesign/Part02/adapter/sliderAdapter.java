package com.example.materialdesign.Part02.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class sliderAdapter extends PagerAdapter {


    Context context;
    List<Food> data;

    public sliderAdapter(Context context, List<Food> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_slider,container,false);

        TextView name=view.findViewById(R.id.name);
        TextView description=view.findViewById(R.id.description);
        TextView rating=view.findViewById(R.id.txt_rating);
        TextView count=view.findViewById(R.id.count);
        RatingBar ratingBar=view.findViewById(R.id.ratingBar);
        ImageView img=view.findViewById(R.id.img);

        name.setText("نام غذا :"+data.get(position).getName());
        description.setText(data.get(position).getDescription());
        rating.setText(data.get(position).getRation());
        count.setText("("+data.get(position).getCount()+")");
        ratingBar.setRating(Float.parseFloat(data.get(position).getRation()));
        Picasso.get().load(data.get(position).getLink_img()).into(img);
        view.setRotationY(-180);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
       return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
