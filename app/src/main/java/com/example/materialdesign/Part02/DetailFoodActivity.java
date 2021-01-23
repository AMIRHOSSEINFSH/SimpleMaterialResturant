package com.example.materialdesign.Part02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.materialdesign.Part02.adapter.ForYouFoodAdapter;
import com.example.materialdesign.Part02.adapter.NewFoodAdapter;
import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailFoodActivity extends AppCompatActivity {


    TextView name,description,price,count,rating;
    RatingBar ratingBar;
    ImageView img;
    Bundle bundle;

    List<Food> foodForYouList;
    RecyclerView      recyclerView_forYou;
    ForYouFoodAdapter forYouFoodAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detail_food);

        bundle=getIntent().getExtras();
        name=findViewById(R.id.name);
        count=findViewById(R.id.count);
        rating=findViewById(R.id.txt_rating);
        price=findViewById(R.id.price);
        description=findViewById(R.id.description);
        img=findViewById(R.id.img);
        ratingBar=findViewById(R.id.ratingBar);

        Picasso.get().load(bundle.getString("link_Img")).into(img);
        name.setText(bundle.getString("name"));
        price.setText("قیمت: "+bundle.getString("price")+"تومان ");
        count.setText(bundle.getString("count"));
        description.setText(bundle.getString("description"));
        rating.setText(bundle.getString("rating"));
        ratingBar.setRating(Float.parseFloat(rating.getText().toString()));

        recyclerView_forYou=findViewById(R.id.recyclerView_food_for_you);
        foodForYouList=new ArrayList<>();
        foodForYouList.add(new Food("پیتزای ناپلی","پیتزا ناپولی اولین پیتزایی بود که در جهان ابداع شد که پیشینه ی تاریخی آن به قرن هجدهم در شهر ناپل در جنوب ایتالیا برمی گردد. این پیتزا از موادی چون گوجه فرنگی ، فلفل، پنیر گودا و آویشن و ریحون و ژامبون تشکیل شده است.","25000","4.1","8.2K","https://upload.wikimedia.org/wikipedia/commons/e/ee/Eq_it-na_pizza-margherita_sep2005_sml-2.png"));
        foodForYouList.add(new Food("پیتزا شیکاگو","پیتزا شیکاگو نوعی از دیپ دیش پیتزا (deep dish pizza) هست که اولین بار در شیکاگو به سبک خاصی از خمیر کلفتی از آرد ذرت و روغن زیتون درست می شده که تا امروز تغییراتی کرده است.","30000","5","2.4K","https://lh3.googleusercontent.com/proxy/PpIGGTOhmSSRO2LVIRAu5rYzP8FjRjCldAmqmn2TiKDglu0vIE4kZKsPdiCHa3MojMgvWyHIk7KKh-TOzVxj5oPDe5XQ8rZEL6Dhtv5WXZKb9kHLqNj8_N2hPZib3QAUyUrGBR97R9U-pSWy6ok"));
        foodForYouList.add(new Food("پیتزا مارگاریتا","پیتزا مارگاریتا پیتزایی ساده است و به راحتی می\u200Cتوانید آن را تهیه کنید. برای تهیه این پیتزا به مواد اولیه زیادی نیاز ندارید و به سادگی می\u200Cتوانید آن را در منزل تهیه کنید. این پیتزا برای اولین بار با سه رنگ پرچم کشور ایتالیا و برای ملکه ایتالیا تهیه شد.","55000","3.9","11.1K","https://p7.hiclipart.com/preview/97/105/221/pizza-margherita-seafood-pizza-italian-cuisine-take-out-pizza.jpg"));
        foodForYouList.add(new Food("پیتزا گوشت و قارچ","این روزها کمتر کسی پیدا می شود که علاقه ای به پیتزا نداشته باشد. پیتزا از غذاهای بین المللی است که در ایران نیز بسیار پرطرفدار است. یکی از انواع محبوب این غذا، پیتزا قارچ و گوشت است؛ زیرا در تهیه آن از هیچ گونه گوشت فرآوری شده ای استفاده نمی شود.\n" +
                "\n" +
                "این غذا به علت وجود قارچ و پنیر و گوشت، کالری بالایی دارد و برای کسانی که می خواهند یک غذای سالم بخورند، گزینه مناسب تری از انواع پیتزاهای تهیه شده با سوسیس و کالباس محسوب می شود.","45000","4.3","13K","https://img.pngio.com/pizza-pizza-restaurant-pizza-capers-meat-mushroom-pizza-mushroom-pizza-png-900_460.jpg"));
        foodForYouList.add(new Food("کوفته تبریزی","کوفته تبریزی یکی از معروف ترین و لذیذترین غذاهای خطه آذربایجان میباشد","120000","4.2","5.6K","https://www.offdecor.com/image/cache/media/post/4413/koufte-tabrizi-335x200h.jpg"));
        foodForYouList.add(new Food("اسپاگتی","اسپاگتی یا رشتار،[۱] که به آن ماکارونی هم می\u200Cگویند، نوعی پاستای استوانه ای نازک و کشیده با ریشه ایتالیایی و سیسیلی است و به عنوان یکی از غذاهای محبوب ایتالیایی شمرده می\u200Cشود که غالباً از سمولینا یا آرد معمولی و آب تهیه می\u200Cشود.[۲] اسپاگتی در قرن دوازده میلادی در ایتالیا رواج یافت.[۲] اسپاگتی خشک ایتالیایی از آرد نوعی گندم سفت به نام Durum ساخته می\u200Cشود ولی ممکن است در کشورهای دیگر از آردهای دیگر نیز تهیه گردد.","26000","3","3K","https://www.kindpng.com/picc/m/351-3513669_plate-of-spaghetti-png-transparent-png.png"));
        foodForYouList.add(new Food("لازانیا","لازانیا هم مثل ماکارونی یکی از انواع پاستاهای خوشمزه و بسیار پرطرفدار در جهان است که این غذا هم مثل انواع پاستاها اصالتی ایتالیایی دارد. لازانیا از نظر مواد شباهت هایی هم به پیتزا دارد و شاید به همین دلیل است که طرفداران بسیار زیادی در سراسر جهان دارد.","78000","2.5","1.1K","https://lh3.googleusercontent.com/proxy/OrBRvFcoYFjxX63RwDNJCvjwTnAi8LWiXpXwZ8mCg6tJcTPxR6wQw_YmVCjcc8k7-IzclTiy1nM3Yc7p7Wo25my2UhckEF6ZA8RpGsVO4oqrEhBWjTljjgPO2U5eDoaG"));
        recyclerView_forYou.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        forYouFoodAdapter =new ForYouFoodAdapter(this,foodForYouList);
        recyclerView_forYou.setAdapter(forYouFoodAdapter);
    }
}