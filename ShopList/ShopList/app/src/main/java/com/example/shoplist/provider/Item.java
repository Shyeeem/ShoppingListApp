package com.example.shoplist.provider;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "items")
public class Item {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "itemID")
    private int itemId;
    @ColumnInfo(name = "itemName")
    private String itemName;
    @ColumnInfo(name = "itemCost")
    private double itemCost;
    @ColumnInfo(name = "itemQuan")
    private int itemQuan;


    ///CONSTRUCTOR
    public Item(String itemName, double itemCost, int itemQuan){

        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemQuan = itemQuan;
    }


    ///SETTERS AND GETTERS


    public int getItemId(){
        return itemId;
    }

    public void setItemId(@NonNull int itemId){
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getItemQuan() {
        return itemQuan;
    }

    public void setItemQuan(int itemQuan) {
        this.itemQuan = itemQuan;
    }

}
