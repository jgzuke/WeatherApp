package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class Response {
    @JsonField
    public ArrayList<Forecast> list;



    @JsonObject
    public class Forecast {
        @JsonField
        public int dt;

        @JsonField
        public ForecastMain main;

        @JsonField
        public ArrayList<ForecastWeather> weather;

        @JsonField
        public ForecastClouds clouds;

        @JsonField
        public ForecastWind wind;

        @JsonObject
        public class ForecastMain {
            @JsonField
            public double temp;

            @SerializedName("temp_min") // Annotation needed for GSON
            @JsonProperty("temp_min") // Annotation needed for Jackson Databind
            @JsonField(name = "temp_min")
            public double tempMin;

            @SerializedName("temp_max") // Annotation needed for GSON
            @JsonProperty("temp_max") // Annotation needed for Jackson Databind
            @JsonField(name = "temp_max")
            public double tempMax;

            @JsonField
            public int humidity;
        }

        @JsonObject
        public class ForecastWeather {
            @JsonField
            public int id;
        }

        @JsonObject
        public class ForecastClouds {
            @JsonField
            public int all;
        }

        @JsonObject
        public class ForecastWind {
            @JsonField
            public double speed;
        }
    }
}
