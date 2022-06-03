/*
 * EMphotosubjects.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMphotosubjects_default;
import film.logicentity.Photosubjects;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMphotosubjects
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMphotosubjects extends EMphotosubjects_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Photosubjects
     * @param dbresult: Database ResultSet
     * @return Photosubjects
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Photosubjects photosubjects = (Photosubjects)super.mapResultSet2Entity(dbresult);
        return photosubjects;
    }    
    
}

