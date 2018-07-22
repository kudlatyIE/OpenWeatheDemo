package ie.droidfactory.openweatherdemo;

import com.squareup.picasso.Picasso;

import dagger.Component;
import ie.droidfactory.openweatherdemo.api.ServiceWeatherToday;

/**
 * component - a bridge between @Inject and @Module
 * Add Scope to Provider module - do not use javax.inject.Singleton, just scope interface
 * @Scope is a 'singleton' for @Component instance which was created, java @Sigleton is a singleton for whole application
 */

@OpenWeatherApplicationScope
@Component(modules = {PicassoModule.class, ServiceWeatherTodayModule.class})
public interface OpenWeatherApplicationComponent {

    Picasso getPicasso();
    ServiceWeatherToday getServiceWeatherToday();
}
