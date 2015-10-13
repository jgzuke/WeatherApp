package venmo.jgzuke.weatherapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final int[] DAY_TOP_BADGE_IDS = {R.id.day_1, R.id.day_2, R.id.day_3, R.id.day_4, R.id.day_5};
    private static final int NUMBER_FORECASTS = 5;

    private ArrayList<DayTopBadge> mForecastBadges = new ArrayList<>();
    private ArrayList<DayFragment> mForecastFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new GetForecastTask(this).execute("beamsville", "ca");

        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            mForecastFragments.add(new DayFragment());
            mForecastBadges.add((DayTopBadge) findViewById(DAY_TOP_BADGE_IDS[i]));
        }
    }

    public void getForecastResults(ArrayList<Forecast> forecasts) {
        for(int i = 0; i < NUMBER_FORECASTS; i++) {
            mForecastBadges.get(i).fillBadge(forecasts.get(i));
            mForecastFragments.get(i).fillFragment(forecasts.get(i));
        }
        showFragment(mForecastFragments.get(0));
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    public void forecastTaskFailed() {
        Toast.makeText(this, "Forecast failed, please try again later", Toast.LENGTH_LONG).show();
    }
}
