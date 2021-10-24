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
import film.logicentity.Creator;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMcreator_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMcreator_default implements TableMapper {
    
    public static final String SQLWhere1 = "creatorid = :creator.creatorid:";
    public static final String SQLSelect1 = "select creator.* from creator where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from creator where " + SQLWhere1;
    public static final String SQLSelectAll = "select creator.* from creator";

    public static final String SQLSelect = "select creator.* from creator";

//Custom code, do not change this line
    public static final String OrderBy = " order by creatorid";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Creators
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Creator
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

