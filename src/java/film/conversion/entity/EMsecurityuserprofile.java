/*
 * EMsecurityuserprofile.java
 *
 * Created on Okt 8, 2021
 * Generated on 20.9.2021 18:6
 *
 */
package film.conversion.entity;

import data.interfaces.db.LogicEntity;
import film.conversion.entity.def.EMsecurityuserprofile_default;
import film.logicentity.Securityuserprofile;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * EMsecurityuserprofile
 * Custom transformation from ResultSet to Logic Entity
 * @author Franky Laseure
 */
public class EMsecurityuserprofile extends EMsecurityuserprofile_default {
//Metacoder: NO AUTHOMATIC UPDATE
    
    /**
     * Map ResultSet Field values to Securityuserprofile
     * @param dbresult: Database ResultSet
     * @return Securityuserprofile
     * @throws java.sql.SQLException
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Securityuserprofile securityuserprofile = (Securityuserprofile)super.mapResultSet2Entity(dbresult);
        return securityuserprofile;
    }    
    
}

