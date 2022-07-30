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
import film.logicview.View_subjects_for_photo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMview_subjects_for_photo_default implements filmDatabaseproperties, ViewMapper {
    
    public static final String SQLSelectAll = "select view_subjects_for_photo.* from view_subjects_for_photo";
	  
    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "view_subjects_for_photo"; }

    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_subjects_for_photo view_subjects_for_photo = new View_subjects_for_photo();
        if(dbresult!=null) {
            try {
                view_subjects_for_photo.setFilm(dbresult.getString("film"));
                view_subjects_for_photo.setPhotoid(dbresult.getInt("photoid"));
                view_subjects_for_photo.setCat1(dbresult.getString("cat1"));
                view_subjects_for_photo.setCat2(dbresult.getString("cat2"));
                view_subjects_for_photo.setId(dbresult.getInt("id"));
                view_subjects_for_photo.setSubject(dbresult.getString("subject"));
                view_subjects_for_photo.setDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_subjects_for_photo;
    }

}

