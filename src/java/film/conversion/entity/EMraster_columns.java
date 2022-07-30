/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 17:26
 */
package film.conversion.entity;

import data.interfaces.db.*;
import film.conversion.entity.def.EMraster_columns_default;
import film.logicview.Raster_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMraster_columns extends EMraster_columns_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Raster_columns raster_columns = (Raster_columns)super.mapResultSet2Entity(dbresult);
        return raster_columns;
    }    
    
}

