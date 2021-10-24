/*
 * EMmainmenu.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

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
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Mainmenu
     * @param dbresult: Database ResultSet
     * @return Mainmenu
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Mainmenu mainmenu = (Mainmenu)super.mapResultSet2Entity(dbresult);
        return mainmenu;
    }    
    
}

