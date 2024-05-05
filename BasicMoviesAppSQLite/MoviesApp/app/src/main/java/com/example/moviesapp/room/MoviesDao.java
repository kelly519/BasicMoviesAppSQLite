package com.example.moviesapp.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.moviesapp.data.entitiy.Movies;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface MoviesDao {
    @Query("SELECT * FROM movies")
    Single<List<Movies>> uploadMovies ();
}
