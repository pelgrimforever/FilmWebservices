/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMmainmenu_default;
import film.logicentity.Mainmenu;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMmainmenu
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMmainmenu extends EMmainmenu_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Mainmenu mainmenu = (Mainmenu)super.mapResultSet2Entity(dbresult);
        return mainmenu;
    }    
    
}

