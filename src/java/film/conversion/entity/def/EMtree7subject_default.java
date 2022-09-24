/*
 * Created on Okt 8, 2021
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
package film.conversion.entity.def;

import data.interfaces.db.*;
import data.gis.shape.*;
import data.json.piJson;
import db.TableMapper;
import film.filmDatabaseproperties;
import film.entity.pk.*;
import film.logicentity.Tree7subject;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMtree7subject_default implements filmDatabaseproperties, TableMapper {
    
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

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "tree7subject"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

