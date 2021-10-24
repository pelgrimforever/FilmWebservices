/*
 * EMgeometry_columns.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMgeometry_columns_default;
import film.logicview.Geometry_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMgeometry_columns
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMgeometry_columns extends EMgeometry_columns_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Geometry_columns
     * @param dbresult: Database ResultSet
     */
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geometry_columns geometry_columns = (Geometry_columns)super.mapResultSet2Entity(dbresult);
        return geometry_columns;
    }    
    
}

