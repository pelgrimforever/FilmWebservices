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
import film.logicentity.Filmtype;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMfilmtype_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "type = :filmtype.type:";
    public static final String SQLSelect1 = "select filmtype.* from filmtype where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from filmtype where " + SQLWhere1;
    public static final String SQLSelectAll = "select filmtype.* from filmtype";

    public static final String SQLSelect = "select filmtype.* from filmtype";

//Custom code, do not change this line
    public static final String OrderBy = " order by type";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "filmtype"; }

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

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

