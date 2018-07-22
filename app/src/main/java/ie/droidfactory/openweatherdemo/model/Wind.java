package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class Wind {

    @SerializedName("speed")
    @Expose
    private double speed;

    @SerializedName("deg")
    @Expose
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }
}
/*
"wind": {
        "speed": 3.61,
        "deg": 165.001
    }
 */
