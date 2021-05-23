package com.example.shoplist.provider;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemRepository {

    private ItemDao mItemDao;
    private LiveData<List<Item>> allItems;

    ItemRepository(Application application){
        ItemDatabase db = ItemDatabase.getDatabase(application);
        mItemDao = db.itemDao();
        allItems = mItemDao.getAllItems();
    }

    ///METHODS
    LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    void insert(Item item){
        ItemDatabase.databaseWriteExecutor.execute(()-> mItemDao.addItem(item));
    }

    void deleteAll(){
        ItemDatabase.databaseWriteExecutor.execute(()->
                mItemDao.deleteAllItems());
    }

    void deleteItem(Item item){
        ItemDatabase.databaseWriteExecutor.execute(()->
                mItemDao.deleteLastItem(item));
    }
}
