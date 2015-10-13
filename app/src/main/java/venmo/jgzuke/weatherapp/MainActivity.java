package venmo.jgzuke.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int[] DAY_TOP_BADGE_IDS = {R.id.day_1, R.id.day_2, R.id.day_3, R.id.day_4, R.id.day_5};
    private int[] BACKGROUND_COLORS = {R.id.day_1, R.id.day_2, R.id.day_3, R.id.day_4, R.id.day_5};
    private static final int NUMBER_FORECASTS = 5;

    private ArrayList<DayTopBadge> mForecastBadges = new ArrayList<>();
    private ArrayList<DayFragment> mForecastFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BACKGROUND_COLORS = getResources().getIntArray(R.array.day_background_colors);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new GetForecastTask(this).execute("beamsville", "ca");

        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            mForecastFragments.add(new DayFragment());
            mForecastBadges.add((DayTopBadge) findViewById(DAY_TOP_BADGE_IDS[i]));
            mForecastBadges.get(i).setOnClickListener(this);
        }
    }

    public void getForecastResults(ArrayList<Forecast> forecasts) {
        findViewById(R.id.day_badge_container).setVisibility(View.VISIBLE);
        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            mForecastBadges.get(i).fillBadge(forecasts.get(i), BACKGROUND_COLORS[i]);
            mForecastFragments.get(i).fillFragment(forecasts.get(i), BACKGROUND_COLORS[i]);
        }
        showFragment(0);
    }

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

    public void forecastTaskFailed() {
        Toast.makeText(this, "Forecast failed, please try again later", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
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
                return;
        }
    }

    public boolean isMetric() {
        return true;
    }
}
