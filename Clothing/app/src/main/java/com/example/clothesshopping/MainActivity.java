package com.example.clothesshopping;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.clothesshopping.DataProvider.getTopPicks;


public class MainActivity extends AppCompatActivity implements TopPicks_Adapter.OnItemClickListener {
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NAME = "Name";
    public static final String EXTRA_PRICE = "price";
    public static final String EXTRA_ORDERS = "orderCount";
    public static final String EXTRA_DESC = "desc";
    private RecyclerView mHorizontalRecyclerView;
    private TopPicks_Adapter mTopPicksAdapter;
    private ArrayList<ClothingItem> TopPicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
        ViewGroup linear = findViewById(R.id.scene_root);


        mHorizontalRecyclerView = findViewById(R.id.horizontal_recycler_view);
        mHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        TopPicks = getTopPicks();

        mTopPicksAdapter = new TopPicks_Adapter(MainActivity.this, TopPicks);
        mHorizontalRecyclerView.setAdapter(mTopPicksAdapter);

        mTopPicksAdapter.setOnItemClickListener(MainActivity.this);

        CardView catergoryCardView = findViewById(R.id.card_view_category);
        CardView catergoryCardView2 = findViewById(R.id.card_view_category2);
        CardView catergoryCardView3 = findViewById(R.id.card_view_category3);
        CardView catergoryCardView4 = findViewById(R.id.card_view_category4);
        catergoryCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BottomIntent = new Intent(getBaseContext(), ListActivity.class);
                BottomIntent.putExtra("MessageFromMainActivity", "Bottom");
                startActivity(BottomIntent);
            }
        });
        catergoryCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Dress");
                startActivity(numbersIntent);
            }
        });
        catergoryCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Top");
                startActivity(numbersIntent);
            }
        });
        catergoryCardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(getBaseContext(), ListActivity.class);
                numbersIntent.putExtra("MessageFromMainActivity", "Search");
                startActivity(numbersIntent);
            }
        });

        mHorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = getWidth() / 3;
                lp.height = getWidth() / 3;
                return true;
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        ClothingItem clickedItem = TopPicks.get(position);
        detailIntent.putExtra(EXTRA_URL, clickedItem.getImagefilenames());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getClothesName());
        detailIntent.putExtra(EXTRA_PRICE, clickedItem.getPrice());
        detailIntent.putExtra(EXTRA_ORDERS, clickedItem.getOrders());
        detailIntent.putExtra(EXTRA_DESC, clickedItem.getDesc());
        startActivity(detailIntent);
    }


}
