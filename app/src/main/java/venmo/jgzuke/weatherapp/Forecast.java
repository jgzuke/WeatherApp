package venmo.jgzuke.weatherapp;

import android.content.Context;

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
    public ForecastTemp temp;

    @JsonField
    public int humidity;

    @JsonField
    public ArrayList<ForecastWeather> weather;

    public String getWeekday() {
        return ForecastFormattingUtils.dayOfWeek(dt);
    }

    public String getDate() {
        return ForecastFormattingUtils.date(dt);
    }

    public String getHighLow() {
        return ForecastFormattingUtils.highLow(temp.max, temp.min);
    }

    public String getDescription() {
        return weather.get(0).main;
    }

    public String getHumidity() {
        return ForecastFormattingUtils.humidity(humidity);
    }

    public String getIconId(Context context) {
        return ForecastFormattingUtils.iconId(weather.get(0).icon, context);
    }
}
