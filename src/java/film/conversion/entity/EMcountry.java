/*
 * EMcountry.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMcountry_default;
import film.logicentity.Country;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMcountry
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMcountry extends EMcountry_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by name";
    public static final String SQLSelectAll = "select country.* from country" + OrderBy;

    /**
     * Map ResultSet Field values to Country
     * @param dbresult: Database ResultSet
     * @return Country
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Country country = (Country)super.mapResultSet2Entity(dbresult);
        return country;
    }    
    
}

