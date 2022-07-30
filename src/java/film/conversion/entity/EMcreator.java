/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMcreator_default;
import film.logicentity.Creator;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMcreator extends EMcreator_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String OrderBy = " order by creator.creatorid";
    
    public static final String SQLSelectAll = "select creator.* from creator" + OrderBy;

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Creator creator = (Creator)super.mapResultSet2Entity(dbresult);
        return creator;
    }    
    
}

