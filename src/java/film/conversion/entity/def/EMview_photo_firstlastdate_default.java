/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 1.5.2022 20:24
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.View;
import data.json.piJson;
import db.ViewMapper;
import film.logicview.View_photo_firstlastdate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_photo_firstlastdate_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_photo_firstlastdate_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_photo_firstlastdate.* from view_photo_firstlastdate";
	  
    /**
     * 
     * @return SQL select statement for all View_photo_firstlastdates
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_photo_firstlastdate
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

