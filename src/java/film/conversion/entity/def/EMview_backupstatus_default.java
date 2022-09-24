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
import film.logicview.View_backupstatus;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_backupstatus_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_backupstatus.* from view_backupstatus";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_backupstatus"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_backupstatus view_backupstatus = new View_backupstatus();
        if(dbresult!=null) {
            try {
                view_backupstatus.setId(dbresult.getString("id"));
                view_backupstatus.setPhotocount(dbresult.getLong("photocount"));
                view_backupstatus.setBackupcount(dbresult.getLong("backupcount"));
                view_backupstatus.setImagebackupcount(dbresult.getLong("imagebackupcount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_backupstatus;
    }

}

