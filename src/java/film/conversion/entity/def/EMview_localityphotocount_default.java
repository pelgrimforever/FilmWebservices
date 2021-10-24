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
import film.logicview.View_localityphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_localityphotocount_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_localityphotocount_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_localityphotocount.* from view_localityphotocount";
	  
    /**
     * 
     * @return SQL select statement for all View_localityphotocounts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_localityphotocount
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_localityphotocount view_localityphotocount = new View_localityphotocount();
        if(dbresult!=null) {
            try {
                view_localityphotocount.setCountrycode(dbresult.getString("countrycode"));
                view_localityphotocount.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    view_localityphotocount.setLocation(c_location.abstractclone());
                }
                view_localityphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_localityphotocount;
    }

}

