package ie.droidfactory.openweatherdemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class DataFormatUtils {

    public static String getDate(long timestamp){
        Date date = new Date(timestamp*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM, dd", Locale.ENGLISH);

        return sdf.format(date);
    }

    public static String getTime(long timestamp){
        Date date = new Date(timestamp*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);

        return sdf.format(date);
    }

    public static String getHumidity(int humidity){

        return String.valueOf(humidity).concat(" %");
    }

    public static String getPressure(int pressure){
        return String.valueOf(pressure).concat(" hPa");
    }

    public static String getWindSpeed(double windSpeed, MyLocale locale){
        return String.valueOf(windSpeed).concat(" "+locale.getSpeedUnits());
    }
    public static String getTemperature(double temperature, MyLocale locale){
        return String.valueOf(temperature).concat(" "+locale.getTempUnits());
    }
}
