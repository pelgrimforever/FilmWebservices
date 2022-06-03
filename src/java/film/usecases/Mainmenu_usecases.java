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
import film.logicentity.Mainmenu;
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
    private BLmainmenu blmainmenu = new BLmainmenu();
    
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
        return blmainmenu.getEntityExists(mainmenuPK);
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

    public void secureinsertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        blmainmenu.secureinsertMainmenu(mainmenu);
    }

    public void secureupdateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        blmainmenu.secureupdateMainmenu(mainmenu);
    }

    public void securedeleteMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        blmainmenu.securedeleteMainmenu(mainmenu);
    }
}

