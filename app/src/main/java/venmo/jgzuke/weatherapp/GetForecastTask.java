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
 * AsyncTask to get 5 day daily forecast from api see http://openweathermap.org/forecast16#data
 * Results are stored in Forecast objects and returned to the MainActivity
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
            // eg. http://api.openweathermap.org/data/2.5/forecast/daily?q=Waterloo,Ca&units=metric&cnt=5&APPID=" + API_KEY
            String url = URL_START + mActivity.cityAndCountry() + (mActivity.isMetric()? URL_METRIC : URL_IMPERIAL) + URL_END + API_KEY;
            con = (HttpURLConnection) (new URL(url)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            is = con.getInputStream();

            // Use LoganSquare to parse json, see https://github.com/bluelinelabs/LoganSquare
            Response response = LoganSquare.parse(is, Response.class);

            is.close();
            con.disconnect();

            return response.list;
        } catch(Throwable t) {
            Log.e("WeatherApp", t.toString());
            t.printStackTrace();
        }

        // Close Connection and InputStream if we ran into problems
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
    protected void onPostExecute(ArrayList<Forecast> forecasts) {
        super.onPostExecute(forecasts);
        if(forecasts == null) {
            // If we couldn't complete request for some reason let MainActivity know
            mActivity.forecastTaskFailed();
        } else {
            mActivity.getForecastResults(forecasts);
        }
    }
}
