/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.View;
import film.conversion.entity.def.EMview_subjects_for_film_default;
import film.logicview.View_subjects_for_film;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_subjects_for_film extends EMview_subjects_for_film_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_subjects_for_film view_subjects_for_film = (View_subjects_for_film)super.mapResultSet2Entity(dbresult);
        return view_subjects_for_film;
    }    
    
}

