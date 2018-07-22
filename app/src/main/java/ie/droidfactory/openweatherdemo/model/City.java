package ie.droidfactory.openweatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("coord")
    @Expose
    private Coord coord;

    @SerializedName("country")
    @Expose
    private String country;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }
}

/*
"city": {
		"id": 524901,
		"name": "Moscow",
		"coord": {
			"lat": 55.7522,
			"lon": 37.6156
		},
		"country": "none"
	}
 */
