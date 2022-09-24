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
import film.logicview.View_photo_firstlastdate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_photo_firstlastdate_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_photo_firstlastdate.* from view_photo_firstlastdate";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_photo_firstlastdate"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photo_firstlastdate view_photo_firstlastdate = new View_photo_firstlastdate();
        if(dbresult!=null) {
            try {
                view_photo_firstlastdate.setMinphotodate(dbresult.getDate("minphotodate"));
                view_photo_firstlastdate.setMaxphotodate(dbresult.getDate("maxphotodate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_photo_firstlastdate;
    }

}

