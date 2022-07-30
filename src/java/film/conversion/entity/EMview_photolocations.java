/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.View;
import film.conversion.entity.def.EMview_photolocations_default;
import film.logicview.View_photolocations;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_photolocations extends EMview_photolocations_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLWherelocality = "countrycode = :countrycode: and locality = :locality:";
    public static final String SQLSelect4locality = SQLSelectAll + " where " + SQLWherelocality;

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photolocations view_photolocations = (View_photolocations)super.mapResultSet2Entity(dbresult);
        return view_photolocations;
    }    
    
}

