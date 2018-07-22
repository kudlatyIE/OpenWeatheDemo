package ie.droidfactory.openweatherdemo;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = {ContextModule.class})
public class NetworkModule {

    /**
     * logs HTTP request and response data
     * @return instance od HttpLoginInterceptor
     */
    @Provides
    @OpenWeatherApplicationScope
    public HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

    @Provides
    @OpenWeatherApplicationScope
    public Cache cache(File cacheFile){
        return new Cache(cacheFile, 10*1000*1000);
    }

    public File cacheFile(@ApplicationContext Context context){
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @OpenWeatherApplicationScope
    public OkHttpClient okHttpClient(Cache cache, HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .build();
    }

}
