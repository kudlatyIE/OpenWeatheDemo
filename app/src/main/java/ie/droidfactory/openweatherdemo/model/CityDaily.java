package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityDaily {

    @SerializedName("geoname_id")
    @Expose
    private int geoname_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("lat")
    @Expose
    private double lat;

    @SerializedName("lon")
    @Expose
    private double lon;

    @SerializedName("country")
    @Expose
    private String country;

    public int getGeoname_id() {
        return geoname_id;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getCountry() {
        return country;
    }
}

/*
"city": {
		"geoname_id": 524901,
		"name": "Moscow",
		"lat": 55.7522,
		"lon": 37.6156,
		"country": "RU",
		"iso2": "RU",
		"type": "city",
		"population": 0
	}
 */