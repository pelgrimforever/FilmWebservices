/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 16:45
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.*;
import data.json.piJson;
import db.ViewMapper;
import film.filmDatabaseproperties;
import film.logicview.View_locality_photolocations;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_locality_photolocations_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_locality_photolocations.* from view_locality_photolocations";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_locality_photolocations"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_locality_photolocations view_locality_photolocations = new View_locality_photolocations();
        if(dbresult!=null) {
            try {
                view_locality_photolocations.setCountrycode(dbresult.getString("countrycode"));
                view_locality_photolocations.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    view_locality_photolocations.setLocation(c_location.abstractclone());
                }
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_locality_photolocations;
    }

}

