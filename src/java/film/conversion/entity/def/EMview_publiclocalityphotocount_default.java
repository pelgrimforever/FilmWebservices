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
import film.logicview.View_publiclocalityphotocount;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_publiclocalityphotocount_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_publiclocalityphotocount_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_publiclocalityphotocount.* from view_publiclocalityphotocount";
	  
    /**
     * 
     * @return SQL select statement for all View_publiclocalityphotocounts
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_publiclocalityphotocount
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publiclocalityphotocount view_publiclocalityphotocount = new View_publiclocalityphotocount();
        if(dbresult!=null) {
            try {
                view_publiclocalityphotocount.setCountrycode(dbresult.getString("countrycode"));
                view_publiclocalityphotocount.setLocality(dbresult.getString("locality"));
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((org.postgis.PGgeometry)o_location);
                    view_publiclocalityphotocount.setLocation(c_location.abstractclone());
                }
                view_publiclocalityphotocount.setPhotocount(dbresult.getLong("photocount"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_publiclocalityphotocount;
    }

}

