/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.9.2021 14:50
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import film.logicview.View_publicphotolocations;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_publicphotolocations_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_publicphotolocations_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_publicphotolocations.* from view_publicphotolocations";
	  
    /**
     * 
     * @return SQL select statement for all View_publicphotolocationss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_publicphotolocations
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publicphotolocations view_publicphotolocations = new View_publicphotolocations();
        if(dbresult!=null) {
            try {
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    view_publicphotolocations.setLocation(c_location.abstractclone());
                }
                view_publicphotolocations.setExactlocation(dbresult.getBoolean("exactlocation"));
                view_publicphotolocations.setLocationradius(dbresult.getDouble("locationradius"));
                view_publicphotolocations.setCountrycode(dbresult.getString("countrycode"));
                view_publicphotolocations.setPostalcode(dbresult.getString("postalcode"));
                view_publicphotolocations.setLocality(dbresult.getString("locality"));
                view_publicphotolocations.setSublocality(dbresult.getString("sublocality"));
                view_publicphotolocations.setRoutecode(dbresult.getString("routecode"));
                view_publicphotolocations.setStreetnumber(dbresult.getString("streetnumber"));
                view_publicphotolocations.setLocationcount(dbresult.getLong("locationcount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_publicphotolocations;
    }

}

