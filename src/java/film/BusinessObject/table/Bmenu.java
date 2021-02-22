/*
 * Bmenu.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONMenu;
import film.data.ProjectConstants;
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
public abstract class Bmenu extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Menu as default Entity
     */
    public Bmenu() {
        super(new SQLMapper_pgsql(connectionpool, "Menu"), new Menu());
    }

    /**
     * Constructor, sets Menu as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmenu(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Menu());
    }

    /**
     * Map ResultSet Field values to Menu
     * @param dbresult: Database ResultSet
     */
    public Menu mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
        this.loadExtra(dbresult, menu);
        return menu;
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
    public ArrayList getMenus() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Menu.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Menu for primary key
     * @param menuPK: Menu primary key
     * @return Menu object
     * @throws DBException
     */
    public Menu getMenu(IMenuPK menuPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Menu)super.getEntity((MenuPK)menuPK);
        } else return null;
    }

    public ArrayList searchmenus(IMenusearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchmenus(IMenusearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search menu in database for menuPK:
     * @param menuPK: Menu Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMenuExists(IMenuPK menuPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((MenuPK)menuPK);
        } else return false;
    }

    /**
     * try to insert Menu in database
     * @param film: Menu object
     * @throws DBException
     */
    public void insertMenu(IMenu menu) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(menu);
        }
    }

    /**
     * check if MenuPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Menu object
     * @throws DBException
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
     * @param film: Menu object
     * @throws DBException
     */
    public void updateMenu(IMenu menu) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(menu);
        }
    }

    /**
     * try to delete Menu in database
     * @param film: Menu object
     * @throws DBException
     */
    public void deleteMenu(IMenu menu) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteMenu(menu.getOwnerobject(), menu.getPrimaryKey());
            super.deleteEntity(menu);
        }
    }

    /**
     * check data rules in Menu, throw DataException with customized message if rules do not apply
     * @param film: Menu object
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
    public void cascadedeleteMenu(String senderobject, IMenuPK menuPK) {
        BLmenuitem blmenuitem = new BLmenuitem(this);
        blmenuitem.delete4menu(senderobject, menuPK);
    }

    /**
     * @param mainmenuPK: foreign key for Mainmenu
     * @delete all Menu Entity objects for Mainmenu in database
     * @throws film.general.exception.CustomException
     */
    public void delete4mainmenu(String senderobject, IMainmenuPK mainmenuPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Menu.SQLDelete4mainmenu, mainmenuPK.getKeyFields());
        }
    }

    /**
     * @param mainmenuPK: foreign key for Mainmenu
     * @return all Menu Entity objects for Mainmenu
     * @throws film.general.exception.CustomException
     */
    public ArrayList getMenus4mainmenu(IMainmenuPK mainmenuPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Menu.SQLSelect4mainmenu, mainmenuPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param menuitemPK: parent Menuitem for child object Menu Entity
     * @return child Menu Entity object
     * @throws film.general.exception.CustomException
     */
    public IMenu getMenuitem(IMenuitemPK menuitemPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            MenuPK menuPK = new MenuPK(menuitemPK.getMainmenu(), menuitemPK.getMenu());
            return this.getMenu(menuPK);
        } else return null;
    }


    /**
     * get all Menu objects for sqlparameters
     * @return ArrayList of Menu objects
     * @throws DBException
     */
    public ArrayList getMenus(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Menu.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Menu objects for sqlparameters
     * @throws DBException
     */
    public void delMenu(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Menu.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
