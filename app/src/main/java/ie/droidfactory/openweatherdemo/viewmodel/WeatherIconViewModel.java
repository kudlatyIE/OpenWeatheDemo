package ie.droidfactory.openweatherdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;

import ie.droidfactory.openweatherdemo.api.NetworkUtils;
import ie.droidfactory.openweatherdemo.api.RetrofiteServiceFactory;
import ie.droidfactory.openweatherdemo.api.ServiceWeatherIcon;
import ie.droidfactory.openweatherdemo.model.IconResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class WeatherIconViewModel extends ViewModel{

    private static final String TAG = WeatherIconViewModel.class.getSimpleName();

    private MutableLiveData<IconResponse> mutableLiveData;

    public LiveData<IconResponse> loadWeatherIcon(String iconName, double resizeFactor){
        if(mutableLiveData==null){
            mutableLiveData = new MutableLiveData<>();
            getWeatherIcon(iconName, resizeFactor);
        }
        return mutableLiveData;
    }

    private void getWeatherIcon(final String iconName, final double resizeFactor){
        String url = NetworkUtils.ICON_URL;

        ServiceWeatherIcon service = RetrofiteServiceFactory.createService(ServiceWeatherIcon.class, url);

        Call<ResponseBody> call = service.getIcon(iconName);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                IconResponse iconResponse = new IconResponse();
                Log.d(TAG, "URL: "+response.headers());
                Log.d(TAG, "http response code: "+response.code());
                Log.d(TAG, "Response message: "+response.message());
                if((response.code()>=300)){
                    Log.d(TAG, "Error: "+response.code()+" - unable to download icon: "+iconName);
                    iconResponse.setResponseCode(response.code());
                    iconResponse.setResponseMessage(response.message());

                }else {

                    try {
                        byte[] bytes = response.body().bytes();
                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*resizeFactor), (int)(bitmap.getHeight()*resizeFactor), true);
                        iconResponse.setBitmap(newBitmap);
                        iconResponse.setResponseCode(response.code());
                        iconResponse.setResponseMessage(response.message());
                    } catch (IOException e) {
                        e.printStackTrace();
                        iconResponse.setResponseCode(500);
                        iconResponse.setResponseMessage(e.getMessage());
                    }

                }
                mutableLiveData.setValue(iconResponse);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

}
