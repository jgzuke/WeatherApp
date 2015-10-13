package venmo.jgzuke.weatherapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int[] DAY_TOP_BADGE_IDS = {R.id.day_1, R.id.day_2, R.id.day_3, R.id.day_4, R.id.day_5};
    private int[] BACKGROUND_COLORS;
    private static final int NUMBER_FORECASTS = 5;

    private ArrayList<DayTopBadge> mForecastBadges = new ArrayList<>();
    private ArrayList<DayFragment> mForecastFragments = new ArrayList<>();

    private boolean isMetric = false;
    private String city = "Waterloo";
    private String country = "Ca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BACKGROUND_COLORS = getResources().getIntArray(R.array.day_background_colors);
    }

    /**
     * Call task on resume because we probably want to get new information
     * Also create fragments and get badges, usually the task finishes after fragments are made
     * so its not a big deal to remake every time and it means we dot worry about losing states
     */
    @Override
    protected void onResume() {
        super.onResume();
        new GetForecastTask(this).execute();

        mForecastBadges = new ArrayList<>();
        mForecastFragments = new ArrayList<>();
        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            mForecastFragments.add(new DayFragment());
            mForecastBadges.add((DayTopBadge) findViewById(DAY_TOP_BADGE_IDS[i]));
            mForecastBadges.get(i).setOnClickListener(this);
        }
    }

    /**
     * Called when we get back results from forecast task
     * @param forecasts Forecasts returned
     */
    public void getForecastResults(ArrayList<Forecast> forecasts) {
        findViewById(R.id.day_badge_container).setVisibility(View.VISIBLE);
        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            // Fill fragments and badges with data from Forecasts
            mForecastBadges.get(i).fillBadge(forecasts.get(i), BACKGROUND_COLORS[i]);
            mForecastFragments.get(i).fillFragment(forecasts.get(i), BACKGROUND_COLORS[i], city);
        }
        // Show the first fragment (Current day)
        showFragment(0);
    }

    /**
     * Shows a fragment
     * @param index fragment to show (0 is current day, 1 is next day etc)
     */
    private void showFragment(int index) {
        for(DayTopBadge badge: mForecastBadges) {
            badge.deselectDay();
        }
        mForecastBadges.get(index).selectDay();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, mForecastFragments.get(index));
        transaction.commit();
    }

    /**
     * Called when forecast failed
     */
    public void forecastTaskFailed() {
        Toast.makeText(this, getString(R.string.forecast_failed), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        // Show the fragment for whichever badge was clicked
        switch(view.getId()) {
            case R.id.day_1: showFragment(0);
                return;
            case R.id.day_2: showFragment(1);
                return;
            case R.id.day_3: showFragment(2);
                return;
            case R.id.day_4: showFragment(3);
                return;
            case R.id.day_5: showFragment(4);
        }
    }

    public boolean isMetric() {
        return isMetric;
    }

    /**
     * Returns city,country for api call
     * @return eg. Waterloo,ca
     */
    public String cityAndCountry() {
        return city + "," + country;
    }
}
