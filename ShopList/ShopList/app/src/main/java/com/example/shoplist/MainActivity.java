package com.example.shoplist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shoplist.provider.Item;
import com.example.shoplist.provider.ItemViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    EditText nameInput, costInput,quanInput;
    FloatingActionButton fab;
    Button deleteButton, listAllButton;
    private ItemViewModel itemViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameInput = findViewById(R.id.name);
        costInput = findViewById(R.id.estcost);
        quanInput = findViewById(R.id.quantity);
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        deleteButton = findViewById(R.id.clearButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearTable();
            }
        });

       listAllButton = findViewById(R.id.nextAct);
       listAllButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                listItems();
           }
       });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItems();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences saveData = getSharedPreferences("SP", MODE_PRIVATE);
        nameInput.setText(saveData.getString("Name", ""));
        costInput.setText(saveData.getString("Cost", ""));
        quanInput.setText(saveData.getString("Quantity", ""));
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences saveData = getSharedPreferences("SP", MODE_PRIVATE);
        SharedPreferences.Editor editor = saveData.edit();
        editor.putString("Name", nameInput.getText().toString());
        editor.putString("Cost", costInput.getText().toString());
        editor.putString("Quantity", quanInput.getText().toString());
        editor.apply();
    }


    private void addItems(){
        String name = nameInput.getText().toString();
        double cost = Double.parseDouble(costInput.getText().toString());
        int quantity = Integer.parseInt(quanInput.getText().toString());
        itemViewModel.insert(new Item(name, cost, quantity));
    }

    private void clearTable(){
        itemViewModel.deleteAll();
    }

    private void listItems(){
        Intent intent = new Intent(this, ListedItems.class);
        startActivity(intent);
    }
}