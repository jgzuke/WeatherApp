package venmo.jgzuke.weatherapp;

import android.content.Context;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Model for forecasts, see https://github.com/bluelinelabs/LoganSquare
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

    /*
     * Utility functions to return properly formatted data, using ForecastFormattingUtils
     */

    /**
     * Returns short day of week
     * @return eg. Mon
     */
    public String getWeekday() {
        return ForecastFormattingUtils.dayOfWeek(dt);
    }

    /**
     * Returns date
     * @return eg. Oct 13
     */
    public String getDate() {
        return ForecastFormattingUtils.date(dt);
    }

    /**
     * Returns Temp high/low
     * @return eg. 57°/43°
     */
    public String getHighLow() {
        return ForecastFormattingUtils.highLow(temp.max, temp.min);
    }

    /**
     * Returns short description of weather
     * @return eg. Sunny
     */
    public String getDescription() {
        return ForecastFormattingUtils.weather(weather.get(0).main);
    }

    /**
     * Returns humidity percent
     * @return eg. 86% humidity
     */
    public String getHumidity() {
        return ForecastFormattingUtils.humidity(humidity);
    }

    /**
     * Returns weather icon ID
     * @param context used to get string from resources
     * @return String used as ID to get weather icon see http://erikflowers.github.io/weather-icons/
     */
    public String getIconId(Context context) {
        return ForecastFormattingUtils.iconId(weather.get(0).icon, context);
    }
}
