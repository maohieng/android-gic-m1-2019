package edu.itc.gic.m1.firstapp.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import edu.itc.gic.m1.firstapp.model.Production;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Dao
public interface ProductionDao {

    @Query("SELECT * FROM productions")
    List<Production> getAll();

    @Insert
    void save(Production... productions);


}
