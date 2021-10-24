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
import film.logicentity.Tree7subject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMtree7subject_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMtree7subject_default implements TableMapper {
    
    public static final String SQLWhere1 = "subjectid = :tree7subject.subjectid:";
    public static final String SQLSelect1 = "select tree7subject.* from tree7subject where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from tree7subject where " + SQLWhere1;
    public static final String SQLSelectAll = "select tree7subject.* from tree7subject";

    public static final String SQLSelect = "select tree7subject.* from tree7subject";
    public static final String SQLWheretree7subjectParentsubjectid = "parentsubjectid = :tree7subject.subjectid:";

//Custom code, do not change this line
    public static final String OrderBy = " order by subjectid";
//Custom code, do not change this line

    public static final String SQLSelect4tree7subjectParentsubjectid = "select * from tree7subject where " + SQLWheretree7subjectParentsubjectid + OrderBy;
    public static final String SQLDelete4tree7subjectParentsubjectid = "delete from tree7subject where " + SQLWheretree7subjectParentsubjectid;

    /**
     * 
     * @return SQL where clause for one Tree7subject (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Tree7subject (=Primarykey)
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
     * @return SQL select statement for all Tree7subjects
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Tree7subject
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Tree7subjectPK tree7subjectPK = null;
        Tree7subject tree7subject;
        if(dbresult==null) {
            tree7subject = new Tree7subject(tree7subjectPK);
        } else {
            try {
                tree7subjectPK = new Tree7subjectPK(dbresult.getLong("subjectid"));
                tree7subject = new Tree7subject(tree7subjectPK);
                tree7subject.initTree7subjectparentsubjectidPK(new Tree7subjectPK(dbresult.getLong("parentsubjectid")));
                if(dbresult.wasNull()) tree7subject.setTree7subjectparentsubjectidPK(null);                
                tree7subject.initTree7id(dbresult.getString("tree7id"));
                tree7subject.initSubject(dbresult.getString("subject"));
                tree7subject.initTreestep(dbresult.getInt("treestep"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return tree7subject;
    }

}

