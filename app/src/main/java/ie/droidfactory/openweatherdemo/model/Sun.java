package ie.droidfactory.openweatherdemo.model;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class Sun {
    private double message;
    private String country;
    private long sunrise; // UNIX UTC timestamp
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
