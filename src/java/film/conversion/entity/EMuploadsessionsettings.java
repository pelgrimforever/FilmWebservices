/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import film.conversion.entity.def.EMuploadsessionsettings_default;
import film.logicentity.Uploadsessionsettings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMuploadsessionsettings extends EMuploadsessionsettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLdeleteall = "delete from uploadsessionsettings";

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Uploadsessionsettings uploadsessionsettings = (Uploadsessionsettings)super.mapResultSet2Entity(dbresult);
        return uploadsessionsettings;
    }    
    
}

