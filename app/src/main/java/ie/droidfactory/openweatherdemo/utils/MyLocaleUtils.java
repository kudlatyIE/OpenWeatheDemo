package ie.droidfactory.openweatherdemo.utils;

import java.util.Locale;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class MyLocaleUtils {

    public static MyLocale getLocaleUnits(Locale locale){
        String code = locale.getCountry().toUpperCase();
        switch (code){
            case "us": return MyLocale.IMPERIAL;
            case "LR": return MyLocale.IMPERIAL;
            case "MM": return MyLocale.IMPERIAL;
            case "GB": return MyLocale.IMPERIAL;
            case "IE": return MyLocale.METRIC;
            default: return MyLocale.METRIC;
        }

    }

}
