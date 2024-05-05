package com.example.moviesapp.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.moviesapp.data.entitiy.Movies;
import com.example.moviesapp.room.MoviesDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MoviesDaoRepository {
    public MutableLiveData<List<Movies>> moviesList = new MutableLiveData<>();
    private MoviesDao moviesDao;

    public MoviesDaoRepository(MoviesDao moviesDao){
        this.moviesDao = moviesDao;
    }
    public void uploadMovies(){
        moviesDao.uploadMovies().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<Movies>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onSuccess(List<Movies> movies) {
                moviesList.setValue(movies);
            }
            @Override
            public void onError(Throwable e) {
            }
        });
    }
}
