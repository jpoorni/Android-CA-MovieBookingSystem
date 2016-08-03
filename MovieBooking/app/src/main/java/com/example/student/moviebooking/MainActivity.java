package com.example.student.moviebooking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_movie = (Button) findViewById(R.id.button1_main);
        button_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MoviesActivity.class);
                startActivityForResult(i, 80);
            }
        });

        Button button_theatre = (Button) findViewById(R.id.button2_main);
        button_theatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TheatreMapsActivity.class);
                startActivityForResult(i, 80);
            }
        });
    }
}
