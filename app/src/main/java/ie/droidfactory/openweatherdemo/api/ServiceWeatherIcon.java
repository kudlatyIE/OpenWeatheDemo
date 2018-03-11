package ie.droidfactory.openweatherdemo.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kudlaty on 2018-03-10.
 */

public interface ServiceWeatherIcon {

    @GET("img/w/{imageName}")
    Call<ResponseBody> getIcon(@Path("imageName") String imageName);
}
