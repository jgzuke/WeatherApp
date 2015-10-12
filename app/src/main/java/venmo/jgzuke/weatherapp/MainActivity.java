package venmo.jgzuke.weatherapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mDayBadgeContainer;
    private Fragment mFragmentContainer;
    private ArrayList<ForecastInfo> mForecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDayBadgeContainer = (LinearLayout) findViewById(R.id.day_badge_container);

        new GetForecastTask(this).execute("beamsville", "ca");
    }

    public void getForecastResults(ArrayList<ForecastInfo> forecastResults) {
        mForecasts = forecastResults;
        for(ForecastInfo forecast: mForecasts) {
            mDayBadgeContainer.addView(DayBadgeView.createBadge(this, forecast));
        }
    }
}
