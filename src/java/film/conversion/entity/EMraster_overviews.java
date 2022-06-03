/*
 * EMraster_overviews.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMraster_overviews_default;
import film.logicview.Raster_overviews;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMraster_overviews
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMraster_overviews extends EMraster_overviews_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Raster_overviews
     * @param dbresult: Database ResultSet
     */
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Raster_overviews raster_overviews = (Raster_overviews)super.mapResultSet2Entity(dbresult);
        return raster_overviews;
    }    
    
}

