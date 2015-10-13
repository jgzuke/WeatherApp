package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class Forecast {
    @JsonField
    public int dt;

    @JsonField
    public ForecastMain main;

    @JsonField
    public ArrayList<ForecastWeather> weather;

    @JsonField
    public ForecastWind wind;

    public String getWeekday() {
        return ForecastFormattingUtils.dayOfWeek(dt);
    }

    public String getDate() {
        return ForecastFormattingUtils.date(dt);
    }

    public int getConditionImageID() {
        return ForecastFormattingUtils.condition(weather.get(0).id);
    }

    public String getHighLow() {
        return ForecastFormattingUtils.highLow(main.tempMax, main.tempMin);
    }

    public String getTemperature() {
        return ForecastFormattingUtils.temp(main.temp);
    }
}
