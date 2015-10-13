package venmo.jgzuke.weatherapp;

/**
 * Created by jgzuke on 15-10-12.
 */
public class ForecastFormattingUtils {
    public static String dayOfWeek(int date) {
        return "testdayofweek";
    }

    public static String date(int date) {
        return "testdate";
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

    private static int kelvinToFahrenheit(double kelvin) {
        return (int)((kelvin - 255.37) * 1.8);
    }
}
