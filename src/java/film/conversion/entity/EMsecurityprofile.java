/*
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 */
package film.conversion.entity;

import data.interfaces.db.Entity;
import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMsecurityprofile_default;
import film.logicentity.Securityprofile;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Franky Laseure
 */
public class EMsecurityprofile extends EMsecurityprofile_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    public static final String SQLWhereUsername = "securityuserprofile.siteusername = :siteusername:";
    public static final String SQLSelectUsername = "select securityprofile.* from securityprofile inner join securityuserprofile on securityprofile.userprofile = securityuserprofile.userprofile where " + SQLWhereUsername;

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Securityprofile securityprofile = (Securityprofile)super.mapResultSet2Entity(dbresult);
        return securityprofile;
    }    
    
}

