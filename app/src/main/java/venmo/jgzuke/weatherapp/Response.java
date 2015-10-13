package venmo.jgzuke.weatherapp;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.ArrayList;

/**
 * Model for full json response, see https://github.com/bluelinelabs/LoganSquare
 */
@JsonObject
public class Response {
    @JsonField
    public ArrayList<Forecast> list;
}
