/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import data.interfaces.db.View;
import film.conversion.entity.def.EMview_localityphotocount_default;
import film.logicview.View_localityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_localityphotocount extends EMview_localityphotocount_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLwherecountrycode = " view_localityphotocount.countrycode = :countrycode: ";
    public static final String SQLSelect4countrycode = "select view_localityphotocount.* from view_localityphotocount where " + SQLwherecountrycode;

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_localityphotocount view_localityphotocount = (View_localityphotocount)super.mapResultSet2Entity(dbresult);
        return view_localityphotocount;
    }    
    
}

