package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class ForecastWeather {
    @JsonField
    public int id;
}
