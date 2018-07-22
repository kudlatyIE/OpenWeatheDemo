package ie.droidfactory.openweatherdemo.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class IconResponse {

    @SerializedName("bitmap")
    @Expose
    private Bitmap bitmap;

    @SerializedName("responseCode")
    @Expose
    private int responseCode;

    @SerializedName("responseMessage")
    @Expose
    private String responseMessage;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
