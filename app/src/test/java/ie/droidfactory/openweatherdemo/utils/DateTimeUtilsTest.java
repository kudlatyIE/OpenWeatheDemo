package ie.droidfactory.openweatherdemo.utils;

import android.util.Log;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Created by kudlaty on 2018-03-11.
 */
public class DateTimeUtilsTest {
    @Test
    public void getDate() throws Exception {
        long timestamp = 1520763660;
        Date date = new Date(timestamp*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM, dd", Locale.ENGLISH);
        System.out.println("DATE: "+ sdf.format(date));
    }

    @Test
    public void getTime() throws Exception {
        long timestamp = 1520763660;
        Date date = new Date(timestamp*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa", Locale.ENGLISH);
        System.out.println("TIME: "+ sdf.format(date));
    }

}