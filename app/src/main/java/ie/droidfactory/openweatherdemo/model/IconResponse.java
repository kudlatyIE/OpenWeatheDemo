package ie.droidfactory.openweatherdemo.model;

import android.graphics.Bitmap;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class IconResponse {

    private Bitmap bitmap;
    private int responseCode;
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
