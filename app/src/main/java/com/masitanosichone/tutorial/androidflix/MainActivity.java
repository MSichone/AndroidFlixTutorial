package com.masitanosichone.tutorial.androidflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.masitanosichone.tutorial.androidflix.adapter.MoviesAdapter;
import com.masitanosichone.tutorial.androidflix.model.Movie;
import com.masitanosichone.tutorial.androidflix.utility.Utils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvMovies;
    private Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Setup the U.I
        rvMovies = findViewById(R.id.rv_movies);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this,
                RecyclerView.HORIZONTAL, false);
        rvMovies.setLayoutManager(mLinearLayoutManager);
        MoviesAdapter adapter = new MoviesAdapter(this, getMoviesFromJsonFile());
        rvMovies.setAdapter(adapter);
    }

    public List<Movie> getMoviesFromJsonFile(){

        Gson gson = new Gson();

        Type listMovieType = new TypeToken<List<Movie>>() { }.getType();
        String jsonFileString = Utils.getJsonFromAssets(Objects.requireNonNull(this), "movies.json");

        return gson.fromJson(jsonFileString,listMovieType);
    }

}
