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
import film.logicentity.Phototree7subject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMphototree7subject_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMphototree7subject_default implements TableMapper {
    
    public static final String SQLWhere1 = "film = :phototree7subject.film: and id = :phototree7subject.id: and subjectid = :phototree7subject.subjectid:";
    public static final String SQLSelect1 = "select phototree7subject.* from phototree7subject where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from phototree7subject where " + SQLWhere1;
    public static final String SQLSelectAll = "select phototree7subject.* from phototree7subject";

    public static final String SQLSelect = "select phototree7subject.* from phototree7subject";
    public static final String SQLWheretree7subject = "subjectid = :tree7subject.subjectid:";
    public static final String SQLWherephoto = "film = :photo.film: and id = :photo.id:";

//Custom code, do not change this line
    public static final String OrderBy = " order by film, id, subjectid";
//Custom code, do not change this line

    public static final String SQLSelect4tree7subject = "select * from phototree7subject where " + SQLWheretree7subject + OrderBy;
    public static final String SQLDelete4tree7subject = "delete from phototree7subject where " + SQLWheretree7subject;
    public static final String SQLSelect4photo = "select * from phototree7subject where " + SQLWherephoto + OrderBy;
    public static final String SQLDelete4photo = "delete from phototree7subject where " + SQLWherephoto;

    /**
     * 
     * @return SQL where clause for one Phototree7subject (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Phototree7subject (=Primarykey)
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
     * @return SQL select statement for all Phototree7subjects
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Phototree7subject
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Phototree7subjectPK phototree7subjectPK = null;
        Phototree7subject phototree7subject;
        if(dbresult==null) {
            phototree7subject = new Phototree7subject(phototree7subjectPK);
        } else {
            try {
                phototree7subjectPK = new Phototree7subjectPK(dbresult.getString("film"), dbresult.getInt("id"), dbresult.getLong("subjectid"));
                phototree7subject = new Phototree7subject(phototree7subjectPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return phototree7subject;
    }

}

