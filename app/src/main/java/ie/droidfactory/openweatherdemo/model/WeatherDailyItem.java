package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDailyItem {

    @SerializedName("dt")
    @Expose
    private long dt; //timestamp

    @SerializedName("temp")
    @Expose
    private WeatherDailyTemp temp;

    @SerializedName("pressure")
    @Expose
    private double pressure;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("weather")
    @Expose
    private Weather[] weather;

    @SerializedName("speed")
    @Expose
    private double speed;

    @SerializedName("deg")
    @Expose
    private int deg;

    @SerializedName("clouds")
    @Expose
    private int clouds;

    @SerializedName("snow")
    @Expose
    private double snow;

    public long getDt() {
        return dt;
    }

    public WeatherDailyTemp getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public int getClouds() {
        return clouds;
    }

    public double getSnow() {
        return snow;
    }
}

/*
{
		"dt": 1485853200,
		"temp": {
			"day": 262.31,
			"min": 260.98,
			"max": 265.44,
			"night": 265.44,
			"eve": 264.18,
			"morn": 261.46
		},
		"pressure": 1018.1,
		"humidity": 91,
		"weather": [{
			"id": 600,
			"main": "Snow",
			"description": "light snow",
			"icon": "13d"
		}],
		"speed": 4.1,
		"deg": 249,
		"clouds": 88,
		"snow": 1.44
	}
 */
