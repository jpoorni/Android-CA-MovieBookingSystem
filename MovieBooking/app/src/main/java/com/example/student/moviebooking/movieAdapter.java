package com.example.student.moviebooking;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static com.example.student.moviebooking.Movie.listMovie;

public class movieAdapter extends ArrayAdapter<String> {
    private List<String> items;
    int layout;

    public movieAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(layout, null);
        final String mid = items.get(position);
        if (mid != null) {
            TextView m = (TextView) v.findViewById(R.id.textView_mrow);
            m.setText(mid);
            final ImageView image = (ImageView) v.findViewById(R.id.imageView_mrow);

            new AsyncTask<Void, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(Void... params) {
                    return Movie.getPhoto(false, mid);
                }
                @Override
                protected void onPostExecute(Bitmap result) {
                    image.setImageBitmap(result);
                }
            }.execute();
        }
        return v;
    }
}
