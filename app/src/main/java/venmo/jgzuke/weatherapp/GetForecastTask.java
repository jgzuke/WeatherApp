package venmo.jgzuke.weatherapp;

import android.os.AsyncTask;

import com.bluelinelabs.logansquare.LoganSquare;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by jgzuke on 15-10-11.
 */
public class GetForecastTask extends AsyncTask<String, Void, ArrayList<Forecast>>
{
    private static final String API_KEY = "7a2cda84bbcc0589ffc9045a39d4a92c";
    private static final String URL_START = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private static final String URL_END = "&APPID=";

    private MainActivity mActivity;

    public GetForecastTask(MainActivity activity) {
        mActivity = activity;
    }

    @Override
    protected ArrayList<Forecast> doInBackground(String... cityAndCountry) {
        HttpURLConnection con = null;
        InputStream is = null;
        String city = cityAndCountry[0];
        String country = cityAndCountry[1];

        try {
            con = (HttpURLConnection) (new URL(URL_START + city + "," + country + URL_END + API_KEY)).openConnection();
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
            t.printStackTrace();
        }
        try {
            if(is != null) is.close();
            if(con != null) con.disconnect();
        } catch (IOException e) {
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
