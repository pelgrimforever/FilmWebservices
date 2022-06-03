/*
 * EMart_photo.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMart_photo_default;
import film.logicentity.Art_photo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMart_photo
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMart_photo extends EMart_photo_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Art_photo
     * @param dbresult: Database ResultSet
     * @return Art_photo
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_photo art_photo = (Art_photo)super.mapResultSet2Entity(dbresult);
        return art_photo;
    }    
    
}

