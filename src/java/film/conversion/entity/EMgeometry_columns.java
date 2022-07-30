/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 17:35
 */
package film.conversion.entity;

import data.interfaces.db.*;
import film.conversion.entity.def.EMgeometry_columns_default;
import film.logicview.Geometry_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMgeometry_columns extends EMgeometry_columns_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geometry_columns geometry_columns = (Geometry_columns)super.mapResultSet2Entity(dbresult);
        return geometry_columns;
    }    
    
}

