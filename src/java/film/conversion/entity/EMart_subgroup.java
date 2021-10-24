/*
 * EMart_subgroup.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMart_subgroup_default;
import film.logicentity.Art_subgroup;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMart_subgroup
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMart_subgroup extends EMart_subgroup_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Art_subgroup
     * @param dbresult: Database ResultSet
     * @return Art_subgroup
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_subgroup art_subgroup = (Art_subgroup)super.mapResultSet2Entity(dbresult);
        return art_subgroup;
    }    
    
}

