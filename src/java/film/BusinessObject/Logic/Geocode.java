/**
 * @author Franky Laseure
 */
package film.BusinessObject.Logic;

import request.HTTPrequest;
import text.Conversion;

public class Geocode {

    private static final String urlreversegeocode = "http://maps.googleapis.com/maps/api/geocode/json?latlng=:lat:,:lng:&sensor=false";

    public String reversegeocode(double lat, double lng) {        
        String url = urlreversegeocode;
        url = Conversion.replaceAll(url, ":lat:", String.valueOf(lat));
        url = Conversion.replaceAll(url, ":lng:", String.valueOf(lng));
        HTTPrequest httprequest = new HTTPrequest();
        return httprequest.request(url);
    }
    
}
