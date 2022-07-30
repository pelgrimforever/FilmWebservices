/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.View;
import film.conversion.entity.def.EMview_photodates_default;
import film.logicview.View_photodates;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_photodates extends EMview_photodates_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photodates view_photodates = (View_photodates)super.mapResultSet2Entity(dbresult);
        return view_photodates;
    }    
    
}

