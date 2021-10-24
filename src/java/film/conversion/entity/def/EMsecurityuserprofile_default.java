/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 24.9.2021 14:50
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import film.entity.pk.*;
import film.logicentity.Securityuserprofile;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsecurityuserprofile_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMsecurityuserprofile_default implements TableMapper {
    
    public static final String SQLWhere1 = "siteusername = :securityuserprofile.siteusername: and userprofile = :securityuserprofile.userprofile:";
    public static final String SQLSelect1 = "select securityuserprofile.* from securityuserprofile where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from securityuserprofile where " + SQLWhere1;
    public static final String SQLSelectAll = "select securityuserprofile.* from securityuserprofile";

    public static final String SQLSelect = "select securityuserprofile.* from securityuserprofile";
    public static final String SQLWheresecurityprofile = "userprofile = :securityprofile.userprofile:";

//Custom code, do not change this line
    public static final String OrderBy = " order by siteusername, userprofile";
//Custom code, do not change this line

    public static final String SQLSelect4securityprofile = "select * from securityuserprofile where " + SQLWheresecurityprofile + OrderBy;
    public static final String SQLDelete4securityprofile = "delete from securityuserprofile where " + SQLWheresecurityprofile;

    /**
     * 
     * @return SQL where clause for one Securityuserprofile (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Securityuserprofile (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Securityuserprofiles
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Securityuserprofile
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityuserprofilePK securityuserprofilePK = null;
        Securityuserprofile securityuserprofile;
        if(dbresult==null) {
            securityuserprofile = new Securityuserprofile(securityuserprofilePK);
        } else {
            try {
                securityuserprofilePK = new SecurityuserprofilePK(dbresult.getString("siteusername"), dbresult.getString("userprofile"));
                securityuserprofile = new Securityuserprofile(securityuserprofilePK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return securityuserprofile;
    }

}

