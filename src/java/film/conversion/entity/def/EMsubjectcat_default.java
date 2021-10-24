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
import film.logicentity.Subjectcat;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMsubjectcat_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMsubjectcat_default implements TableMapper {
    
    public static final String SQLWhere1 = "cat = :subjectcat.cat:";
    public static final String SQLSelect1 = "select subjectcat.* from subjectcat where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from subjectcat where " + SQLWhere1;
    public static final String SQLSelectAll = "select subjectcat.* from subjectcat";

    public static final String SQLSelect = "select subjectcat.* from subjectcat";

//Custom code, do not change this line
    public static final String OrderBy = " order by cat";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Subjectcat (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Subjectcat (=Primarykey)
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
     * @return SQL select statement for all Subjectcats
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Subjectcat
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SubjectcatPK subjectcatPK = null;
        Subjectcat subjectcat;
        if(dbresult==null) {
            subjectcat = new Subjectcat(subjectcatPK);
        } else {
            try {
                subjectcatPK = new SubjectcatPK(dbresult.getString("cat"));
                subjectcat = new Subjectcat(subjectcatPK);
                subjectcat.initCatno(dbresult.getInt("catno"));
                subjectcat.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return subjectcat;
    }

}

