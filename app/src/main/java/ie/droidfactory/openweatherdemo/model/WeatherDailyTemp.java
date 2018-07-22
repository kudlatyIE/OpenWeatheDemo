package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDailyTemp {


    @SerializedName("day")
    @Expose
    private double day;

    @SerializedName("min")
    @Expose
    private  double min;

    @SerializedName("max")
    @Expose
    private double max;

    @SerializedName("night")
    @Expose
    private double night;

    @SerializedName("eve")
    @Expose
    private  double eve;

    @SerializedName("morn")
    @Expose
    private double morn;

    public double getDay() {
        return day;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getNight() {
        return night;
    }

    public double getEve() {
        return eve;
    }

    public double getMorn() {
        return morn;
    }
}

/*
    "temp": {
			"day": 262.31,
			"min": 260.98,
			"max": 265.44,
			"night": 265.44,
			"eve": 264.18,
			"morn": 261.46
		}
 */
