package edu.itc.gic.m1.firstapp.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.itc.gic.m1.firstapp.model.Production;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Database(entities = {Production.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    // Singleton
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        // this initialization needs to be improved
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "songbook.sqlite")
                    .build();
        }

        return INSTANCE;
    }

    public abstract ProductionDao getProductionDao();

}
