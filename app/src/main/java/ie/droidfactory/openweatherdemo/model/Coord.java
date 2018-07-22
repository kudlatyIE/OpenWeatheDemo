package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class Coord {

    @SerializedName("lon")
    @Expose
    private double lon;

    @SerializedName("lat")
    @Expose
    private double lat;

    public double getLongitude() {
        return lon;
    }

    public double getLatitude() {
        return lat;
    }
}

/*
"coord": {
        "lon": -0.13,
        "lat": 51.51
    }
 */