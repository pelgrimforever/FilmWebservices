/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 1.5.2022 20:24
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import film.entity.pk.*;
import film.logicentity.Securityprofile;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsecurityprofile_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMsecurityprofile_default implements TableMapper {
    
    public static final String SQLWhere1 = "userprofile = :securityprofile.userprofile:";
    public static final String SQLSelect1 = "select securityprofile.* from securityprofile where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from securityprofile where " + SQLWhere1;
    public static final String SQLSelectAll = "select securityprofile.* from securityprofile";

    public static final String SQLSelect = "select securityprofile.* from securityprofile";

//Custom code, do not change this line
    public static final String OrderBy = " order by userprofile";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Securityprofile (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Securityprofile (=Primarykey)
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
     * @return SQL select statement for all Securityprofiles
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Securityprofile
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SecurityprofilePK securityprofilePK = null;
        Securityprofile securityprofile;
        if(dbresult==null) {
            securityprofile = new Securityprofile(securityprofilePK);
        } else {
            try {
                securityprofilePK = new SecurityprofilePK(dbresult.getString("userprofile"));
                securityprofile = new Securityprofile(securityprofilePK);
                securityprofile.initPrivateaccess(dbresult.getBoolean("privateaccess"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return securityprofile;
    }

}

