package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherForecastDaily {

    @SerializedName("city")
    @Expose
    private CityDaily city;

    @SerializedName("list")
    @Expose
    private WeatherDailyItem[] list;

    public CityDaily getCity() {
        return city;
    }

    public WeatherDailyItem[] getList() {
        return list;
    }
}
