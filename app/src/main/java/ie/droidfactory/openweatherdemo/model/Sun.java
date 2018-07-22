package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-10.
 * contain sunset and sunrise timestamp, country code
 */

public class Sun {

    @SerializedName("message")
    @Expose
    private double message;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("sunrise")
    @Expose
    private long sunrise; // UNIX UTC timestamp

    @SerializedName("sunset")
    @Expose
    private long sunset; // UNIX UTC timestamp

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}

/*
"sys": {
        "message": 0.003,
        "country": "GB",
        "sunrise": 1446533902,
        "sunset": 1446568141
    }
 */
