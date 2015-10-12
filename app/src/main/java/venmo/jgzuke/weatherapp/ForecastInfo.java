package venmo.jgzuke.weatherapp;

/**
 * Created by jgzuke on 15-10-11.
 */
public class ForecastInfo {
    private String dayOfWeek;
    private String date;
    private String condition;

    public ForecastInfo(String dayOfWeekSet, String dateSet, String conditionSet) {
        dayOfWeek = dayOfWeekSet;
        date = dateSet;
        condition = conditionSet;
    }

    public String getWeekday() {
        return "test";
    }

    public int getCondition() {
        return 0;
    }

    public String getHighLow() {
        return "test2";
    }

    public String getDate() {
        return "test3";
    }
}
