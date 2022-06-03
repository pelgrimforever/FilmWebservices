/*
 * EMarealevel2.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMarealevel2_default;
import film.logicentity.Arealevel2;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMarealevel2
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMarealevel2 extends EMarealevel2_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by name";

    /**
     * Map ResultSet Field values to Arealevel2
     * @param dbresult: Database ResultSet
     * @return Arealevel2
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Arealevel2 arealevel2 = (Arealevel2)super.mapResultSet2Entity(dbresult);
        return arealevel2;
    }    
    
}

