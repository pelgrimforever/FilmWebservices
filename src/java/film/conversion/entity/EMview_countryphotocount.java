/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import data.interfaces.db.View;
import film.conversion.entity.def.EMview_countryphotocount_default;
import film.logicview.View_countryphotocount;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMview_countryphotocount extends EMview_countryphotocount_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public View mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        View_countryphotocount view_countryphotocount = (View_countryphotocount)super.mapResultSet2Entity(dbresult);
        return view_countryphotocount;
    }    
    
}

