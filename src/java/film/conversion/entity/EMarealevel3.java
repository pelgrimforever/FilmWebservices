/*
 * EMarealevel3.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMarealevel3_default;
import film.logicentity.Arealevel3;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMarealevel3
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMarealevel3 extends EMarealevel3_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
public static final String OrderBy = " order by name";

    /**
     * Map ResultSet Field values to Arealevel3
     * @param dbresult: Database ResultSet
     * @return Arealevel3
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel3 arealevel3 = (Arealevel3)super.mapResultSet2Entity(dbresult);
        return arealevel3;
    }    
    
}

