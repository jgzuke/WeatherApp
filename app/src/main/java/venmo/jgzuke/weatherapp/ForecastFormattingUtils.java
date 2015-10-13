package venmo.jgzuke.weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jgzuke on 15-10-12.
 */
public class ForecastFormattingUtils {
    private static final String[] ICON_IDS = {"wi_day_sunny", "wi_day_cloudy", "wi_cloud",
            "wi_cloudy", "wi_rain", "wi_day_rain_mix", "wi_thunderstorm", "wi_snow", "wi-fog"};

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

    public static int condition(int id) {
        return 0;
    }

    public static String highLow(double max, double min) {
        return Integer.toString((int)max) + "°/" + Integer.toString((int)min) + "°";
    }

    public static String temp(double temp) {
        return Integer.toString((int)temp) + "°";
    }

    public static String humidity(int humidity) {
        return Integer.toString(humidity) + "%";
    }

    public static String iconId(String icon) {
        int index = Integer.parseInt(icon.substring(0,2));
        if(index > 4) index -= 4;       // To account for gaps in labeling
        if(index > 8) index -= 37;      // see http://openweathermap.org/weather-conditions "Icon list"
        return ICON_IDS[index-1];
    }
}
