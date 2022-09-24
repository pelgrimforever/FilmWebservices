/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import film.filmDatabaseproperties;
import film.logicview.View_localityphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_localityphotocount_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_localityphotocount.* from view_localityphotocount";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_localityphotocount"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

