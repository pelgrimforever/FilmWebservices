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
import film.logicentity.Menuitem;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * EMmenuitem_default
 * Maps SQL ResultSet to film.logicentity objects
 * @author Franky Laseure
 */
public class EMmenuitem_default implements TableMapper {
    
    public static final String SQLWhere1 = "mainmenu = :menuitem.mainmenu: and menu = :menuitem.menu: and menuitem = :menuitem.menuitem:";
    public static final String SQLSelect1 = "select menuitem.* from menuitem where " + SQLWhere1;
    public static final String SQLSelectPKexists = "select count(*) as count from menuitem where " + SQLWhere1;
    public static final String SQLSelectAll = "select menuitem.* from menuitem";

    public static final String SQLSelect = "select menuitem.* from menuitem";
    public static final String SQLWheremenu = "mainmenu = :menu.mainmenu: and menu = :menu.menu:";

//Custom code, do not change this line
    public static final String OrderBy = " order by mainmenu, menu, menuitem";
//Custom code, do not change this line

    public static final String SQLSelect4menu = "select * from menuitem where " + SQLWheremenu + OrderBy;
    public static final String SQLDelete4menu = "delete from menuitem where " + SQLWheremenu;

    /**
     * 
     * @return SQL where clause for one Menuitem (=Primarykey)
     */
    @Override
    public String getSQLWhere1() { return SQLWhere1; };

    /**
     * 
     * @return SQL select statement for one Menuitem (=Primarykey)
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
     * @return SQL select statement for all Menuitems
     */
    @Override
    public String getSQLSelectAll() { return SQLSelectAll; };

    /**
     * Map ResultSet Field values to Menuitem
     * @param dbresult: Database ResultSet
     */
    @Override
    public Object mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        MenuitemPK menuitemPK = null;
        Menuitem menuitem;
        if(dbresult==null) {
            menuitem = new Menuitem(menuitemPK);
        } else {
            try {
                menuitemPK = new MenuitemPK(dbresult.getString("mainmenu"), dbresult.getString("menu"), dbresult.getString("menuitem"));
                menuitem = new Menuitem(menuitemPK);
                menuitem.initTabpanel(dbresult.getString("tabpanel"));
                menuitem.initEditpanel(dbresult.getString("editpanel"));
                menuitem.initServlet(dbresult.getString("servlet"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        return menuitem;
    }

}

