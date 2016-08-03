package com.example.student.moviebooking;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import static com.example.student.moviebooking.Movie.listMovie;

public class MoviesActivity extends ListActivity {
    static final boolean icon = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                return listMovie();
            }
            @Override
            protected void onPostExecute(List<String> result) {
                movieAdapter adapter = new movieAdapter(MoviesActivity.this, R.layout.movies_row, result);
                setListAdapter(adapter);
            }
        }.execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String movie_item = (String) getListAdapter().getItem(position);
        Intent i = new Intent(this, TheatresActivity.class);
        i.putExtra("mid", movie_item);
        Log.e(movie_item,"movie_item");
        startActivity(i);
    }
}
