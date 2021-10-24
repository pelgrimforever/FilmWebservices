/*
 * EMraster_columns.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMraster_columns_default;
import film.logicview.Raster_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMraster_columns
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMraster_columns extends EMraster_columns_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Raster_columns
     * @param dbresult: Database ResultSet
     */
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Raster_columns raster_columns = (Raster_columns)super.mapResultSet2Entity(dbresult);
        return raster_columns;
    }    
    
}

