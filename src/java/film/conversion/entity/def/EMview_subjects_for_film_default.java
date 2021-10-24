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
import film.logicview.View_subjects_for_film;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMview_subjects_for_film_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMview_subjects_for_film_default implements ViewMapper {
    
    public static final String SQLSelectAll = "select view_subjects_for_film.* from view_subjects_for_film";
	  
    /**
     * 
     * @return SQL select statement for all View_subjects_for_films
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to View_subjects_for_film
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_subjects_for_film view_subjects_for_film = new View_subjects_for_film();
        if(dbresult!=null) {
            try {
                view_subjects_for_film.setFilm(dbresult.getString("film"));
                view_subjects_for_film.setCat1(dbresult.getString("cat1"));
                view_subjects_for_film.setCat2(dbresult.getString("cat2"));
                view_subjects_for_film.setId(dbresult.getInt("id"));
                view_subjects_for_film.setSubject(dbresult.getString("subject"));
                view_subjects_for_film.setDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return view_subjects_for_film;
    }

}

