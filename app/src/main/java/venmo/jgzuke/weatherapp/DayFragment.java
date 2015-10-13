package venmo.jgzuke.weatherapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.pwittchen.weathericonview.WeatherIconView;

/**
 * A placeholder fragment containing a simple view.
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_day_view, container, false);

        mIcon = (WeatherIconView) mView.findViewById(R.id.condition);

        mCity = (TextView) mView.findViewById(R.id.city);
        mHighLow = (TextView) mView.findViewById(R.id.high_low);
        mDescription = (TextView) mView.findViewById(R.id.description);
        mHumidity = (TextView) mView.findViewById(R.id.humidity);
        fillContent();

        return mView;
    }

    private void fillContent() {
        if(mHumidity != null && mForecast != null) {
            mIcon.setIconResource(mForecast.getIconId(getContext()));
            mCity.setText(mForecast.getWeekday());
            mHighLow.setText(mForecast.getHighLow());
            mDescription.setText(mForecast.getDescription());
            mHumidity.setText(mForecast.getHumidity());
            mView.setBackgroundColor(mColor);
        }
    }

    public void fillFragment(Forecast forecast, int color) {
        mForecast = forecast;
        mColor = color;
        fillContent();
    }
}
