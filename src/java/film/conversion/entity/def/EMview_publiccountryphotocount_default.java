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
import film.logicview.View_publiccountryphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_publiccountryphotocount_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_publiccountryphotocount.* from view_publiccountryphotocount";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_publiccountryphotocount"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publiccountryphotocount view_publiccountryphotocount = new View_publiccountryphotocount();
        if(dbresult!=null) {
            try {
                view_publiccountryphotocount.setCode(dbresult.getString("code"));
                view_publiccountryphotocount.setName(dbresult.getString("name"));
                view_publiccountryphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_publiccountryphotocount;
    }

}

