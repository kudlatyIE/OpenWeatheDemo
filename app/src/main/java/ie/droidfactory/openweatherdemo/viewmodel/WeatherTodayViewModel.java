package ie.droidfactory.openweatherdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import ie.droidfactory.openweatherdemo.api.NetworkUtils;
import ie.droidfactory.openweatherdemo.api.RetrofiteServiceFactory;
import ie.droidfactory.openweatherdemo.api.ServiceWeatherToday;
import ie.droidfactory.openweatherdemo.model.WeatherCondition;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class WeatherTodayViewModel extends ViewModel {

    private static final String TAG = WeatherTodayViewModel.class.getSimpleName();

    private MutableLiveData<WeatherCondition> mutableLiveData;

    public LiveData<WeatherCondition> loadWeatherToday(String apiId, String  lat, String lon, String metrc){
        if(mutableLiveData==null){
            mutableLiveData = new MutableLiveData<>();
            getWeatherToday(apiId, lat, lon, metrc);
        }
        return mutableLiveData;
    }


    private void getWeatherToday(String apiId, String lat, String lon, String metrc){

        ServiceWeatherToday service = RetrofiteServiceFactory.createService(ServiceWeatherToday.class, NetworkUtils.BASE_URL);
        Call<WeatherCondition> call  = service.getWeatherToday(apiId, lat, lon, metrc);

        call.enqueue(new Callback<WeatherCondition>() {
            @Override
            public void onResponse(Call<WeatherCondition> call, Response<WeatherCondition> response) {
                Log.d(TAG, "URL: "+response.headers());
                Log.d(TAG, "http response code: "+response.code());
                Log.d(TAG, "Response message: "+response.message());
                if(response.code()>=300){
                    Log.d(TAG, "http error code: "+response.code());

                    WeatherCondition weather = new WeatherCondition();
                    weather.setErrorResponse(response.code(), response.message());
                    mutableLiveData.setValue(weather);
                }else {
                    mutableLiveData.setValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<WeatherCondition> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }


}
/*
Error body:
{"cod":401, "message": "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info."}
 */
