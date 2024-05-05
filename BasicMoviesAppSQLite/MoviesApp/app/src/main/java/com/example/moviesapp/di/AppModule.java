package com.example.moviesapp.di;

import android.content.Context;

import androidx.room.Room;

import com.example.moviesapp.data.repo.MoviesDaoRepository;
import com.example.moviesapp.room.Database;
import com.example.moviesapp.room.MoviesDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public MoviesDaoRepository provideMoviesDaoRepository(MoviesDao moviesDao){
        return new MoviesDaoRepository(moviesDao);
    }

    @Provides
    @Singleton
    public MoviesDao provideMoviesDao(@ApplicationContext Context context){
        Database db = Room.databaseBuilder(context, Database.class, "filmler_app.sqlite").createFromAsset("filmler_app.sqlite").build();
        return db.getMoviesDao();
    }
}
