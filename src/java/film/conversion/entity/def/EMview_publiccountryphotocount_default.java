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
import film.logicview.View_publiccountryphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_publiccountryphotocount_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_publiccountryphotocount_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_publiccountryphotocount.* from view_publiccountryphotocount";
	  
    /**
     * 
     * @return SQL select statement for all View_publiccountryphotocounts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_publiccountryphotocount
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

