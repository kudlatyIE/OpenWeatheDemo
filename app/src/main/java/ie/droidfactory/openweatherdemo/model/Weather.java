package ie.droidfactory.openweatherdemo.model;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class Weather {
    private int id;
    private String main;
    private String description;
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