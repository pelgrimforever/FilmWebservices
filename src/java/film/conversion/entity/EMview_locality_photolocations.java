/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import data.interfaces.db.View;
import film.conversion.entity.def.EMview_locality_photolocations_default;
import film.logicview.View_locality_photolocations;
import static film.view.eView_locality_photolocations.table;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_locality_photolocations extends EMview_locality_photolocations_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLSelect4location = "select * from " + table + " where countrycode = :countrycode: and locality = :locality:";

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_locality_photolocations view_locality_photolocations = (View_locality_photolocations)super.mapResultSet2Entity(dbresult);
        return view_locality_photolocations;
    }    
    
}

