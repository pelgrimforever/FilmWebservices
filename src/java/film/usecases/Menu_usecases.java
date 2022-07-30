/*
 * Generated on 27.6.2022 16:45
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Menu;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Menu_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLmenu blmenu = new BLmenu(sqlreader);
    
    public Menu_usecases() {
        this(false);
    }
    
    public Menu_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blmenu.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmenu.count();
    }
    
    public ArrayList<Menu> get_all() throws DBException {
        return blmenu.getMenus();
    }
    
    public boolean getMenuExists(IMenuPK menuPK) throws DBException {
        return blmenu.getMenuExists(menuPK);
    }
    
    public Menu get_menu_by_primarykey(IMenuPK menuPK) throws DBException {
        return blmenu.getMenu(menuPK);
    }

    public ArrayList<Menu> get_menu_with_foreignkey_mainmenu(IMainmenuPK mainmenuPK) throws CustomException {
        return blmenu.getMenus4mainmenu(mainmenuPK);
    }
    
    public Menu get_menu_with_externalforeignkey_menuitem(IMenuitemPK menuitemPK) throws CustomException {
        return blmenu.getMenuitem(menuitemPK);
    }
    
    public ArrayList<Menu> search_menu(IMenusearch menusearch) throws CustomException {
        return blmenu.search(menusearch);
    }
    
    public long search_menu_count(IMenusearch menusearch) throws CustomException {
        return blmenu.searchcount(menusearch);
    }

    public void insertMenu(IMenu menu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenu.insertMenu(tq, menu);
        sqlwriter.Commit2DB(tq);
    }

    public void updateMenu(IMenu menu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenu.updateMenu(tq, menu);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteMenu(IMenu menu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenu.deleteMenu(tq, menu);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Mainmenu(IMainmenuPK mainmenuPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blmenu.delete4mainmenu(tq, mainmenuPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

