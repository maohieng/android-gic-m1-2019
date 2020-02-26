package edu.itc.gic.m1.firstapp.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.itc.gic.m1.firstapp.model.Song;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Dao
public interface SongDao {

    @Query("SELECT * FROM songs")
    LiveData<List<Song>> getAllAsync();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(Song song);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void save(List<Song> songs);

    @Update
    void update(Song song);

    @Delete
    void delete(Song song);

}
