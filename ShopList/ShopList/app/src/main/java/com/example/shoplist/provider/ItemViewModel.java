package com.example.shoplist.provider;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository itemRepository;
    private LiveData<List<Item>> allItems;


    public ItemViewModel(Application application){
        super(application);
        itemRepository = new ItemRepository(application);
        allItems = itemRepository.getAllItems();
    }

    public LiveData<List<Item>> getAllItems(){
        return allItems;
    }

    public void insert(Item item){
        itemRepository.insert(item);
    }

    public void deleteAll(){
        itemRepository.deleteAll();
    }

    public void deleteItem(Item item){
        itemRepository.deleteItem(item);
    }
}
