/*
 * EMarealevel1.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMarealevel1_default;
import film.logicentity.Arealevel1;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMarealevel1
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMarealevel1 extends EMarealevel1_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by name";
    
    /**
     * Map ResultSet Field values to Arealevel1
     * @param dbresult: Database ResultSet
     * @return Arealevel1
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel1 arealevel1 = (Arealevel1)super.mapResultSet2Entity(dbresult);
        return arealevel1;
    }    
    
}

