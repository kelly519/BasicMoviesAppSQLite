package com.example.moviesapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviesapp.R;
import com.example.moviesapp.data.entitiy.Movies;
import com.example.moviesapp.databinding.FragmentMainPageBinding;
import com.example.moviesapp.ui.adapter.MoviesAdapter;
import com.example.moviesapp.ui.viewmodel.MainPageViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainPageFragment extends Fragment {
    private FragmentMainPageBinding binding;
    private MainPageViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainPageBinding.inflate(inflater, container, false);

        binding.toolbarMainPage.setTitle("Movies");
        binding.movieRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        viewModel.moviesList.observe(getViewLifecycleOwner(),moviesList ->{

            MoviesAdapter moviesAdapter = new MoviesAdapter(requireContext(),moviesList);
            binding.movieRv.setAdapter(moviesAdapter);

        });

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainPageViewModel.class);
    }
}