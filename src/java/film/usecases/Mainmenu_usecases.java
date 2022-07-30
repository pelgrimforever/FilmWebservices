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
import film.logicentity.Mainmenu;
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
public class Mainmenu_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLmainmenu blmainmenu = new BLmainmenu(sqlreader);
    
    public Mainmenu_usecases() {
        this(false);
    }
    
    public Mainmenu_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blmainmenu.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blmainmenu.count();
    }
    
    public ArrayList<Mainmenu> get_all() throws DBException {
        return blmainmenu.getMainmenus();
    }
    
    public boolean getMainmenuExists(IMainmenuPK mainmenuPK) throws DBException {
        return blmainmenu.getMainmenuExists(mainmenuPK);
    }
    
    public Mainmenu get_mainmenu_by_primarykey(IMainmenuPK mainmenuPK) throws DBException {
        return blmainmenu.getMainmenu(mainmenuPK);
    }

    public Mainmenu get_mainmenu_with_externalforeignkey_menu(IMenuPK menuPK) throws CustomException {
        return blmainmenu.getMenu(menuPK);
    }
    
    public ArrayList<Mainmenu> search_mainmenu(IMainmenusearch mainmenusearch) throws CustomException {
        return blmainmenu.search(mainmenusearch);
    }
    
    public long search_mainmenu_count(IMainmenusearch mainmenusearch) throws CustomException {
        return blmainmenu.searchcount(mainmenusearch);
    }

    public void insertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmainmenu.insertMainmenu(tq, mainmenu);
        sqlwriter.Commit2DB(tq);
    }

    public void updateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmainmenu.updateMainmenu(tq, mainmenu);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blmainmenu.deleteMainmenu(tq, mainmenu);
        sqlwriter.Commit2DB(tq);
    }

}

