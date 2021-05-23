package com.example.shoplist.provider;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("SELECT * FROM items")
    LiveData<List<Item>> getAllItems();

    @Insert
    void addItem(Item item);

    @Query("DELETE FROM items")
    void deleteAllItems();

    @Delete
    void deleteLastItem(Item item);
}



