/*
 * Bmenu.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
 *
 */

package film.BusinessObject.table;

import BusinessObject.BLtable;
import general.exception.*;
import java.util.ArrayList;
import db.SQLMapperFactory;
import db.SQLparameters;
import data.gis.shape.*;
import data.json.piJson;
import data.json.psqlJsonobject;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONMenu;
import film.conversion.entity.EMmenu;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMenusearch;
import film.logicentity.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bmenu
 *
 * Superclass for manipulating data- and database objects
 * for Entity Menu and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bmenu extends BLtable {

    /**
     * Constructor, sets Menu as default Entity
     */
    public Bmenu() {
        super(new Menu(), new EMmenu());
    }

    /**
     * Constructor, sets Menu as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmenu(BLtable transactionobject) {
        super(transactionobject, new Menu(), new EMmenu());
    }

    /**
     * create new empty Menu object
     * @return empty IMenu
     */
    public IMenu newMenu() {
    	return new Menu();
    }
    
    /**
     * create new empty Menu object
     * create new primary key with given parameters
     * @param mainmenu primary key field
     * @param menu primary key field
     * @return IMenu with primary key
     */
    public IMenu newMenu(java.lang.String mainmenu, java.lang.String menu) {
        return new Menu(mainmenu, menu);
    }

    /**
     * create new empty Menu object with given primary key
     * @param menuPK: primary key for Menu
     * @return IMenu with primary key
     */
    public IMenu newMenu(IMenuPK menuPK) {
        return new Menu((MenuPK)menuPK);
    }

    /**
     * create new empty primary key
     * @return empty MenuPK
     */
    public IMenuPK newMenuPK() {
        return new MenuPK();
    }

    /**
     * create new primary key with given parameters
     * @param mainmenu primary key field
     * @param menu primary key field
     * @return new IMenuPK
     */
    public IMenuPK newMenuPK(java.lang.String mainmenu, java.lang.String menu) {
        return new MenuPK(mainmenu, menu);
    }

    /**
     * get all Menu objects from database
     * @return ArrayList of Menu objects
     * @throws DBException
     */
    public ArrayList<Menu> getMenus() throws DBException {
        return (ArrayList<Menu>)super.getEntities(EMmenu.SQLSelectAll);
    }

    /**
     * search Menu for primary key
     * @param menuPK: Menu primary key
     * @return Menu object
     * @throws DBException
     */
    public Menu getMenu(IMenuPK menuPK) throws DBException {
        return (Menu)super.getEntity((MenuPK)menuPK);
    }

    /**
     * search menu with IMenusearch parameters
     * @param search IMenusearch
     * @return ArrayList of Menu
     * @throws DBException 
     */
    public ArrayList<Menu> searchmenus(IMenusearch search) throws DBException {
        return (ArrayList<Menu>)this.search(search);
    }

    /**
     * search menu with IMenusearch parameters, order by orderby sql clause
     * @param search IMenusearch
     * @param orderby sql order by string
     * @return ArrayList of Menu
     * @throws DBException 
     */
    public ArrayList<Menu> searchmenus(IMenusearch search, String orderby) throws DBException {
        return (ArrayList<Menu>)this.search(search, orderby);
    }

    /**
     * Search menu in database for menuPK:
     * @param menuPK: Menu Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMenuExists(IMenuPK menuPK) throws DBException {
        return super.getEntityExists((MenuPK)menuPK);
    }

    /**
     * try to insert Menu in database
     * @param menu Menu object
     * @throws DBException
     * @throws DataException
     */
    public void insertMenu(IMenu menu) throws DBException, DataException {
        super.insertEntity(menu);
    }

    /**
     * check if MenuPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param menu Menu object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateMenu(IMenu menu) throws DBException, DataException {
        if(this.getMenuExists(menu.getPrimaryKey())) {
            super.updateEntity(menu);
        } else {
            super.insertEntity(menu);
        }
    }

    /**
     * try to update Menu in database
     * @param menu Menu object
     * @throws DBException
     * @throws DataException
     */
    public void updateMenu(IMenu menu) throws DBException, DataException {
        super.updateEntity(menu);
    }

    /**
     * try to delete Menu in database
     * @param menu Menu object
     * @throws DBException
     */
    public void deleteMenu(IMenu menu) throws DBException {
        cascadedeleteMenu(menu.getPrimaryKey());
        super.deleteEntity(menu);
    }

    /**
     * check data rules in Menu, throw DataException with customized message if rules do not apply
     * @param menu Menu object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMenu menu) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Menu.Mainmenu - Mainmenu.Mainmenu
        //Primary key
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where menuPK is used in a primary key
     * @param menuPK: Menu primary key
     */
    public void cascadedeleteMenu(IMenuPK menuPK) {
        BLmenuitem blmenuitem = new BLmenuitem(this);
        blmenuitem.delete4menu(menuPK);
    }

    /**
     * @param mainmenuPK: foreign key for Mainmenu
     * @delete all Menu Entity objects for Mainmenu in database
     */
    public void delete4mainmenu(IMainmenuPK mainmenuPK) {
        super.addStatement(EMmenu.SQLDelete4mainmenu, mainmenuPK.getSQLprimarykey());
    }

    /**
     * @param mainmenuPK: foreign key for Mainmenu
     * @return all Menu Entity objects for Mainmenu
     * @throws CustomException
     */
    public ArrayList<Menu> getMenus4mainmenu(IMainmenuPK mainmenuPK) throws CustomException {
        return super.getEntities(EMmenu.SQLSelect4mainmenu, mainmenuPK.getSQLprimarykey());
    }
    /**
     * @param menuitemPK: parent Menuitem for child object Menu Entity
     * @return child Menu Entity object
     * @throws CustomException
     */
    public Menu getMenuitem(IMenuitemPK menuitemPK) throws CustomException {
        MenuPK menuPK = new MenuPK(menuitemPK.getMainmenu(), menuitemPK.getMenu());
        return this.getMenu(menuPK);
    }


    /**
     * get all Menu objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Menu objects
     * @throws DBException
     */
    public ArrayList<Menu> getMenus(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmenu.SQLSelect);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        if(sortlist.length()>0) {
            sql.append(" order by ").append(sortlist).append(" ").append(sortoperator);
        }
        return (ArrayList<Menu>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Menu objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delMenu(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Menu.table);
        ArrayList<Object[]> parameters = sqlparameters.getParameters();
        int l = parameters.size();
        if(l>0) {
            sql.append(" where ");
            for(int i=0; i<l; i++) {
                sql.append(String.valueOf(parameters.get(i)[0])).append(" = :").append(String.valueOf(parameters.get(i)[0])).append(": ");
                if(i<l-1) sql.append(" ").append(andoroperator).append(" ");
            }
        }
        this.addStatement(sql.toString(), sqlparameters);
    }


}
