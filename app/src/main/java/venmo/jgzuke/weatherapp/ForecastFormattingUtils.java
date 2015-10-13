package venmo.jgzuke.weatherapp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jgzuke on 15-10-12.
 */
public class ForecastFormattingUtils {
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
        return Integer.toString(kelvinToFahrenheit(max)) + "°/" + Integer.toString(kelvinToFahrenheit(min)) + "°";
    }

    public static String temp(double temp) {
        return Integer.toString(kelvinToFahrenheit(temp)) + "°";
    }

    public static String humidity(int humidity) {
        return Integer.toString(humidity) + "%";
    }

    private static int kelvinToFahrenheit(double kelvin) {
        return (int)((kelvin - 255.37) * 1.8);
    }
}
