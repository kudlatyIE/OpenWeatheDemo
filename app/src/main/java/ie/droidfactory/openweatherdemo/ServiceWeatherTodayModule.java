package ie.droidfactory.openweatherdemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import ie.droidfactory.openweatherdemo.api.NetworkUtils;
import ie.droidfactory.openweatherdemo.api.ServiceWeatherToday;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class ServiceWeatherTodayModule {

    @Provides
    @OpenWeatherApplicationScope
    public ServiceWeatherToday getServiceWeatherToday(Retrofit weatherRetrofit){
        return weatherRetrofit.create(ServiceWeatherToday.class);
    }

    @Provides
    @OpenWeatherApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        return gsonBuilder.create();
    }

    @Provides
    @OpenWeatherApplicationScope
    public Retrofit retrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(NetworkUtils.BASE_URL)
                .build();
    }

}
