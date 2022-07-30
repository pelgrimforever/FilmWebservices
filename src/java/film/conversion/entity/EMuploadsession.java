/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMuploadsession_default;
import film.logicentity.Uploadsession;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMuploadsession extends EMuploadsession_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLdeleteall = "delete from uploadsession";
    public static final String OrderBy = " order by filename";
    public static final String SQLSelectAllsorded = "select * from uploadsession" + OrderBy;

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Uploadsession uploadsession = (Uploadsession)super.mapResultSet2Entity(dbresult);
        return uploadsession;
    }    
    
}

