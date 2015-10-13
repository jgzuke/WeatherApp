package venmo.jgzuke.weatherapp;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class to separate String formatting and Icon getting from Forecast model
 */
public class ForecastFormattingUtils {
    private static final int[] ICON_IDS = {R.string.wi_day_sunny, R.string.wi_day_cloudy,
            R.string.wi_cloud, R.string.wi_cloudy, R.string.wi_rain, R.string.wi_day_showers,
            R.string.wi_thunderstorm, R.string.wi_snow, R.string.wi_fog};

    /**
     * Returns short day of week
     * @param dt unix timestamp
     * @return eg. Mon
     */
    public static String dayOfWeek(int dt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE");
        Date date=new Date((long)dt*1000);
        return dateFormat.format(date);
    }

    /**
     * Returns date
     * @param dt unix timestamp
     * @return eg. Oct 13
     */
    public static String date(int dt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
        Date date=new Date((long)dt*1000);
        return dateFormat.format(date);
    }

    /**
     * Returns Temp high/low
     * @param max max temp in Celsius of Fahrenheit
     * @param min min temp in Celsius of Fahrenheit
     * @return eg. 57°/43°
     */
    public static String highLow(double max, double min) {
        return Integer.toString((int)max) + "°/" + Integer.toString((int)min) + "°";
    }

    /**
     * Returns Temp high/low
     * @param max max temp in Celsius of Fahrenheit
     * @param min min temp in Celsius of Fahrenheit
     * @return eg. High 57°/Low 43°
     */
    public static String highLowLong(double max, double min) {
        return "High " + Integer.toString((int)max) + "°/Low " + Integer.toString((int)min) + "°";
    }

    /**
     * Returns humidity percent
     * @param humidity Integer percent of humidity
     * @return eg. 86% humidity
     */
    public static String humidity(int humidity) {
        return "Humidity: " + Integer.toString(humidity) + "%";
    }

    /**
     * Returns short description of weather
     * @param weather short description of weather
     * @return eg. Light rain
     */
    public static String weather(String weather) {
        return weather.substring(0, 1).toUpperCase() + weather.substring(1);
    }

    /**
     * Returns weather icon ID
     * @param icon Icon name, see http://openweathermap.org/weather-conditions Icon list
     * @param context used to get string from resources
     * @return String used as ID to get weather icon see http://erikflowers.github.io/weather-icons/
     */
    public static String iconId(String icon, Context context) {
        int index = Integer.parseInt(icon.substring(0,2));
        if(index > 4) index -= 4;       // To account for gaps in labeling
        if(index > 8) index -= 37;      // see http://openweathermap.org/weather-conditions "Icon list"
        return context.getString(ICON_IDS[index-1]);
    }
}
