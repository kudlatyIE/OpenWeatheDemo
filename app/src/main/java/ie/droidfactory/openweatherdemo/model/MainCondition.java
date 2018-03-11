package ie.droidfactory.openweatherdemo.model;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class MainCondition {
    private double temp;
    private int  pressure;
    private int humidity;
    private double temp_min;
    private double temp_max;
    private double sea_level;
    private double grnd_level;

    public double getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getSea_level() {
        return sea_level;
    }

    public double getGrnd_level() {
        return grnd_level;
    }
}

/*
"main": {
        "temp": 286.164,
        "pressure": 1017.58,
        "humidity": 96,
        "temp_min": 286.164,
        "temp_max": 286.164,
        "sea_level": 1027.69,
        "grnd_level": 1017.58
    }
 */