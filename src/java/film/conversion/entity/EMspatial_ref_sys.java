/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMspatial_ref_sys_default;
import film.logicentity.Spatial_ref_sys;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMspatial_ref_sys extends EMspatial_ref_sys_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Spatial_ref_sys spatial_ref_sys = (Spatial_ref_sys)super.mapResultSet2Entity(dbresult);
        return spatial_ref_sys;
    }    
    
}

