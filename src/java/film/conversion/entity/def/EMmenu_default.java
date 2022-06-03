/*
 * EMalliance_default.java
 *
 * Created on Okt 8, 2021
 * Generated on 1.5.2022 20:24
 *
 */
package film.conversion.entity.def;

import data.gis.shape.*;
import data.interfaces.db.LogicEntity;
import data.json.piJson;
import db.TableMapper;
import film.entity.pk.*;
import film.logicentity.Menu;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMmenu_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMmenu_default implements TableMapper {
    
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

    /**
     * @return Select statement for Primary key, with count field as result
     * count = 1: exists
     * count = 0: not found
     */
    @Override
    public String getSQLPKExcists() { return SQLSelectPKexists; };
    
    /**
     * 
     * @return SQL select statement for all Menus
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Menu
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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

