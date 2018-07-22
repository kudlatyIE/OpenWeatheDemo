package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class ErrorResponse {

    @SerializedName("responseCode")
    @Expose
    private int responseCode;

    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSrrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
