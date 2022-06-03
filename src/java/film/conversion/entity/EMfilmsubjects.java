/*
 * EMfilmsubjects.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMfilmsubjects_default;
import film.logicentity.Filmsubjects;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfilmsubjects
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfilmsubjects extends EMfilmsubjects_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Filmsubjects
     * @param dbresult: Database ResultSet
     * @return Filmsubjects
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Filmsubjects filmsubjects = (Filmsubjects)super.mapResultSet2Entity(dbresult);
        return filmsubjects;
    }    
    
}

