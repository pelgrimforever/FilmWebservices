/*
 * EMgeography_columns.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMgeography_columns_default;
import film.logicview.Geography_columns;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMgeography_columns
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMgeography_columns extends EMgeography_columns_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Geography_columns
     * @param dbresult: Database ResultSet
     */
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Geography_columns geography_columns = (Geography_columns)super.mapResultSet2Entity(dbresult);
        return geography_columns;
    }    
    
}

