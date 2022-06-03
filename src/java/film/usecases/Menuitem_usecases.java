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
import film.logicentity.Menuitem;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Menuitem_usecases {

    private boolean loggedin = false;
    private BLmenuitem blmenuitem = new BLmenuitem();
    
    public Menuitem_usecases() {
        this(false);
    }
    
    public Menuitem_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blmenuitem.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmenuitem.count();
    }
    
    public ArrayList<Menuitem> get_all() throws DBException {
        return blmenuitem.getMenuitems();
    }
    
    public boolean getMenuitemExists(IMenuitemPK menuitemPK) throws DBException {
        return blmenuitem.getEntityExists(menuitemPK);
    }
    
    public Menuitem get_menuitem_by_primarykey(IMenuitemPK menuitemPK) throws DBException {
        return blmenuitem.getMenuitem(menuitemPK);
    }

    public ArrayList<Menuitem> get_menuitem_with_foreignkey_menu(IMenuPK menuPK) throws CustomException {
        return blmenuitem.getMenuitems4menu(menuPK);
    }
    
    public ArrayList<Menuitem> search_menuitem(IMenuitemsearch menuitemsearch) throws CustomException {
        return blmenuitem.search(menuitemsearch);
    }
    
    public long search_menuitem_count(IMenuitemsearch menuitemsearch) throws CustomException {
        return blmenuitem.searchcount(menuitemsearch);
    }

    public void secureinsertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        blmenuitem.secureinsertMenuitem(menuitem);
    }

    public void secureupdateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        blmenuitem.secureupdateMenuitem(menuitem);
    }

    public void securedeleteMenuitem(IMenuitem menuitem) throws DBException, DataException {
        blmenuitem.securedeleteMenuitem(menuitem);
    }
}

