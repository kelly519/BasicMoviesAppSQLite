package com.example.moviesapp.room;

import androidx.room.RoomDatabase;

import com.example.moviesapp.data.entitiy.Movies;

@androidx.room.Database(entities = {Movies.class},version = 1)
public abstract class Database extends RoomDatabase {
    public abstract MoviesDao getMoviesDao();
}
