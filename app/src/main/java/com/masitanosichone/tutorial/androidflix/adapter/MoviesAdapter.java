package com.masitanosichone.tutorial.androidflix.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.masitanosichone.tutorial.androidflix.R;
import com.masitanosichone.tutorial.androidflix.model.Movie;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviePosterViewHolder> {

    private LayoutInflater inflater;
    private List<Movie> movies;
    private Context context;

    class MoviePosterViewHolder extends RecyclerView.ViewHolder{
        ImageView moviePosterImage;


        public MoviePosterViewHolder(@NonNull View itemView) {
            super(itemView);
            moviePosterImage = (ImageView) itemView.findViewById(R.id.iv_poster);
        }
    }

    public MoviesAdapter(Context context, List<Movie> movies) {
        inflater = LayoutInflater.from(context);
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public MoviePosterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_movie_poster, parent, false);
        return new MoviePosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePosterViewHolder holder, int position) {
        final Movie item = movies.get(position);

        // download the poster
        Glide.with(context)
                .load(item.getPosterPath())
                .into(holder.moviePosterImage);

        holder.moviePosterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You clicked on "+ item.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}

