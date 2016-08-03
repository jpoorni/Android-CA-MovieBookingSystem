package com.example.student.moviebooking;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;

public class TimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);



        new AsyncTask<Void, Void, Movie>() {
            @Override
            protected Movie doInBackground(Void... params) {
                Intent i = getIntent();
                String mid = i.getStringExtra("mid1");
                return Movie.getMovie(mid);
            }
            protected void onPostExecute (Movie result) {
                showMovie(result);
            }
        }.execute();

//        final String[] Long1 = {null};
//        final String[] Long2 = {null};

        new AsyncTask<Void, Void, Theatre>() {
            @Override
            protected Theatre doInBackground(Void... params) {
                Intent i = getIntent();
                String tid = i.getStringExtra("tid1");
                Log.e(tid,"TID");
                return Theatre.getTheatre(tid);
            }
            protected void onPostExecute (Theatre result) {

//                Long1[0] = result.get("Long");
//                Long2[0] = result.get("Latt");
                showTheatre(result);
            }
        }.execute();

        Button button_movie = (Button) findViewById(R.id.button1_tirow);
        button_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TimeActivity.this, MapsActivity.class);
                Intent i1 = getIntent();
                String tid1 = i1.getStringExtra("tid1");
                i.putExtra("tid1", tid1);
                startActivityForResult(i, 80);
            }
        });


        Button button_pay = (Button) findViewById(R.id.button2_tirow);
        button_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TimeActivity.this, PaymentActivity.class);
                Intent i1 = getIntent();
//                String tid1 = i1.getStringExtra("tid1");
//                i.putExtra("tid1",tid1);
                startActivityForResult(i, 80);
            }
        });

    }

    void showMovie(Movie movie) {
        int []ids = {R.id.textView1_tirow, R.id.textView5_tirow, R.id.textView6_tirow};
        String []keys = {"MovieName", "MovieReview","TicketPrice"};
        for (int i=0; i<keys.length; i++) {
            TextView tv = (TextView) findViewById ( ids[i]);
            tv.setText(movie.get(keys[i]));
        }
        //new
        TextView tv = (TextView) findViewById(R.id.textView6_tirow);
        tv.setText( "$" + movie.get("TicketPrice"));

        TextView txt = (TextView) findViewById(R.id.textView1_tirow);
        final String mname = txt.getText().toString();
        final ImageView image = (ImageView) findViewById(R.id.imageView_tirow);

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {
                return Movie.getPhoto(false, mname);}
            @Override
            protected void onPostExecute(Bitmap result) {
                image.setImageBitmap(result);}
        }.execute();

    }

    void showTheatre(Theatre theatre) {
        int [] ids = {R.id.textView2_tirow, R.id.textView3_tirow, R.id.textView4_tirow};
        String []keys ={"TheatreName", "TheatreAddress1", "TheatreAddress2"};
        for (int i=0; i<keys.length; i++) {
            TextView tv = (TextView) findViewById ( ids[i]);
            tv.setText(theatre.get(keys[i]));
        }
    }

    public void onItemClick(AdapterView<?> av, View v, int position, long id) {

    }

}
