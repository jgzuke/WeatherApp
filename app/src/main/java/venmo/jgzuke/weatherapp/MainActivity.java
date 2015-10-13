package venmo.jgzuke.weatherapp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LinearLayout mDayBadgeContainer;
    private Fragment mFragmentContainer;
    private ArrayList<Forecast> mForecasts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDayBadgeContainer = (LinearLayout) findViewById(R.id.day_badge_container);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new GetForecastTask(this).execute("beamsville", "ca");
    }

    public void getForecastResults(ArrayList<Forecast> forecastResults) {
        mForecasts = forecastResults;
        for(Forecast forecast: mForecasts) {
            mDayBadgeContainer.addView(DayBadgeView.createBadge(this, forecast));
        }
    }

    public void getForecastTaskFailed() {
        //new GetForecastTask(this).execute("beamsville", "ca");
    }
}
