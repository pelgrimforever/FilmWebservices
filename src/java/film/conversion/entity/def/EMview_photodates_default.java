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
import film.logicview.View_photodates;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMview_photodates_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_photodates.* from view_photodates";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_photodates"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photodates view_photodates = new View_photodates();
        if(dbresult!=null) {
            try {
                view_photodates.setPhotodate(dbresult.getDate("photodate"));
                view_photodates.setPhotos(dbresult.getLong("photos"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_photodates;
    }

}

