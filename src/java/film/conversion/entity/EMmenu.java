/*
 * EMmenu.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMmenu_default;
import film.logicentity.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMmenu
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMmenu extends EMmenu_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Menu
     * @param dbresult: Database ResultSet
     * @return Menu
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Menu menu = (Menu)super.mapResultSet2Entity(dbresult);
        return menu;
    }    
    
}

