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
import film.logicview.View_photodatespublic;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_photodatespublic_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_photodatespublic_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_photodatespublic.* from view_photodatespublic";
	  
    /**
     * 
     * @return SQL select statement for all View_photodatespublics
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_photodatespublic
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photodatespublic view_photodatespublic = new View_photodatespublic();
        if(dbresult!=null) {
            try {
                view_photodatespublic.setPhotodate(dbresult.getDate("photodate"));
                view_photodatespublic.setPhotos(dbresult.getLong("photos"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_photodatespublic;
    }

}

