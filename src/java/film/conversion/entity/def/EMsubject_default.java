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
import film.logicentity.Subject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsubject_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMsubject_default implements TableMapper {
    
    public static final String SQLWhere1 = "cat1 = :subject.cat1: and cat2 = :subject.cat2: and id = :subject.id:";
    public static final String SQLSelect1 = "select subject.* from subject where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from subject where " + SQLWhere1;
    public static final String SQLSelectAll = "select subject.* from subject";

    public static final String SQLSelect = "select subject.* from subject";
    public static final String SQLWheresubjectcatCat1 = "cat1 = :subjectcat.cat:";
    public static final String SQLWheretree7subject = "tree7subjectid = :tree7subject.subjectid:";
    public static final String SQLWheresubjectcatCat2 = "cat2 = :subjectcat.cat:";

//Custom code, do not change this line
    public static final String OrderBy = " order by cat1, cat2, id";
//Custom code, do not change this line

    public static final String SQLSelect4subjectcatCat1 = "select * from subject where " + SQLWheresubjectcatCat1 + OrderBy;
    public static final String SQLDelete4subjectcatCat1 = "delete from subject where " + SQLWheresubjectcatCat1;
    public static final String SQLSelect4tree7subject = "select * from subject where " + SQLWheretree7subject + OrderBy;
    public static final String SQLDelete4tree7subject = "delete from subject where " + SQLWheretree7subject;
    public static final String SQLSelect4subjectcatCat2 = "select * from subject where " + SQLWheresubjectcatCat2 + OrderBy;
    public static final String SQLDelete4subjectcatCat2 = "delete from subject where " + SQLWheresubjectcatCat2;

    /**
     * 
     * @return SQL where clause for one Subject (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Subject (=Primarykey)
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
     * @return SQL select statement for all Subjects
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Subject
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SubjectPK subjectPK = null;
        Subject subject;
        if(dbresult==null) {
            subject = new Subject(subjectPK);
        } else {
            try {
                subjectPK = new SubjectPK(dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("id"));
                subject = new Subject(subjectPK);
                subject.initTree7subjectPK(new Tree7subjectPK(dbresult.getLong("tree7subjectid")));
                if(dbresult.wasNull()) subject.setTree7subjectPK(null);                
                subject.initSubject(dbresult.getString("subject"));
                subject.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return subject;
    }

}

