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
    private TextView weekday;
    private ImageView condition;
    private TextView highLow;
    private TextView date;

    public static DayFragment createBadge(Context context, Forecast forecast) {
        DayFragment dayFragment = new DayFragment();
        dayFragment.fillFragment(forecast);
        return dayFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_day_view, container, false);

        weekday = (TextView) view.findViewById(R.id.weekday);
        condition = (ImageView) view.findViewById(R.id.condition);
        highLow = (TextView) view.findViewById(R.id.high_low);
        date = (TextView) view.findViewById(R.id.date);

        return view;
    }

    public void fillFragment(Forecast forecast) {
        weekday.setText(forecast.getWeekday());
        condition.setImageResource(forecast.getConditionImageID());
        highLow.setText(forecast.getHighLow());
        date.setText(forecast.getDate());
    }
}
