package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.shoplist.provider.ItemViewModel;

public class ListedItems extends AppCompatActivity {
    ItemViewModel itemViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    shopListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listed_items);
        adapter = new shopListAdapter();

        recyclerView = findViewById(R.id.myRecycler);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getAllItems().observe(this, dataList -> {
            ///whenever change occurs, table is updated(?)
            adapter.setItems(dataList);
            adapter.notifyDataSetChanged();
        });
    }
}