/*
 * EMmenuitem.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMmenuitem_default;
import film.logicentity.Menuitem;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMmenuitem
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMmenuitem extends EMmenuitem_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Menuitem
     * @param dbresult: Database ResultSet
     * @return Menuitem
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Menuitem menuitem = (Menuitem)super.mapResultSet2Entity(dbresult);
        return menuitem;
    }    
    
}

