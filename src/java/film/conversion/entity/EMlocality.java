/*
 * EMlocality.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMlocality_default;
import film.logicentity.Locality;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMlocality
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMlocality extends EMlocality_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
public static final String OrderBy = " order by locality.countrycode, locality.postalcode, locality.locality";
public static final String SQLWherecountryPK = "countrycode = :country.code:";
public static final String SQLSelect4countryPK = "select * from locality where " + SQLWherecountryPK + OrderBy;
public static final String SQLSelect4arealevel1PK = "select * from locality "
        + "inner join postalcode on locality.countrycode = postalcode.countrycode and locality.postalcode = postalcode.postalcode "
        + "where postalcode.countrycode = :arealevel1.countrycode: and postalcode.al1code = :arealevel1.al1code: " + OrderBy;
public static final String SQLSelect4arealevel2PK = "select * from locality "
        + "inner join postalcode on locality.countrycode = postalcode.countrycode and locality.postalcode = postalcode.postalcode "
        + "where postalcode.countrycode = :arealevel2.countrycode: and postalcode.al1code = :arealevel2.al1code: "
        + "and postalcode.al2code = :arealevel2.al2code: " + OrderBy;
public static final String SQLSelect4arealevel3PK = "select * from locality "
        + "inner join postalcode on locality.countrycode = postalcode.countrycode and locality.postalcode = postalcode.postalcode "
        + "where postalcode.countrycode = :arealevel3.countrycode: and postalcode.al1code = :arealevel3.al1code: "
        + "and postalcode.al2code = :arealevel3.al2code: and postalcode.al3code = :arealevel3.al3code: " + OrderBy;

    /**
     * Map ResultSet Field values to Locality
     * @param dbresult: Database ResultSet
     * @return Locality
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Locality locality = (Locality)super.mapResultSet2Entity(dbresult);
        return locality;
    }    
    
}

