package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class ForecastThreeHour {
    @JsonField
    public int dt;

    @JsonField
    public ForecastMain main;

    @JsonField
    public ArrayList<ForecastWeather> weather;
}
