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
import film.logicview.View_backupstatus;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_backupstatus_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_backupstatus_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_backupstatus.* from view_backupstatus";
	  
    /**
     * 
     * @return SQL select statement for all View_backupstatuss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_backupstatus
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

