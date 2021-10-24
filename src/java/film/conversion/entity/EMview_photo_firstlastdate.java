/*
 * EMview_photo_firstlastdate.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMview_photo_firstlastdate_default;
import film.logicview.View_photo_firstlastdate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMview_photo_firstlastdate
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMview_photo_firstlastdate extends EMview_photo_firstlastdate_default {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to View_photo_firstlastdate
     * @param dbresult: Database ResultSet
     * @return 
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photo_firstlastdate view_photo_firstlastdate = (View_photo_firstlastdate)super.mapResultSet2Entity(dbresult);
        return view_photo_firstlastdate;
    }    
    
}

