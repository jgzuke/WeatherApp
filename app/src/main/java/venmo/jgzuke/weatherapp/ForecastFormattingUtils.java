package venmo.jgzuke.weatherapp;

import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jgzuke on 15-10-12.
 */
public class ForecastFormattingUtils {
    private static final int[] ICON_IDS = {R.string.wi_day_sunny, R.string.wi_day_cloudy,
            R.string.wi_cloud, R.string.wi_cloudy, R.string.wi_rain, R.string.wi_day_showers,
            R.string.wi_thunderstorm, R.string.wi_snow, R.string.wi_fog};

    public static String dayOfWeek(int dt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE");
        Date date=new Date((long)dt*1000);
        return dateFormat.format(date);
    }

    public static String date(int dt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd");
        Date date=new Date((long)dt*1000);
        return dateFormat.format(date);
    }

    public static String highLow(double max, double min) {
        return Integer.toString((int)max) + "°/" + Integer.toString((int)min) + "°";
    }

    public static String humidity(int humidity) {
        return Integer.toString(humidity) + "% humidity";
    }

    public static String iconId(String icon, Context context) {
        int index = Integer.parseInt(icon.substring(0,2));
        if(index > 4) index -= 4;       // To account for gaps in labeling
        if(index > 8) index -= 37;      // see http://openweathermap.org/weather-conditions "Icon list"
        return context.getString(ICON_IDS[index-1]);
    }
}
