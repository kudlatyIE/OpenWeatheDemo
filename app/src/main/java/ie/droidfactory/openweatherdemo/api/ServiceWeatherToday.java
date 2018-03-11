package ie.droidfactory.openweatherdemo.api;


import ie.droidfactory.openweatherdemo.model.WeatherCondition;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static ie.droidfactory.openweatherdemo.api.NetworkUtils.*;

/**
 * Created by kudlaty on 2018-03-10.
 */

public interface ServiceWeatherToday {

    @GET(URL_TODAY)
    Call<WeatherCondition> getWeatherToday(@Query(PARAM_LAT) String valueLatitude, @Query(PARAM_LON) String valueLongitude);
    @GET(URL_TODAY)
    Call<WeatherCondition> getWeatherToday(@Query(PARAM_APP_ID) String appId, @Query(PARAM_LAT) String valueLatitude, @Query(PARAM_LON) String valueLongitude, @Query(PARAM_UNITS) String metric);

}
