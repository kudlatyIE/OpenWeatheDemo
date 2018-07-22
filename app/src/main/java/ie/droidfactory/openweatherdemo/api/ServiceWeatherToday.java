package ie.droidfactory.openweatherdemo.api;


import ie.droidfactory.openweatherdemo.model.WeatherCondition;
import ie.droidfactory.openweatherdemo.model.WeatherForecastDaily;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static ie.droidfactory.openweatherdemo.api.NetworkUtils.*;

/**
 * Created by kudlaty on 2018-03-10.
 */

public interface ServiceWeatherToday {

    @GET(URL_WEATHER_TODAY)
    Call<WeatherCondition> getWeatherToday(
            @Query(PARAM_LAT) String valueLatitude,
            @Query(PARAM_LON) String valueLongitude);

    /**
     * get current weather for location
     * @param appId api key
     * @param valueLatitude location lat
     * @param valueLongitude location lon
     * @param metric metric units
     * @return
     */
    @GET(URL_WEATHER_TODAY)
    Call<WeatherCondition> getWeatherToday(
            @Query(PARAM_APP_ID) String appId,
            @Query(PARAM_LAT) String valueLatitude,
            @Query(PARAM_LON) String valueLongitude,
            @Query(PARAM_UNITS) String metric);

    /**
     * get forecast for number of days for location ID
     * @param appId api key
     * @param locationId location ID
     * @param days forecast days' number
     * @param metrics metrics units
     * @return
     */
    @GET(URL_WEATHER_DAILY)
    Call<WeatherForecastDaily> getWeatherForecastDailyForLocationId(
            @Query(PARAM_APP_ID) String appId,
            @Query(PARAM_LOCATION_ID) String locationId,
            @Query(PARAM_DAYS_COUNT) String days,
            @Query(PARAM_UNITS) String metrics
    );

    /**
     *  get forecast for number of days for location latitude, longitude
     * @param appId api key
     * @param valueLatitude location lat
     * @param valueLongitude location lon
     * @param days forecast days' number
     * @param metrics metrics units
     * @return
     */
    @GET(URL_WEATHER_DAILY)
    Call<WeatherForecastDaily> getWeatherForecastDailyForLocationCoordinates(
            @Query(PARAM_APP_ID) String appId,
            @Query(PARAM_LAT) String valueLatitude,
            @Query(PARAM_LON) String valueLongitude,
            @Query(PARAM_DAYS_COUNT) String days,
            @Query(PARAM_UNITS) String metrics
    );

}
