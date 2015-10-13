package venmo.jgzuke.weatherapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jgzuke on 15-10-11.
 */
public class DayTopBadge extends LinearLayout {
    private TextView weekday;
    private ImageView condition;
    private TextView highLow;
    private TextView date;

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
        weekday = (TextView)findViewById(R.id.weekday);
        condition = (ImageView)findViewById(R.id.condition);
        highLow = (TextView)findViewById(R.id.high_low);
        date = (TextView)findViewById(R.id.date);
    }

    public void fillBadge(Forecast forecast) {
        weekday.setText(forecast.getWeekday());
        condition.setImageResource(forecast.getConditionImageID());
        highLow.setText(forecast.getHighLow());
        date.setText(forecast.getDate());
    }
}
