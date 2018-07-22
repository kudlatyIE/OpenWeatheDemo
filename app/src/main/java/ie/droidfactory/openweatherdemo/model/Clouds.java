package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class Clouds {

    @SerializedName("all")
    @Expose
    private int all;

    public int getAllClouds() {
        return all;
    }
}

/*
"clouds": {
        "all": 80
    }
 */
