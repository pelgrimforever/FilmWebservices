/*
 * EMview_countryphotocount.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_countryphotocount_default;
import film.logicview.View_countryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_countryphotocount
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_countryphotocount extends EMview_countryphotocount_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_countryphotocount
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_countryphotocount view_countryphotocount = (View_countryphotocount)super.mapResultSet2Entity(dbresult);
        return view_countryphotocount;
    }    
    
}

