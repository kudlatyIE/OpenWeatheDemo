package ie.droidfactory.openweatherdemo.model;

/**
 * Created by kudlaty on 2018-03-11.
 */

public class ErrorResponse {
    private int responseCode;
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
