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
import film.logicentity.Mainmenu;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EMmainmenu_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "mainmenu = :mainmenu.mainmenu:";
    public static final String SQLSelect1 = "select mainmenu.* from mainmenu where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from mainmenu where " + SQLWhere1;
    public static final String SQLSelectAll = "select mainmenu.* from mainmenu";

    public static final String SQLSelect = "select mainmenu.* from mainmenu";

//Custom code, do not change this line
    public static final String OrderBy = " order by mainmenu";
//Custom code, do not change this line


    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "mainmenu"; }

    /**
     * 
     * @return SQL where clause for one Mainmenu (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Mainmenu (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        MainmenuPK mainmenuPK = null;
        Mainmenu mainmenu;
        if(dbresult==null) {
            mainmenu = new Mainmenu(mainmenuPK);
        } else {
            try {
                mainmenuPK = new MainmenuPK(dbresult.getString("mainmenu"));
                mainmenu = new Mainmenu(mainmenuPK);
                mainmenu.initPopuplabel(dbresult.getString("popuplabel"));
                mainmenu.initIcon(dbresult.getString("icon"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return mainmenu;
    }

}

