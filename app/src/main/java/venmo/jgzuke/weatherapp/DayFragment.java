package venmo.jgzuke.weatherapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DayFragment extends Fragment {
    private View mView;
    private TextView mWeekday;
    private ImageView mCondition;
    private TextView mHighLow;
    private TextView mDate;

    private int mColor;
    private Forecast mForecast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_day_view, container, false);

        mWeekday = (TextView) mView.findViewById(R.id.weekday);
        mCondition = (ImageView) mView.findViewById(R.id.condition);
        mHighLow = (TextView) mView.findViewById(R.id.high_low);
        mDate = (TextView) mView.findViewById(R.id.date);
        fillContent();

        return mView;
    }

    private void fillContent() {
        if(mDate != null && mForecast != null) {
            mWeekday.setText(mForecast.getWeekday());
            mCondition.setImageResource(mForecast.getConditionImageID());
            mHighLow.setText(mForecast.getHighLow());
            mDate.setText(mForecast.getDate());

            mView.setBackgroundColor(mColor);
        }
    }

    public void fillFragment(Forecast forecast, int color) {
        mForecast = forecast;
        mColor = color;
        fillContent();
    }
}
