package ie.droidfactory.openweatherdemo;

import android.app.Activity;
import android.app.Application;

import com.squareup.picasso.Picasso;

import ie.droidfactory.openweatherdemo.api.ServiceWeatherToday;
import timber.log.Timber;

public class OpenWeatherApplication extends Application {

    private OpenWeatherApplicationComponent component;

    private OpenWeatherApplication get(Activity activity){
        return (OpenWeatherApplication) activity.getApplication();
    }

    private ServiceWeatherToday serviceWeatherToday;

    private Picasso picasso;

    @Override
    public void onCreate(){
        super.onCreate();
        /*
        plant default debug logs tree
         */
        Timber.plant(new Timber.DebugTree());

        /*
         * add all modules in application component
         */
        component = DaggerOpenWeatherApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .networkModule(new NetworkModule())
                .picassoModule(new PicassoModule())
                .serviceWeatherTodayModule(new ServiceWeatherTodayModule())
                .build();

        serviceWeatherToday = component.getServiceWeatherToday();
        picasso = component.getPicasso();
    }

    public OpenWeatherApplicationComponent getComponent() {
        return component;
    }
}
