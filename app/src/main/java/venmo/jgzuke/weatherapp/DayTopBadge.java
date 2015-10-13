package venmo.jgzuke.weatherapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jgzuke on 15-10-11.
 */
public class DayTopBadge extends LinearLayout {
    private TextView mWeekday;
    private ImageView mCondition;
    private TextView mHighLow;
    private TextView mDate;

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

    private void init(Context context) {
        inflate(context, R.layout.view_day_badge, this);
        mWeekday = (TextView)findViewById(R.id.weekday);
        mCondition = (ImageView)findViewById(R.id.condition);
        mHighLow = (TextView)findViewById(R.id.high_low);
        mDate = (TextView)findViewById(R.id.date);
    }

    public void fillBadge(Forecast forecast, int color) {
        mWeekday.setText(forecast.getWeekday());
        mCondition.setImageResource(forecast.getConditionImageID());
        mHighLow.setText(forecast.getHighLow());
        mDate.setText(forecast.getDate());

        setBackgroundColor(color);
    }

    public void selectDay() {
        mDate.setVisibility(View.VISIBLE);
        mCondition.setVisibility(View.GONE);
        mHighLow.setVisibility(View.GONE);
    }

    public void deselectDay() {
        mDate.setVisibility(View.GONE);
        mCondition.setVisibility(View.GONE);
        mHighLow.setVisibility(View.VISIBLE);
    }
}
