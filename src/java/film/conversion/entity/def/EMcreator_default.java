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
import film.logicentity.Creator;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMcreator_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "creatorid = :creator.creatorid:";
    public static final String SQLSelect1 = "select creator.* from creator where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from creator where " + SQLWhere1;
    public static final String SQLSelectAll = "select creator.* from creator";

    public static final String SQLSelect = "select creator.* from creator";

//Custom code, do not change this line
    public static final String OrderBy = " order by creatorid";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "creator"; }

    /**
     * 
     * @return SQL where clause for one Creator (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Creator (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        CreatorPK creatorPK = null;
        Creator creator;
        if(dbresult==null) {
            creator = new Creator(creatorPK);
        } else {
            try {
                creatorPK = new CreatorPK(dbresult.getString("creatorid"));
                creator = new Creator(creatorPK);
                creator.initName(dbresult.getString("name"));
                creator.initSurname(dbresult.getString("surname"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return creator;
    }

}

