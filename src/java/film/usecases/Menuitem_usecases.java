/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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
import film.logicentity.Menuitem;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Menuitem_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLmenuitem blmenuitem = new BLmenuitem(sqlreader);
    
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
        return blmenuitem.getMenuitemExists(menuitemPK);
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

    public void insertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenuitem.insertMenuitem(tq, menuitem);
        sqlwriter.Commit2DB(tq);
    }

    public void updateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenuitem.updateMenuitem(tq, menuitem);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteMenuitem(IMenuitem menuitem) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmenuitem.deleteMenuitem(tq, menuitem);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Menu(IMenuPK menuPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blmenuitem.delete4menu(tq, menuPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

