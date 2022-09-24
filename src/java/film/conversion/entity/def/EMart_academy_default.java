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
import film.logicentity.Art_academy;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMart_academy_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "academyid = :art_academy.academyid:";
    public static final String SQLSelect1 = "select art_academy.* from art_academy where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_academy where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_academy.* from art_academy";

    public static final String SQLSelect = "select art_academy.* from art_academy";

//Custom code, do not change this line
    public static final String OrderBy = " order by academyid";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "art_academy"; }

    /**
     * 
     * @return SQL where clause for one Art_academy (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Art_academy (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        Art_academyPK art_academyPK = null;
        Art_academy art_academy;
        if(dbresult==null) {
            art_academy = new Art_academy(art_academyPK);
        } else {
            try {
                art_academyPK = new Art_academyPK(dbresult.getLong("academyid"));
                art_academy = new Art_academy(art_academyPK);
                art_academy.initAcademy(dbresult.getString("academy"));
                art_academy.initAcademylocation(dbresult.getString("academylocation"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return art_academy;
    }

}

