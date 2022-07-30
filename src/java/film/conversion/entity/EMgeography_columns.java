/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 17:35
 */
package film.conversion.entity;

import data.interfaces.db.*;
import film.conversion.entity.def.EMgeography_columns_default;
import film.logicview.Geography_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMgeography_columns extends EMgeography_columns_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geography_columns geography_columns = (Geography_columns)super.mapResultSet2Entity(dbresult);
        return geography_columns;
    }    
    
}

