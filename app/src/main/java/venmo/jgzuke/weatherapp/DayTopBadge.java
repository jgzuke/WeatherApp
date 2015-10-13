package venmo.jgzuke.weatherapp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.pwittchen.weathericonview.WeatherIconView;

/**
 * Mini forecast badge on the top of the screen for a given days Forecast
 */
public class DayTopBadge extends LinearLayout {
    private TextView mWeekday;
    private WeatherIconView mIcon;
    private TextView mHighLow;
    private TextView mDate;

    /**
     * Default Constructors, plus inflating our custom view
     */
    public DayTopBadge(Context context) {
        super(context);
        init(context);
    }
    public DayTopBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    public DayTopBadge(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    /**
     * Inflates custom badge view view_day_badge when the view is created
     * @param context
     */
    private void init(Context context) {
        inflate(context, R.layout.view_day_badge, this);
        mWeekday = (TextView)findViewById(R.id.weekday);
        mIcon = (WeatherIconView)findViewById(R.id.condition);
        mHighLow = (TextView)findViewById(R.id.high_low);
        mDate = (TextView)findViewById(R.id.date);
    }

    /**
     * Populates fields with information from forecast
     * @param forecast Forecast object to pull data from
     * @param color Background color to set view
     */
    public void fillBadge(Forecast forecast, int color) {
        mWeekday.setText(forecast.getWeekday());
        mIcon.setIconResource(forecast.getIconId(getContext()));
        mHighLow.setText(forecast.getHighLow());
        mDate.setText(forecast.getDate());

        setBackgroundColor(color);
    }

    /**
     * Sets badge to selected state (Associated Fragment open)
     * Hide icon/temp and show date
     */
    public void selectDay() {
        mDate.setVisibility(View.VISIBLE);
        mIcon.setVisibility(View.GONE);
        mHighLow.setVisibility(View.GONE);
        mWeekday.setTypeface(null, Typeface.BOLD);
    }

    /**
     * Sets badge to selected state (Associated Fragment open)
     * Show icon/temp and hide date
     */
    public void deselectDay() {
        mDate.setVisibility(View.GONE);
        mIcon.setVisibility(View.VISIBLE);
        mHighLow.setVisibility(View.VISIBLE);
        mWeekday.setTypeface(null, Typeface.NORMAL);
    }
}
