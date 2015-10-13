package venmo.jgzuke.weatherapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.pwittchen.weathericonview.WeatherIconView;

/**
 * Fragment that displays detailed weather for a given days Forecast.
 */
public class DayFragment extends Fragment {
    private View mView;
    private WeatherIconView mIcon;
    private TextView mCity;
    private TextView mHighLow;
    private TextView mDescription;
    private TextView mHumidity;

    private int mColor;
    private Forecast mForecast;
    private String mCityName;

    private boolean inflatedOrGotForecast = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_day_view, container, false);

        mIcon = (WeatherIconView) mView.findViewById(R.id.condition);
        mCity = (TextView) mView.findViewById(R.id.city);
        mHighLow = (TextView) mView.findViewById(R.id.high_low);
        mDescription = (TextView) mView.findViewById(R.id.description);
        mHumidity = (TextView) mView.findViewById(R.id.humidity);
        fillContent();
        inflatedOrGotForecast = true;

        return mView;
    }

    /**
     * Populates fields with information from mForecast
     * Because inflating fragments and requesting forecasts are done asynchronously,
     * fillContent is called after each finishes, only running when both have completed
     */
    private void fillContent() {
        if(inflatedOrGotForecast) {
            mIcon.setIconResource(mForecast.getIconId(getContext()));
            mCity.setText(mCityName);
            mHighLow.setText(mForecast.getHighLowLong());
            mDescription.setText(mForecast.getDescription());
            mHumidity.setText(mForecast.getHumidity());
            mView.setBackgroundColor(mColor);
        }
    }

    /**
     * Sets the Forecast object to populate fields in fragment
     * @param forecast Forecast object to pull data from
     * @param color Background color to set fragment
     * @param city Name of city being forecasted
     */
    public void fillFragment(Forecast forecast, int color, String city) {
        mForecast = forecast;
        mColor = color;
        mCityName = city;
        fillContent();
        inflatedOrGotForecast = true;
    }
}
