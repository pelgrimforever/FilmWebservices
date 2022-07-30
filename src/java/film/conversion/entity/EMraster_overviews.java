/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 17:26
 */
package film.conversion.entity;

import data.interfaces.db.*;
import film.conversion.entity.def.EMraster_overviews_default;
import film.logicview.Raster_overviews;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMraster_overviews extends EMraster_overviews_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Raster_overviews raster_overviews = (Raster_overviews)super.mapResultSet2Entity(dbresult);
        return raster_overviews;
    }    
    
}

