package com.ajdi.yassin.popularmoviespart1.ui.movieslist;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajdi.yassin.popularmoviespart1.data.model.Movie;
import com.ajdi.yassin.popularmoviespart1.databinding.ItemMovieBinding;
import com.ajdi.yassin.popularmoviespart1.ui.moviedetails.DetailsActivity;
import com.ajdi.yassin.popularmoviespart1.utils.GlideRequests;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.ajdi.yassin.popularmoviespart1.utils.Constants.IMAGE_URL;

/**
 * @author Yassin Ajdi.
 */
public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final ItemMovieBinding binding;
    private GlideRequests glide;

    public MovieViewHolder(@NonNull ItemMovieBinding binding, GlideRequests glide) {
        super(binding.getRoot());

        this.binding = binding;
        this.glide = glide;
    }

    void bindTo(final Movie movie) {
        // movie poster
        glide
                .load(movie.getImageUrl())
                .placeholder(android.R.color.holo_red_dark)
                .into(binding.imageMoviePoster);

        // movie click event
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_ID, movie.getId());
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_TITLE, movie.getTitle());
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_POSTER_URL, movie.getImageUrl());
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_RELEASE_DATE, movie.getReleaseDate());
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_OVERVIEW, movie.getOverview());
                intent.putExtra(DetailsActivity.EXTRA_MOVIE_RATED, movie.getUserRating());

                view.getContext().startActivity(intent);
            }
        });

        binding.executePendingBindings();
    }

    static MovieViewHolder create(ViewGroup parent, GlideRequests glide) {
        // Inflate
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Create the binding
        ItemMovieBinding binding =
                ItemMovieBinding.inflate(layoutInflater, parent, false);
        return new MovieViewHolder(binding, glide);
    }
}
