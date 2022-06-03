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
import film.logicview.View_countryphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_countryphotocount_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_countryphotocount_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_countryphotocount.* from view_countryphotocount";
	  
    /**
     * 
     * @return SQL select statement for all View_countryphotocounts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_countryphotocount
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

