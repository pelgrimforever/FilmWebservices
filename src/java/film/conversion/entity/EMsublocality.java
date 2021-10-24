/*
 * EMsublocality.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMsublocality_default;
import film.logicentity.Sublocality;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsublocality
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsublocality extends EMsublocality_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by sublocality.countrycode, sublocality.postalcode, sublocality.locality, sublocality.sublocality";
    
    /**
     * Map ResultSet Field values to Sublocality
     * @param dbresult: Database ResultSet
     * @return Sublocality
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Sublocality sublocality = (Sublocality)super.mapResultSet2Entity(dbresult);
        return sublocality;
    }    
    
}

