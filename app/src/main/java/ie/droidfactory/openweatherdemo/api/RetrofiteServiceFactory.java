package ie.droidfactory.openweatherdemo.api;

import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class RetrofiteServiceFactory {
    private static final String TAG = RetrofiteServiceFactory.class.getSimpleName();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
//                    .baseUrl(NetworkUtils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(new Converter.Factory(){

                    });

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .client(httpClient.build()).build();
        Log.d(TAG, "URL: "+retrofit.baseUrl());
        return retrofit.create(serviceClass);
    }
}
