package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class ForecastMain {
    @JsonField
    public double temp;

    @JsonField(name = "temp_min")
    public double tempMin;

    @JsonField(name = "temp_max")
    public double tempMax;

    @JsonField
    public int humidity;
}
