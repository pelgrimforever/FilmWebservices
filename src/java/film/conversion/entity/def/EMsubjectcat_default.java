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
import film.logicentity.Subjectcat;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMsubjectcat_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "cat = :subjectcat.cat:";
    public static final String SQLSelect1 = "select subjectcat.* from subjectcat where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from subjectcat where " + SQLWhere1;
    public static final String SQLSelectAll = "select subjectcat.* from subjectcat";

    public static final String SQLSelect = "select subjectcat.* from subjectcat";

//Custom code, do not change this line
    public static final String OrderBy = " order by cat";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "subjectcat"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

