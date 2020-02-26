package edu.itc.gic.m1.firstapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.itc.gic.m1.firstapp.model.Production;
import edu.itc.gic.m1.firstapp.model.Singer;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Dao
public interface SingerDao {

    @Query("SELECT * FROM singers")
    LiveData<List<Singer>> getAllAsync();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(Singer singer);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(List<Singer> singers);

    @Update
    void update(Singer singer);

    @Delete
    void delete(Singer singer);

}
