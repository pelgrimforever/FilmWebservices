/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Menu;
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
    private BLmenu blmenu = new BLmenu();
    
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
        return blmenu.getEntityExists(menuPK);
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

    public void secureinsertMenu(IMenu menu) throws DBException, DataException {
        blmenu.secureinsertMenu(menu);
    }

    public void secureupdateMenu(IMenu menu) throws DBException, DataException {
        blmenu.secureupdateMenu(menu);
    }

    public void securedeleteMenu(IMenu menu) throws DBException, DataException {
        blmenu.securedeleteMenu(menu);
    }
}

