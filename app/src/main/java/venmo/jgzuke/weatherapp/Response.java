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
    public ArrayList<ForecastThreeHour> list;

    public ArrayList<Forecast> getResults() {
        ArrayList<Forecast> forecasts = new ArrayList<>();
        int forecastsTotal = list.size();
        forecasts.add(new Forecast(list, 0, forecastsTotal-32));
        forecasts.add(new Forecast(list, forecastsTotal-32, forecastsTotal-24));
        forecasts.add(new Forecast(list, forecastsTotal-24, forecastsTotal-16));
        forecasts.add(new Forecast(list, forecastsTotal-16, forecastsTotal-8));
        forecasts.add(new Forecast(list, forecastsTotal-8, forecastsTotal));
        return forecasts;
    }
}
