package venmo.jgzuke.weatherapp;

import android.os.AsyncTask;
import android.util.Log;

import com.bluelinelabs.logansquare.LoganSquare;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            return response.getForecasts();
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

    private ArrayList<ForecastInfo> getForecastsFromString(String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray weatherList = jsonObject.getJSONArray("list");

            ArrayList<ForecastInfo> forecastInfo = new ArrayList<>();
            Log.e("myid", weatherList.toString());
            for(int i = 0; i < weatherList.length(); i++) {
                makeForecast(weatherList.getJSONObject(i));
                forecastInfo.add(null);//makeForecast(weatherList.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Forecast makeForecast(JSONObject weather) {
        String jsonString = weather.toString();

        try {
            Forecast forecast = LoganSquare.parse(jsonString, Forecast.class);
            return forecast;
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
            mActivity.getForecastTaskFailed();
        } else {
            mActivity.getForecastResults(forecasts);
        }
    }
}
