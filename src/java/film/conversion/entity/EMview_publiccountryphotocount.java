/*
 * EMview_publiccountryphotocount.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_publiccountryphotocount_default;
import film.logicview.View_publiccountryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_publiccountryphotocount
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_publiccountryphotocount extends EMview_publiccountryphotocount_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_publiccountryphotocount
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_publiccountryphotocount view_publiccountryphotocount = (View_publiccountryphotocount)super.mapResultSet2Entity(dbresult);
        return view_publiccountryphotocount;
    }    
    
}

