package ie.droidfactory.openweatherdemo;

import android.Manifest;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import ie.droidfactory.openweatherdemo.api.NetworkUtils;
import ie.droidfactory.openweatherdemo.model.IconResponse;
import ie.droidfactory.openweatherdemo.model.WeatherCondition;
import ie.droidfactory.openweatherdemo.utils.DataFormatUtils;
import ie.droidfactory.openweatherdemo.utils.LocationUtils;
import ie.droidfactory.openweatherdemo.utils.MyLocale;
import ie.droidfactory.openweatherdemo.utils.MyLocaleUtils;
import ie.droidfactory.openweatherdemo.utils.PermissionResultCallback;
import ie.droidfactory.openweatherdemo.utils.PermissionUtils;
import ie.droidfactory.openweatherdemo.viewmodel.WeatherIconViewModel;
import ie.droidfactory.openweatherdemo.viewmodel.WeatherTodayViewModel;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback, PermissionResultCallback{

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView tvDate, tvLocation, tvDescription, tvSunset, tvSunrise, tvTempMini, tvTempMax, tvWind, tvPressure, tvTempNow, tvHumidity;
    private ImageView imgWeather;
    private Button btnRefresh;
    private ScrollView weatherLauout;
    private View viewMain;
    private ArrayList<String> permissions=new ArrayList<>();
    private PermissionUtils permissionUtils;
    public  static final int PERMISSIONS_REQUEST = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRefresh = findViewById(R.id.button_main_refresh);
        weatherLauout = findViewById(R.id.layout_main_weather);
        btnRefresh.setVisibility(View.GONE);

        viewMain = findViewById(R.id.main_lauout);

        //TODO: get weather ICON and set in layout

        loadViews();
        chechPermissions();


    }

    private void loadWeather(double lat, double lon, String metric){
        String sLat, sLon;
        sLat = String.valueOf(lat);
        sLon = String.valueOf(lon);
//        sLat = "53.3";
//        sLon = "-6.26";
        final double resizeFactor = 4.0;

        if (isInternetOn(this)){
            WeatherTodayViewModel weatherTodayViewModel = ViewModelProviders.of(this).get(WeatherTodayViewModel.class);
            weatherTodayViewModel.loadWeatherToday(NetworkUtils.API_KEY, sLat, sLon, metric).observe(this, new Observer<WeatherCondition>() {
                @Override
                public void onChanged(@Nullable WeatherCondition weatherCondition) {
                    Log.d(TAG, "onChange");
                    if(weatherCondition.getErrorResponse()!=null){
                        Log.d(TAG,"err code: "+weatherCondition.getErrorResponse().getResponseCode()+" "+weatherCondition.getErrorResponse().getErrorMessage());

                    }else {
                        Log.d(TAG, "weather dec: "+weatherCondition.getWeather().getDescription()+" temp: "+weatherCondition.getMain().getTemp());
                        Log.d(TAG, "weather location: "+weatherCondition.getName());
                        setWeatherData(weatherCondition, MyLocaleUtils.getLocaleUnits(getResources().getConfiguration().locale));
                        loadWeatherIcon(weatherCondition.getWeather().getWeatherIcon()+".png", resizeFactor);
                    }

                }
            });
            Log.d(TAG, "loadWeather end");
        }else {
            showSnackbar("turn ON internet connection");
            Log.d(TAG, "turn ON internet connection");
        }
    }

    private void loadWeatherIcon(String iconName, double resizeFactor){
        Log.d(TAG, "load icon running...");
        WeatherIconViewModel viewModel = ViewModelProviders.of(this).get(WeatherIconViewModel.class);
        viewModel.loadWeatherIcon(iconName, resizeFactor).observe(this, new Observer<IconResponse>() {
            @Override
            public void onChanged(@Nullable IconResponse iconResponse) {

                if(iconResponse!=null){
                    if(iconResponse.getResponseCode()==200){
                        imgWeather.setImageBitmap(iconResponse.getBitmap());
                    }else {
                        Log.d(TAG, "weather icon is null: "+iconResponse.getResponseMessage());
                    }
                }else {
                    Log.d(TAG, "weather icon is null");
                }

            }
        });
    }

    private void showSnackbar(String message){
        final Snackbar snackbar = Snackbar.make(viewMain, message, Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("DISMISS", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        });
    }


    private void chechPermissions(){
        permissionUtils=new PermissionUtils(this);
        permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionUtils.check_permission(permissions,"dialog context", PERMISSIONS_REQUEST );
    }

    private boolean isInternetOn(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }

    @Override
    public void PermissionGranted(int request_code) {
        Location location = LocationUtils.getLatLng(this);
        if(location!=null){
            weatherLauout.setVisibility(View.VISIBLE);
            loadWeather(location.getLatitude(), location.getLongitude(), MyLocaleUtils.getLocaleUnits(getResources().getConfiguration().locale).getMetricSystem());
        }else {
            weatherLauout.setVisibility(View.GONE);
            showSnackbar("current location not available");
        }

    }

    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {
        weatherLauout.setVisibility(View.GONE);
        showSnackbar("Location Access Permission Denied");
    }

    @Override
    public void PermissionDenied(int request_code) {
        weatherLauout.setVisibility(View.GONE);
        showSnackbar("Location Access Permission Denied");
    }

    @Override
    public void NeverAskAgain(int request_code) {

    }
    private void setWeatherData(WeatherCondition wc, MyLocale locale){
        tvDate.setText(DataFormatUtils.getDate(wc.getDt()));
        tvDescription.setText(wc.getWeather().getDescription());
        tvHumidity.setText(DataFormatUtils.getHumidity(wc.getMain().getHumidity()));
        tvLocation.setText(wc.getName());
        tvPressure.setText(DataFormatUtils.getPressure(wc.getMain().getPressure()));
        tvSunrise.setText(DataFormatUtils.getTime(wc.getSys().getSunrise()));
        tvSunset.setText(DataFormatUtils.getTime(wc.getSys().getSunset()));
        tvTempMini.setText(DataFormatUtils.getTemperature(wc.getMain().getTemp_min(),locale));
        tvTempMax.setText(DataFormatUtils.getTemperature(wc.getMain().getTemp_max(),locale));
        tvTempNow.setText(DataFormatUtils.getTemperature(wc.getMain().getTemp(), locale));
        tvWind.setText(DataFormatUtils.getWindSpeed(wc.getWind().getSpeed(),locale));


    }

    private void loadViews(){
//        weatherLauout.setVisibility(View.VISIBLE);
        tvDate=findViewById(R.id.text_main_weather_date);
        imgWeather=findViewById(R.id.imageView_main_weather_icon);
        tvDescription=findViewById(R.id.text_main_weather_description);
        tvHumidity=findViewById(R.id.text_main_weather_humidity_value);
        tvLocation=findViewById(R.id.text_main_weather_location_name);
        tvPressure=findViewById(R.id.text_main_weather_pressure_value);
        tvSunrise=findViewById(R.id.text_main_weather_sunrise_value);
        tvSunset=findViewById(R.id.text_main_weather_sunset_value);
        tvTempMax=findViewById(R.id.text_main_weather_temperature_max_value);
        tvTempMini=findViewById(R.id.text_main_weather_temperature_min_value);
        tvTempNow=findViewById(R.id.text_main_weather_temperature_current_value);
        tvWind=findViewById(R.id.text_main_weather_wind_speed_value);

    }
}
