package com.example.materialdesign.Part02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.example.materialdesign.Part02.adapter.ForYouFoodAdapter;
import com.example.materialdesign.Part02.adapter.NewFoodAdapter;
import com.example.materialdesign.Part02.adapter.categoryFoodAdapter;
import com.example.materialdesign.Part02.adapter.sliderAdapter;
import com.example.materialdesign.Part02.adapter.typeFoodAdapter;
import com.example.materialdesign.Part02.model.Food;
import com.example.materialdesign.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class HomeActivityFood extends AppCompatActivity {


    private Handler handler;
    private int delay = 5000;
    private int page = 0;

    Runnable runnable = new Runnable() {
        public void run() {
            if (sliderAdapter.getCount() == page) {
                page = 0;
            } else {
                page++;
            }
            viewPager.setCurrentItem(page, true);
            handler.postDelayed(this, delay);
        }
    };

    //Category
    RecyclerView recyclerView_category;
    List<Food> foodList;
    categoryFoodAdapter categoryFoodAdapter;

    //Type food
    List<Food> foodTypeList;
    RecyclerView recyclerView_typeFood;
    typeFoodAdapter typeFoodAdapter;

    //ForYou
    List<Food> foodForYouList;
    ForYouFoodAdapter forYouFoodAdapter;
    RecyclerView recyclerView_food_for_you;

    //NewFood
    NewFoodAdapter newFoodAdapter;
    RecyclerView recyclerView_newFood;

    //Slider
    List<Food> listSlider=new ArrayList<>();
    ViewPager viewPager;
    sliderAdapter sliderAdapter;
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_food);
        handler = new Handler();

        setupViews();
        categoryFood();
        FoodType();
        ForYouFood();
        newFood();
        Slider();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                page = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, delay);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    private void Slider() {
        viewPager=findViewById(R.id.viewPager);
        tabs=findViewById(R.id.tabLayout);

        listSlider.add(new Food("جوجه کباب","جوجه\u200Cکباب یکی از خوراک\u200Cهای اصیل ایرانی و از رده کباب\u200Cهای سنتی ایران است. در پخت جوجه\u200Cکباب، قطعات خوردشده گوشت مرغ را برای مدتی تقریباً طولانی (حدود سه ساعت) در یک ظرف پر از آبلیمو، پیاز خرد شده، زعفران و ادویه\u200Cجات قرار می\u200Cدهند و پس از اینکه قطعات گوشت طعم دار شد، آنها را به یک سیخ بلند می\u200Cکشند و روی کباب\u200Cپز و به وسیله آتش مستقیم، کباب می\u200Cکنند. جوجه کباب از خوراک\u200Cهای بسیار محبوب نزد ایرانی\u200Cها است.","25000","4.8","12K","https://chishi.ir/wp-content/uploads/2020/07/jooje-kabab-tabe.jpg"));
        listSlider.add(new Food("فیله استیک با سس فلاچیز","استیک تکه گوشت گوساله است که به صورت کبابی طبخ شده و با انواع سس میل می\u200Cکنند. برای تهیه استیک گوشت را در خلاف جهت ماهیچه برش می\u200Cزنند. در ادامه می\u200Cخواهیم با طرز تهیه فیله استیک با سس بلوچیز همراه شما باشیم","52000","4.3","5.6K","https://www.majidakhshabi.com/uploads/posts/2018-02/1519546048_grillsteak.jpg"));
        listSlider.add(new Food("لقمه گوشت و مرغ","کباب لقمه ای یکی از انواع کباب های خوشمزه ایرانی است که مانند کباب تابه ای ساده نوعی کباب خانگی محسوب می شود،","24000","4.5","11K","https://chishi.ir/wp-content/uploads/2020/04/kabab-loghme.jpg"));
        listSlider.add(new Food("لازانیا ویژه","لازانیا یکی از دل\u200Cچسب\u200Cترین و پرطرفدارترین غذاها از خانواده بزرگ پاستا است. معمولاً لازانیا را به\u200Cصورت لایه\u200Cهای ورقه\u200Cای درست می\u200Cکنند و بین آن گوشت، مرغ یا سبزیجات را قرار می\u200Cدهند. این غذا همانند پاستا اصالتی ایتالیایی دارد","25000","4.7","15K","https://files.namnak.com/users/kk/aup/202001/20_pics/%E2%80%AB%D9%84%D8%A7%D8%B2%D8%A7%D9%86%DB%8C%D8%A7%E2%80%AC&lrm.jpg"));
        sliderAdapter=new sliderAdapter(this,listSlider);
        viewPager.setRotationY(180);
        viewPager.setPageTransformer(true,new pageTransformer());
        viewPager.setAdapter(sliderAdapter);
        if(Build.VERSION.SDK_INT>23){
            tabs.setupWithViewPager(viewPager,true);
        }else{
            tabs.setVisibility(View.GONE);
        }

        //tabs.setupWithViewPager(viewPager,true);
    }

    private void newFood() {
        recyclerView_newFood.setLayoutManager(new GridLayoutManager(this,2));
//        foodForYouList.add(new Food("پیتزای ناپلی","25000","4.1","8.2K","https://upload.wikimedia.org/wikipedia/commons/e/ee/Eq_it-na_pizza-margherita_sep2005_sml-2.png"));
//        foodForYouList.add(new Food("پیتزا شیکاگو","30000","5","2.4K","https://lh3.googleusercontent.com/proxy/PpIGGTOhmSSRO2LVIRAu5rYzP8FjRjCldAmqmn2TiKDglu0vIE4kZKsPdiCHa3MojMgvWyHIk7KKh-TOzVxj5oPDe5XQ8rZEL6Dhtv5WXZKb9kHLqNj8_N2hPZib3QAUyUrGBR97R9U-pSWy6ok"));
//        foodForYouList.add(new Food("پیتزا مارگاریتا","55000","3.9","11.1K","https://p7.hiclipart.com/preview/97/105/221/pizza-margherita-seafood-pizza-italian-cuisine-take-out-pizza.jpg"));
//        foodForYouList.add(new Food("پیتزا گوشت و قارچ","45000","4.3","13K","https://img.pngio.com/pizza-pizza-restaurant-pizza-capers-meat-mushroom-pizza-mushroom-pizza-png-900_460.jpg"));
//        foodForYouList.add(new Food("کوفته تبریزی","120000","4.2","5.6K","https://www.offdecor.com/image/cache/media/post/4413/koufte-tabrizi-335x200h.jpg"));
//        foodForYouList.add(new Food("اسپاگتی","26000","3","3K","https://www.kindpng.com/picc/m/351-3513669_plate-of-spaghetti-png-transparent-png.png"));
//        foodForYouList.add(new Food("لازانیا","78000","2.5","1.1K","https://lh3.googleusercontent.com/proxy/OrBRvFcoYFjxX63RwDNJCvjwTnAi8LWiXpXwZ8mCg6tJcTPxR6wQw_YmVCjcc8k7-IzclTiy1nM3Yc7p7Wo25my2UhckEF6ZA8RpGsVO4oqrEhBWjTljjgPO2U5eDoaG"));
        newFoodAdapter=new NewFoodAdapter(this,foodForYouList);
        recyclerView_newFood.setAdapter(newFoodAdapter);
    }

    private void ForYouFood() {
        recyclerView_food_for_you.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        foodForYouList.add(new Food("پیتزای ناپلی","پیتزا ناپولی اولین پیتزایی بود که در جهان ابداع شد که پیشینه ی تاریخی آن به قرن هجدهم در شهر ناپل در جنوب ایتالیا برمی گردد. این پیتزا از موادی چون گوجه فرنگی ، فلفل، پنیر گودا و آویشن و ریحون و ژامبون تشکیل شده است.","25000","4.1","8.2K","https://upload.wikimedia.org/wikipedia/commons/e/ee/Eq_it-na_pizza-margherita_sep2005_sml-2.png"));
        foodForYouList.add(new Food("پیتزا شیکاگو","پیتزا شیکاگو نوعی از دیپ دیش پیتزا (deep dish pizza) هست که اولین بار در شیکاگو به سبک خاصی از خمیر کلفتی از آرد ذرت و روغن زیتون درست می شده که تا امروز تغییراتی کرده است.","30000","5","2.4K","https://lh3.googleusercontent.com/proxy/PpIGGTOhmSSRO2LVIRAu5rYzP8FjRjCldAmqmn2TiKDglu0vIE4kZKsPdiCHa3MojMgvWyHIk7KKh-TOzVxj5oPDe5XQ8rZEL6Dhtv5WXZKb9kHLqNj8_N2hPZib3QAUyUrGBR97R9U-pSWy6ok"));
        foodForYouList.add(new Food("پیتزا مارگاریتا","پیتزا مارگاریتا پیتزایی ساده است و به راحتی می\u200Cتوانید آن را تهیه کنید. برای تهیه این پیتزا به مواد اولیه زیادی نیاز ندارید و به سادگی می\u200Cتوانید آن را در منزل تهیه کنید. این پیتزا برای اولین بار با سه رنگ پرچم کشور ایتالیا و برای ملکه ایتالیا تهیه شد.","55000","3.9","11.1K","https://p7.hiclipart.com/preview/97/105/221/pizza-margherita-seafood-pizza-italian-cuisine-take-out-pizza.jpg"));
        foodForYouList.add(new Food("پیتزا گوشت و قارچ","این روزها کمتر کسی پیدا می شود که علاقه ای به پیتزا نداشته باشد. پیتزا از غذاهای بین المللی است که در ایران نیز بسیار پرطرفدار است. یکی از انواع محبوب این غذا، پیتزا قارچ و گوشت است؛ زیرا در تهیه آن از هیچ گونه گوشت فرآوری شده ای استفاده نمی شود.\n" +
                "\n" +
                "این غذا به علت وجود قارچ و پنیر و گوشت، کالری بالایی دارد و برای کسانی که می خواهند یک غذای سالم بخورند، گزینه مناسب تری از انواع پیتزاهای تهیه شده با سوسیس و کالباس محسوب می شود.","45000","4.3","13K","https://img.pngio.com/pizza-pizza-restaurant-pizza-capers-meat-mushroom-pizza-mushroom-pizza-png-900_460.jpg"));
        foodForYouList.add(new Food("کوفته تبریزی","کوفته تبریزی یکی از معروف ترین و لذیذترین غذاهای خطه آذربایجان میباشد","120000","4.2","5.6K","https://www.offdecor.com/image/cache/media/post/4413/koufte-tabrizi-335x200h.jpg"));
        foodForYouList.add(new Food("اسپاگتی","اسپاگتی یا رشتار،[۱] که به آن ماکارونی هم می\u200Cگویند، نوعی پاستای استوانه ای نازک و کشیده با ریشه ایتالیایی و سیسیلی است و به عنوان یکی از غذاهای محبوب ایتالیایی شمرده می\u200Cشود که غالباً از سمولینا یا آرد معمولی و آب تهیه می\u200Cشود.[۲] اسپاگتی در قرن دوازده میلادی در ایتالیا رواج یافت.[۲] اسپاگتی خشک ایتالیایی از آرد نوعی گندم سفت به نام Durum ساخته می\u200Cشود ولی ممکن است در کشورهای دیگر از آردهای دیگر نیز تهیه گردد.","26000","3","3K","https://www.kindpng.com/picc/m/351-3513669_plate-of-spaghetti-png-transparent-png.png"));
        foodForYouList.add(new Food("لازانیا","لازانیا هم مثل ماکارونی یکی از انواع پاستاهای خوشمزه و بسیار پرطرفدار در جهان است که این غذا هم مثل انواع پاستاها اصالتی ایتالیایی دارد. لازانیا از نظر مواد شباهت هایی هم به پیتزا دارد و شاید به همین دلیل است که طرفداران بسیار زیادی در سراسر جهان دارد.","78000","2.5","1.1K","https://lh3.googleusercontent.com/proxy/OrBRvFcoYFjxX63RwDNJCvjwTnAi8LWiXpXwZ8mCg6tJcTPxR6wQw_YmVCjcc8k7-IzclTiy1nM3Yc7p7Wo25my2UhckEF6ZA8RpGsVO4oqrEhBWjTljjgPO2U5eDoaG"));
        forYouFoodAdapter=new ForYouFoodAdapter(this,foodForYouList);
        recyclerView_food_for_you.setAdapter(forYouFoodAdapter);
    }

    private void FoodType() {
        recyclerView_typeFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        foodTypeList.add(new Food("ایرانی","https://kamchin.com/wp-content/uploads/2018/03/Koofteh-Tabrizi-8-copy.jpg"));
        foodTypeList.add(new Food("ایتالییایی","https://cdn01.eavar.com/2020/1/7e7c479c-349b-4361-972a-2699d504c195.jpg"));
        foodTypeList.add(new Food("آلمانی","https://www.eligasht.com/Blog/wp-content/uploads/2017/09/german-food-eligasht.jpg"));
        foodTypeList.add(new Food("فرانسوی","https://cdn01.bluerose.ir/2019/1/4a28b0ec-b12b-45be-882d-2c7af32a3cc6.jpg"));
        foodTypeList.add(new Food("هندی","https://img.jazebeha.com/wp-content/uploads/2019/10/%D8%A2%D8%B4%D9%86%D8%A7%DB%8C%DB%8C-%D8%A8%D8%A7-%D8%BA%D8%B0%D8%A7%D9%87%D8%A7%DB%8C-%D9%84%D8%B0%DB%8C%D8%B0-%D9%88-%D9%85%D8%B9%D8%B1%D9%88%D9%81-%D9%87%D9%86%D8%AF%DB%8C-175947-1.jpg"));
        foodTypeList.add(new Food("چینی","https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQRsVYdmqDsjzpG57TKd5Bef5xY4BFkZdZu5w&usqp=CAU"));
        typeFoodAdapter=new typeFoodAdapter(this,foodTypeList);
        recyclerView_typeFood.setAdapter(typeFoodAdapter);
    }

    private void categoryFood() {
        recyclerView_category.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        foodList.add(new Food("پیتزا"));
        foodList.add(new Food("برگر"));
        foodList.add(new Food("ساندویچ"));
        foodList.add(new Food("سالاد"));
        foodList.add(new Food("نوشیدنی"));
        foodList.add(new Food("ویژه"));
        foodList.add(new Food("کیک"));
        foodList.add(new Food("سبزیجات"));
        foodList.add(new Food("غذای ایرانی"));

        categoryFoodAdapter=new categoryFoodAdapter(this,foodList);
        recyclerView_category.setAdapter(categoryFoodAdapter);
    }

    private void setupViews() {
        recyclerView_category=findViewById(R.id.recyclerView_Category);
        recyclerView_category.setHasFixedSize(true);
        foodList=new ArrayList<>();
        //***\\
        recyclerView_typeFood=findViewById(R.id.recyclerView_type_food);
        recyclerView_typeFood.setHasFixedSize(true);
        foodTypeList=new ArrayList<>();
        //***\\
        recyclerView_food_for_you=findViewById(R.id.recyclerView_food_for_you);
        recyclerView_food_for_you.setHasFixedSize(true);
        foodForYouList=new ArrayList<>();
        //***\\
        recyclerView_newFood=findViewById(R.id.recyclerView_food_new);
        recyclerView_newFood.setHasFixedSize(true);

    }
}