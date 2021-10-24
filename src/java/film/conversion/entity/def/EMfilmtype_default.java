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
import film.logicentity.Filmtype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMfilmtype_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMfilmtype_default implements TableMapper {
    
    public static final String SQLWhere1 = "type = :filmtype.type:";
    public static final String SQLSelect1 = "select filmtype.* from filmtype where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from filmtype where " + SQLWhere1;
    public static final String SQLSelectAll = "select filmtype.* from filmtype";

    public static final String SQLSelect = "select filmtype.* from filmtype";

//Custom code, do not change this line
    public static final String OrderBy = " order by type";
//Custom code, do not change this line


    /**
     * 
     * @return SQL where clause for one Filmtype (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Filmtype (=Primarykey)
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
     * @return SQL select statement for all Filmtypes
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Filmtype
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        FilmtypePK filmtypePK = null;
        Filmtype filmtype;
        if(dbresult==null) {
            filmtype = new Filmtype(filmtypePK);
        } else {
            try {
                filmtypePK = new FilmtypePK(dbresult.getString("type"));
                filmtype = new Filmtype(filmtypePK);
                filmtype.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return filmtype;
    }

}

