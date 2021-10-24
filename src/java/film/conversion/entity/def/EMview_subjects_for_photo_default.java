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
import film.logicview.View_subjects_for_photo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_subjects_for_photo_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_subjects_for_photo_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_subjects_for_photo.* from view_subjects_for_photo";
	  
    /**
     * 
     * @return SQL select statement for all View_subjects_for_photos
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_subjects_for_photo
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

