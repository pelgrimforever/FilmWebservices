/*
 * EMart_group.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMart_group_default;
import film.logicentity.Art_group;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMart_group
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMart_group extends EMart_group_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Art_group
     * @param dbresult: Database ResultSet
     * @return Art_group
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_group art_group = (Art_group)super.mapResultSet2Entity(dbresult);
        return art_group;
    }    
    
}

