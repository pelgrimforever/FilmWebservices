/*
 * EMpostalcode.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMpostalcode_default;
import film.logicentity.Postalcode;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMpostalcode
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMpostalcode extends EMpostalcode_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by countrycode, postalcode";
    
    /**
     * Map ResultSet Field values to Postalcode
     * @param dbresult: Database ResultSet
     * @return Postalcode
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Postalcode postalcode = (Postalcode)super.mapResultSet2Entity(dbresult);
        return postalcode;
    }    
    
}

