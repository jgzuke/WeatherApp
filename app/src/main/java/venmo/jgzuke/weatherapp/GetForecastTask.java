package venmo.jgzuke.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jgzuke on 15-10-11.
 */
public class GetForecastTask extends AsyncTask<Void, Void, ArrayList<Forecast>>
{
    private static final String API_KEY = "7a2cda84bbcc0589ffc9045a39d4a92c";
    private static final String URL_START = "http://api.openweathermap.org/data/2.5/forecast/daily?q=";
    private static final String URL_METRIC = "&units=metric";
    private static final String URL_IMPERIAL = "&units=imperial";
    private static final String URL_END = "&cnt=5&APPID=";

    private MainActivity mActivity;

    public GetForecastTask(MainActivity activity) {
        mActivity = activity;
    }

    @Override
    protected ArrayList<Forecast> doInBackground(Void... params) {
        HttpURLConnection con = null;
        InputStream is = null;

        try {
            String url = URL_START + mActivity.cityAndCountry() + (mActivity.isMetric()? URL_METRIC : URL_IMPERIAL) + URL_END + API_KEY;
            con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            is = con.getInputStream();
            Response response = LoganSquare.parse(is, Response.class);

            is.close();
            con.disconnect();

            return response.list;
        } catch(Throwable t) {
            Log.e("WeatherApp", t.toString());
            t.printStackTrace();
        }
        try {
            if(is != null) is.close();
            if(con != null) con.disconnect();
        } catch (IOException e) {
            Log.e("WeatherApp", e.toString());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Forecast> forecasts)
    {
        super.onPostExecute(forecasts);
        if(forecasts == null) {
            mActivity.forecastTaskFailed();
        } else {
            mActivity.getForecastResults(forecasts);
        }
    }
}
