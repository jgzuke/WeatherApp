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
        return Double.toString(max) + "o/" + Double.toString(min) + "o";
    }

    public static String temp(double temp) {
        return Double.toString(temp) + "o";
    }
}
