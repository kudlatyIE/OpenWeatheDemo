package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-10.
 * single json object in JsonArray in JsonArray "list"
 */

public class Weather {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("main")
    @Expose
    private String main;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("icon")
    @Expose
    private String icon;

    public int getWeatherId() {
        return id;
    }

    public String getMainWetherName() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getWeatherIcon() {
        return icon;
    }
}

/*
"weather": [
        {
            "id": 500,
            "main": "Rain",
            "description": "light rain",
            "icon": "10n"
        }
 */