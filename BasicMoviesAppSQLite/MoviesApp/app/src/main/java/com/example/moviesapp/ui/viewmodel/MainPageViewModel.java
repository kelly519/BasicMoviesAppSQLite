package com.example.moviesapp.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.moviesapp.data.entitiy.Movies;
import com.example.moviesapp.data.repo.MoviesDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.HiltAndroidApp;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainPageViewModel extends ViewModel {
    public MutableLiveData<List<Movies>> moviesList; //= new MutableLiveData<>();
    public MoviesDaoRepository moviesDaoRepository;
    @Inject
    public MainPageViewModel(MoviesDaoRepository moviesDaoRepository){
        this.moviesDaoRepository = moviesDaoRepository;
        uploadMovies();
        moviesList = moviesDaoRepository.moviesList;
    }
    public void uploadMovies(){
        moviesDaoRepository.uploadMovies();
    }
}
