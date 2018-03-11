package ie.droidfactory.openweatherdemo.utils;

/**
 * Created by kudlaty on 2018-03-10.
 */

public enum MyLocale {

    METRIC("metric", "C", "meter/sec"), //Celsius, meter/sec
    IMPERIAL("imperial", "F", "miles/hour"), //Fahrenheit, miles/hour
    DEFAULT("default", "K", "meter/sec"); //Kelvin

    private String metricSystem, tempUnits, speedUnits;

    MyLocale(String metricSystem, String tempUnits, String speedUnits){
        this.metricSystem=metricSystem;
        this.tempUnits=tempUnits;
        this.speedUnits=speedUnits;
    }

    public String getMetricSystem() {
        return metricSystem;
    }

    public String getTempUnits() {
        return tempUnits;
    }

    public String getSpeedUnits() {
        return speedUnits;
    }
}
