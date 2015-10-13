package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Model for Forecast temperature data, see https://github.com/bluelinelabs/LoganSquare
 */
@JsonObject
public class ForecastTemp {
    @JsonField
    public double min;

    @JsonField
    public double max;
}
