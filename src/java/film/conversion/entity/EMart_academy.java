/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMart_academy_default;
import film.logicentity.Art_academy;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMart_academy extends EMart_academy_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_academy art_academy = (Art_academy)super.mapResultSet2Entity(dbresult);
        return art_academy;
    }    
    
}

