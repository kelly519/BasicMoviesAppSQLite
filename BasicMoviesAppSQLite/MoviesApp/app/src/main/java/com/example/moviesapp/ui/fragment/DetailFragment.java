package com.example.moviesapp.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviesapp.R;
import com.example.moviesapp.data.entitiy.Movies;
import com.example.moviesapp.databinding.FragmentDetailBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment {
    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);

        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        Movies movie = bundle.getMovie();

        binding.toolbarDetail.setTitle(movie.getName());

        binding.ivMovie.setImageResource(getResources().getIdentifier(movie.getPhoto(),"drawable",requireContext().getPackageName()));



        return binding.getRoot();
    }
}