/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.View;
import film.conversion.entity.def.EMview_publiclocalityphotocount_default;
import film.logicview.View_publiclocalityphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_publiclocalityphotocount extends EMview_publiclocalityphotocount_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLwherecountrycode = " view_publiclocalityphotocount.countrycode = :countrycode: ";
    public static final String SQLSelect4countrycode = "select view_publiclocalityphotocount.* from view_publiclocalityphotocount where " + SQLwherecountrycode;

    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publiclocalityphotocount view_publiclocalityphotocount = (View_publiclocalityphotocount)super.mapResultSet2Entity(dbresult);
        return view_publiclocalityphotocount;
    }    
    
}

