package ie.droidfactory.openweatherdemo.api;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class NetworkUtils {

    private static final String TAG = NetworkUtils.class.getSimpleName();


    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    public static final String ICON_URL = "http://openweathermap.org/";
    static final String URL_TODAY = "weather";
    static final String PARAM_UNITS = "units";
    static final String PARAM_LAT = "lat";
    static final String PARAM_LON = "lon";
    static final String PARAM_APP_ID = "appid";
}


/*

api.openweathermap.org/data/2.5/find?q=London&units=imperial
api.openweathermap.org/data/2.5/weather?lat=35&lon=139
 */