/*
 * Created on Okt 8, 2021
 * Generated on 27.6.2022 16:45
 */
package film.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import film.filmDatabaseproperties;
import film.entity.pk.*;
import film.logicentity.Phototree7subject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMphototree7subject_default implements filmDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "phototree7subject"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

