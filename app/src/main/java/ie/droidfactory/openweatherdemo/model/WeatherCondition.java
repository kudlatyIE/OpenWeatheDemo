package ie.droidfactory.openweatherdemo.model;

/**
 * Created by kudlaty on 2018-03-10.
 */

public class WeatherCondition {

    private Coord cord;
    private Weather[] weather;
    private String base;
    private MainCondition main;
    private Wind wind;
    private Rain rain;
    private Clouds clouds;
    private long dt;// UNIX UTC timestamp
    private Sun sys;
    private int id;
    private String name;
    private int cod;
    private ErrorResponse errorResponse;

    public Coord getCord() {
        return cord;
    }

    public Weather getWeather() {
        return weather[0];
    }

    public String getBase() {
        return base;
    }

    public MainCondition getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public Sun getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public int getResponseCode(){
        return errorResponse.getResponseCode();
    }
    public String getErrorMessage(){
        return errorResponse.getErrorMessage();
    }


    public void setErrorResponse(int responseCode, String errorMessage) {
        if(errorResponse==null) errorResponse = new ErrorResponse();
        errorResponse.setResponseCode(responseCode);
        errorResponse.setSrrorMessage(errorMessage);
    }
}
//TODO: implement  ObservableFields

/*

    "coord": {
        "lon": -0.13,
        "lat": 51.51
    },
    "weather": [
        {
            "id": 500,
            "main": "Rain",
            "description": "light rain",
            "icon": "10n"
        }
    ],
    "base": "cmc stations",
    "main": {
        "temp": 286.164,
        "pressure": 1017.58,
        "humidity": 96,
        "temp_min": 286.164,
        "temp_max": 286.164,
        "sea_level": 1027.69,
        "grnd_level": 1017.58
    },
    "wind": {
        "speed": 3.61,
        "deg": 165.001
    },
    "rain": {
        "3h": 0.185
    },
    "clouds": {
        "all": 80
    },
    "dt": 1446583128,
    "sys": {
        "message": 0.003,
        "country": "GB",
        "sunrise": 1446533902,
        "sunset": 1446568141
    },
    "id": 2643743,
    "name": "London",
    "cod": 200
}
 */
