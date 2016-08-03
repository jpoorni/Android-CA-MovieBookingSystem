package com.example.student.moviebooking;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Theatre extends HashMap<String, String> {
    final static String baseURL = "http://10.10.1.149/moviebooking/service.svc/GetMovieTheatres";
    final static String getTheatreURL ="http://10.10.1.149/moviebooking/service.svc/GetTheatre";

    public Theatre(String TheatreID, String TheatreName, String TheatreAddress1, String TheatreAddress2, String Long, String Latt) {
        put("TheatreID",TheatreID);
        put("TheatreName",TheatreName);
        put("TheatreAddress1",TheatreAddress1);
        put("TheatreAddress2",TheatreAddress2);
        put("Long",Long);
        put("Latt",Latt);
    }

    public Theatre(String TheatreID, String TheatreName, String TheatreAddress1, String TheatreAddress2, String Pincode) {
        put("TheatreID",TheatreID);
        put("TheatreName",TheatreName);
        put("TheatreAddress1",TheatreAddress1);
        put("TheatreAddress2",TheatreAddress2);
        put("Pincode",Pincode);
    }

    public static List<Theatre> getMovieTheatres(String mid) {
        List<Theatre> list = new ArrayList<Theatre>();
        try {
            JSONArray a = JSONParser.getJSONArrayFromUrl(baseURL + "/" +mid);
            for (int i =0; i<a.length(); i++){
                JSONObject b = a.getJSONObject(i);
                list.add(new Theatre(b.getString(("TheatreID")),b.getString("TheatreName"), b.getString("TheatreAddress1"),
                        b.getString("TheatreAddress2"), b.getString("Pincode")));
            }
        } catch (Exception e) {
            Log.e("Theatre.list()", "JSONArray error");
        }
        return(list);
    }

    public static Theatre getTheatre(String tid) {
        JSONObject b = JSONParser.getJSONFromUrl(getTheatreURL + "/" + tid);
        try {
            return new Theatre(b.getString("TheatreID"), b.getString("TheatreName"), b.getString("TheatreAddress1"),
                    b.getString("TheatreAddress2"), Double.toString(b.getDouble("Long")), Double.toString(b.getDouble("Latt")));
        } catch (Exception e) {
            Log.e("Theatre.getTheatre()", "JSONArray error");
        }
        return(null);
    }
}
