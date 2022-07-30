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
import film.logicview.View_countryphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_countryphotocount_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_countryphotocount.* from view_countryphotocount";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_countryphotocount"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_countryphotocount view_countryphotocount = new View_countryphotocount();
        if(dbresult!=null) {
            try {
                view_countryphotocount.setCode(dbresult.getString("code"));
                view_countryphotocount.setName(dbresult.getString("name"));
                view_countryphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_countryphotocount;
    }

}

