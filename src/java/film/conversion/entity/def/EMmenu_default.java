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
import film.logicentity.Menu;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class EMmenu_default implements filmDatabaseproperties, TableMapper {
    
    public static final String SQLWhere1 = "mainmenu = :menu.mainmenu: and menu = :menu.menu:";
    public static final String SQLSelect1 = "select menu.* from menu where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from menu where " + SQLWhere1;
    public static final String SQLSelectAll = "select menu.* from menu";

    public static final String SQLSelect = "select menu.* from menu";
    public static final String SQLWheremainmenu = "mainmenu = :mainmenu.mainmenu:";

//Custom code, do not change this line
    public static final String OrderBy = " order by mainmenu, menu";
//Custom code, do not change this line

    public static final String SQLSelect4mainmenu = "select * from menu where " + SQLWheremainmenu + OrderBy;
    public static final String SQLDelete4mainmenu = "delete from menu where " + SQLWheremainmenu;

    @Override
    public String getDbtool() { return databasetool; }
    
    @Override
    public String getConnectionpool() { return connectionpool; }
    
    @Override
    public String getTable() { return "menu"; }

    /**
     * 
     * @return SQL where clause for one Menu (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Menu (=Primarykey)
     */
    @Override
    public String getSQLSelect1() { return SQLSelect1; };

    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    @Override
    public Entity mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        MenuPK menuPK = null;
        Menu menu;
        if(dbresult==null) {
            menu = new Menu(menuPK);
        } else {
            try {
                menuPK = new MenuPK(dbresult.getString("mainmenu"), dbresult.getString("menu"));
                menu = new Menu(menuPK);
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return menu;
    }

}

