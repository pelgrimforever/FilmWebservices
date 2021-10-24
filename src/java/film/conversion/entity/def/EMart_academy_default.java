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
import film.logicentity.Art_academy;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMart_academy_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMart_academy_default implements TableMapper {
    
    public static final String SQLWhere1 = "academyid = :art_academy.academyid:";
    public static final String SQLSelect1 = "select art_academy.* from art_academy where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from art_academy where " + SQLWhere1;
    public static final String SQLSelectAll = "select art_academy.* from art_academy";

    public static final String SQLSelect = "select art_academy.* from art_academy";

//Custom code, do not change this line
    public static final String OrderBy = " order by academyid";
//Custom code, do not change this line


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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Art_academys
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Art_academy
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

