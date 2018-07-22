package ie.droidfactory.openweatherdemo.api;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();


    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String ICON_URL = "http://openweathermap.org/";

    static final String URL_WEATHER_TODAY = "weather";//weather forecast now
    static final String URL_WEATHER_DAILY = "forecast/daily";//weather forecast for max 16 days
    static final String URL_WEATHER_CITIES_GROUP = "group";//current weather forecast for cities IDs
    static final String URL_WEATHER_5_DAYS_EVERY_3_HOURS = "forecast";//weather forecast for 5 days every 3 hours

    static final String PARAM_DAYS_COUNT = "cnt";
    static final String PARAM_LOCATION_ID = "id";
    static final String PARAM_UNITS = "units";
    static final String PARAM_LAT = "lat";
    static final String PARAM_LON = "lon";
    static final String PARAM_APP_ID = "appid";
}


/*

api.openweathermap.org/data/2.5/find?q=London&units=imperial
api.openweathermap.org/data/2.5/weather?lat=35&lon=139
 */