package ie.droidfactory.openweatherdemo.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class MyLocationListener  implements LocationListener {

    private final static String TAG=MyLocationListener.class.getSimpleName();
    private double myLongitude, myLatitude;

    @Override
    public void onLocationChanged(Location location) {

        myLatitude = location.getLatitude();
        myLongitude = location.getLongitude();
        Log.d(TAG, "onLocationChanged, lat: "+myLatitude+" lng: "+myLongitude);

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
        Log.d(TAG, "status changed, provider: "+provider+" status: "+status);

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
        Log.d(TAG, "provider enabled: "+provider);

    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub


    }


}