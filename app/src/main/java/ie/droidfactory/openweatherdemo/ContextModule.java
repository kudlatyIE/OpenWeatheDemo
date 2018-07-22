package ie.droidfactory.openweatherdemo;

import android.content.Context;

import dagger.Provides;

public class ContextModule {

    private final Context context;

    public ContextModule(Context context){
        this.context=context;
    }

    @Provides
    @OpenWeatherApplicationScope
    @ApplicationContext
    public Context context(){
        return context;
    }
}
