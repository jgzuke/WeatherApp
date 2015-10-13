package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jgzuke on 15-10-12.
 */
@JsonObject
public class Forecast {
    private String mDay;
    private String mDate;
    private int mConditionImageId;
    private String mCondition;
    private String mTemp;
    private String mHighLow;

    public Forecast(ArrayList<ForecastThreeHour> forecastThreeHours, int startIndex, int endIndex) {
        mDay = ForecastFormattingUtils.dayOfWeek(forecastThreeHours.get(startIndex).dt);
        mDate = ForecastFormattingUtils.date(forecastThreeHours.get(startIndex).dt);

    }

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
