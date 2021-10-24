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
import film.logicentity.Uploadsession;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMuploadsession_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMuploadsession_default implements TableMapper {
    
    public static final String SQLWhere1 = "filename = :uploadsession.filename:";
    public static final String SQLSelect1 = "select uploadsession.* from uploadsession where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from uploadsession where " + SQLWhere1;
    public static final String SQLSelectAll = "select uploadsession.* from uploadsession";

    public static final String SQLSelect = "select uploadsession.* from uploadsession";
    public static final String SQLWherecreator = "creator = :creator.creatorid:";

//Custom code, do not change this line
    public static final String OrderBy = " order by filename";
//Custom code, do not change this line

    public static final String SQLSelect4creator = "select * from uploadsession where " + SQLWherecreator + OrderBy;
    public static final String SQLDelete4creator = "delete from uploadsession where " + SQLWherecreator;

    /**
     * 
     * @return SQL where clause for one Uploadsession (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Uploadsession (=Primarykey)
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
     * @return SQL select statement for all Uploadsessions
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Uploadsession
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        UploadsessionPK uploadsessionPK = null;
        Uploadsession uploadsession;
        if(dbresult==null) {
            uploadsession = new Uploadsession(uploadsessionPK);
        } else {
            try {
                uploadsessionPK = new UploadsessionPK(dbresult.getString("filename"));
                uploadsession = new Uploadsession(uploadsessionPK);
                uploadsession.initCreatorPK(new CreatorPK(dbresult.getString("creator")));
                if(dbresult.wasNull()) uploadsession.setCreatorPK(null);                
                uploadsession.initUpload(dbresult.getBoolean("upload"));
                uploadsession.initRotation(dbresult.getFloat("rotation"));
                uploadsession.initFilmgroupid(dbresult.getString("filmgroupid"));
                uploadsession.initPhotosubjects(dbresult.getString("photosubjects"));
                uploadsession.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return uploadsession;
    }

}

