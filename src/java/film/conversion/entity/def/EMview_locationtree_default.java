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
import film.logicview.View_locationtree;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_locationtree_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_locationtree.* from view_locationtree";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_locationtree"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_locationtree view_locationtree = new View_locationtree();
        if(dbresult!=null) {
            try {
                view_locationtree.setCountrycode(dbresult.getString("countrycode"));
                view_locationtree.setCountryname(dbresult.getString("countryname"));
                view_locationtree.setPostalcode(dbresult.getString("postalcode"));
                view_locationtree.setAl1code(dbresult.getString("al1code"));
                view_locationtree.setAl1name(dbresult.getString("al1name"));
                view_locationtree.setAl2code(dbresult.getString("al2code"));
                view_locationtree.setAl2name(dbresult.getString("al2name"));
                view_locationtree.setAl3code(dbresult.getString("al3code"));
                view_locationtree.setAl3name(dbresult.getString("al3name"));
                view_locationtree.setLocality(dbresult.getString("locality"));
                view_locationtree.setHassublocality(dbresult.getBoolean("hassublocality"));
                view_locationtree.setSublocality(dbresult.getString("sublocality"));
                view_locationtree.setRoutecode(dbresult.getString("routecode"));
                view_locationtree.setRoutename(dbresult.getString("routename"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_locationtree;
    }

}

