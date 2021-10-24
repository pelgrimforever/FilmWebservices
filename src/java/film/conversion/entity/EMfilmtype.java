/*
 * EMfilmtype.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMfilmtype_default;
import film.logicentity.Filmtype;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMfilmtype
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMfilmtype extends EMfilmtype_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Filmtype
     * @param dbresult: Database ResultSet
     * @return Filmtype
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Filmtype filmtype = (Filmtype)super.mapResultSet2Entity(dbresult);
        return filmtype;
    }    
    
}

