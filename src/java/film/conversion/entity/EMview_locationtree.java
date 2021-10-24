/*
 * EMview_locationtree.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_locationtree_default;
import film.logicview.View_locationtree;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_locationtree
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_locationtree extends EMview_locationtree_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_locationtree
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_locationtree view_locationtree = (View_locationtree)super.mapResultSet2Entity(dbresult);
        return view_locationtree;
    }    
    
}

