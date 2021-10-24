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
import film.logicentity.Uploadsessionsettings;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMuploadsessionsettings_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMuploadsessionsettings_default implements TableMapper {
    
    public static final String SQLWhere1 = "directory = :uploadsessionsettings.directory:";
    public static final String SQLSelect1 = "select uploadsessionsettings.* from uploadsessionsettings where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from uploadsessionsettings where " + SQLWhere1;
    public static final String SQLSelectAll = "select uploadsessionsettings.* from uploadsessionsettings";

    public static final String SQLSelect = "select uploadsessionsettings.* from uploadsessionsettings";

//Custom code, do not change this line
    public static final String OrderBy = " order by directory";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Uploadsessionsettings (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Uploadsessionsettings (=Primarykey)
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
     * @return SQL select statement for all Uploadsessionsettingss
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Uploadsessionsettings
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UploadsessionsettingsPK uploadsessionsettingsPK = null;
        Uploadsessionsettings uploadsessionsettings;
        if(dbresult==null) {
            uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
        } else {
            try {
                uploadsessionsettingsPK = new UploadsessionsettingsPK(dbresult.getString("directory"));
                uploadsessionsettings = new Uploadsessionsettings(uploadsessionsettingsPK);
                uploadsessionsettings.initUploadtype(dbresult.getString("uploadtype"));
                uploadsessionsettings.initFilmgroups(dbresult.getString("filmgroups"));
                uploadsessionsettings.initLastposition(dbresult.getInt("lastposition"));
                uploadsessionsettings.initCopymode(dbresult.getString("copymode"));
                uploadsessionsettings.initUploadingposition(dbresult.getInt("uploadingposition"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return uploadsessionsettings;
    }

}

