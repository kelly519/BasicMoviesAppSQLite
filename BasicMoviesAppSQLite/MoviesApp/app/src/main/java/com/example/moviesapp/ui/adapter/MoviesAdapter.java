package com.example.moviesapp.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.example.moviesapp.data.entitiy.Movies;
import com.example.moviesapp.databinding.CardDesignBinding;
import com.example.moviesapp.ui.fragment.MainPageFragmentDirections;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.CardDesignHolder> {
    private Context mContext;
    private List<Movies> moviesList;

    public MoviesAdapter(Context mContext, List<Movies> moviesList) {
        this.mContext = mContext;
        this.moviesList = moviesList;
    }

    public class CardDesignHolder extends RecyclerView.ViewHolder{
        private CardDesignBinding design;

        public CardDesignHolder(CardDesignBinding design) {
            super(design.getRoot());
            this.design = design;
        }
    }

    @NonNull
    @Override
    public CardDesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardDesignBinding binding = CardDesignBinding.inflate(LayoutInflater.from(mContext),parent,false);
        return new CardDesignHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDesignHolder holder, int position) {
        Movies movie = moviesList.get(position);
        CardDesignBinding t = holder.design;

        t.imageViewMovie.setImageResource(mContext.getResources().getIdentifier(movie.getPhoto(),"drawable",mContext.getPackageName()));
        t.textViewPrice.setText(movie.getPrice()+ " $ ");
        t.buttonBuy.setOnClickListener(view -> {
            Snackbar.make(view,movie.getName()+ " added to the basket! ",Snackbar.LENGTH_SHORT).show();
        });

        t.cardViewMovie.setOnClickListener(view ->{
            MainPageFragmentDirections.To to = MainPageFragmentDirections.to(movie);
            Navigation.findNavController(view).navigate(to);

        });
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }



}
