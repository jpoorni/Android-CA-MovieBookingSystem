package com.example.student.moviebooking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Movie extends HashMap<String, String> {
    final static String baseURL = "http://10.10.1.149/moviebooking/service.svc/List";
    final static String getMovieURL = "http://10.10.1.149/moviebooking/service.svc/GetMovie";
    final static String imageURL ="http://10.10.1.149/moviebooking/Image";

    public Movie(String MovieID, String MovieName, String TheatreID, String MovieReview, String MovieSeats, String TicketPrice ) {
        put("MovieID",MovieID);
        put("MovieName",MovieName);
        put("TheatreID",TheatreID);
        put("MovieReview",MovieReview);
        put("MovieSeats",MovieSeats);
        put("TicketPrice",TicketPrice);
    }

    public Movie(String MovieName,String MovieReview,String TicketPrice ) {
        put("MovieName",MovieName);
        put("MovieReview",MovieReview);
        put("TicketPrice",TicketPrice);
    }



    public static List<String> listMovie() {
        List<String> list = new ArrayList<String>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(baseURL);
            for (int i =0; i<a.length(); i++)
                list.add(a.getString(i));
        } catch (Exception e) {
            Log.e("Movie.list()", "JSONArray error");
        }
        return(list);
    }

    public static Movie getMovie(String mid) {
        JSONObject b = JSONParser.getJSONFromUrl(getMovieURL + "/" + mid);
        try {
            return new Movie( b.getString("MovieName"), b.getString("MovieReview"), b.getString("TicketPrice"));
        } catch (Exception e) {
            Log.e("Movie.getMovie()", "JSONArray error");
        }
        return(null);
    }

    public static Bitmap getPhoto(boolean thumbnail, String mid) {
        try {
            URL url = (thumbnail ? new URL(String.format("%s/small-%s.jpg",imageURL, mid)) :
                    new URL(String.format("%s/%s.jpg",imageURL, mid)));
            URLConnection conn = url.openConnection();
            InputStream ins = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(ins);
            ins.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Movie.getPhoto()", "JSONArray error");
        }
        return(null);
    }
}
