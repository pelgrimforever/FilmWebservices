/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import data.interfaces.db.View;
import film.conversion.entity.def.EMview_photo_firstlastdate_default;
import film.logicview.View_photo_firstlastdate;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_photo_firstlastdate extends EMview_photo_firstlastdate_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_photo_firstlastdate view_photo_firstlastdate = (View_photo_firstlastdate)super.mapResultSet2Entity(dbresult);
        return view_photo_firstlastdate;
    }    
    
}

