/*
 * EMuploadsessionsettings.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMuploadsessionsettings_default;
import film.logicentity.Uploadsessionsettings;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMuploadsessionsettings
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMuploadsessionsettings extends EMuploadsessionsettings_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLdeleteall = "delete from uploadsessionsettings";

    /**
     * Map ResultSet Field values to Uploadsessionsettings
     * @param dbresult: Database ResultSet
     * @return Uploadsessionsettings
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Uploadsessionsettings uploadsessionsettings = (Uploadsessionsettings)super.mapResultSet2Entity(dbresult);
        return uploadsessionsettings;
    }    
    
}

