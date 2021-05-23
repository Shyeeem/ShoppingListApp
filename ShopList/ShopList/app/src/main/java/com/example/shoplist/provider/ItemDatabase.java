package com.example.shoplist.provider;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {
    public static final String ITEM_DATABASE_NAME = "item_database";

    public abstract ItemDao itemDao();

    /* Threads are used to handle database queries. 4 threads mean a pool of 4 available threads
    can be used for anything database related */
    private static volatile ItemDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    ///handles the writing into the database. Also allocates the numbers of threads it can use
    static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    ///creates a new instance of the database if one doesn't exist already
    static ItemDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (ItemDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ItemDatabase.class, ITEM_DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}
