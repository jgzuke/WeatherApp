package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Model for Forecast weather data, see https://github.com/bluelinelabs/LoganSquare
 */
@JsonObject
public class ForecastWeather {
    @JsonField
    public int id;

    @JsonField
    public String main;

    @JsonField
    public String icon;
}
