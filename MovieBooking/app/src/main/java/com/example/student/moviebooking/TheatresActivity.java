package com.example.student.moviebooking;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;


public class TheatresActivity extends ListActivity {
    String mid1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String mid = getIntent().getStringExtra("mid");
        mid1 = (String) mid;
        new AsyncTask<Void, Void, List<Theatre>>() {
            @Override
            protected List<Theatre> doInBackground(Void... params) {
                return Theatre.getMovieTheatres(mid);
            }

            @Override
            protected void onPostExecute(List<Theatre> result) {
                SimpleAdapter adapter = new SimpleAdapter(TheatresActivity.this, result, R.layout.theatres_row,
                        new String[]{"TheatreName", "TheatreAddress1", "TheatreAddress2", "Pincode"},
                        new int[]{R.id.textView1_trow, R.id.textView2_trow, R.id.textView3_trow, R.id.textView4_trow});
                setListAdapter(adapter);
            }
        }.execute();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Theatre theatre_item = (Theatre) getListAdapter().getItem(position);
        String tid1 = (String) theatre_item.get("TheatreID");
        Log.e(tid1,"TTTIIIDDDD");
        Intent i = new Intent(this, TimeActivity.class);
        i.putExtra("tid1", tid1); //theatre object
        i.putExtra("mid1", mid1); //movie name
        startActivity(i);
    }
}
