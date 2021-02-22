/*
 * Bmenuitem.java
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
import film.conversion.json.JSONMenuitem;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMenuitemsearch;
import film.logicentity.Menuitem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bmenuitem
 *
 * Superclass for manipulating data- and database objects
 * for Entity Menuitem and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bmenuitem extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Menuitem as default Entity
     */
    public Bmenuitem() {
        super(new SQLMapper_pgsql(connectionpool, "Menuitem"), new Menuitem());
    }

    /**
     * Constructor, sets Menuitem as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmenuitem(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Menuitem());
    }

    /**
     * Map ResultSet Field values to Menuitem
     * @param dbresult: Database ResultSet
     */
    public Menuitem mapResultSet2Entity(ResultSet dbresult) throws SQLException {
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
        this.loadExtra(dbresult, menuitem);
        return menuitem;
    }

    /**
     * create new empty Menuitem object
     * @return empty IMenuitem
     */
    public IMenuitem newMenuitem() {
    	return new Menuitem();
    }
    
    /**
     * create new empty Menuitem object
     * create new primary key with given parameters
     * @return IMenuitem with primary key
     */
    public IMenuitem newMenuitem(java.lang.String mainmenu, java.lang.String menu, java.lang.String menuitem) {
        return new Menuitem(mainmenu, menu, menuitem);
    }

    /**
     * create new empty Menuitem object with given primary key
     * @param menuitemPK: primary key for Menuitem
     * @return IMenuitem with primary key
     */
    public IMenuitem newMenuitem(IMenuitemPK menuitemPK) {
        return new Menuitem((MenuitemPK)menuitemPK);
    }

    /**
     * create new empty primary key
     * @return empty MenuitemPK
     */
    public IMenuitemPK newMenuitemPK() {
        return new MenuitemPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IMenuitemPK
     */
    public IMenuitemPK newMenuitemPK(java.lang.String mainmenu, java.lang.String menu, java.lang.String menuitem) {
        return new MenuitemPK(mainmenu, menu, menuitem);
    }

    /**
     * get all Menuitem objects from database
     * @return ArrayList of Menuitem objects
     * @throws DBException
     */
    public ArrayList getMenuitems() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Menuitem.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Menuitem for primary key
     * @param menuitemPK: Menuitem primary key
     * @return Menuitem object
     * @throws DBException
     */
    public Menuitem getMenuitem(IMenuitemPK menuitemPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Menuitem)super.getEntity((MenuitemPK)menuitemPK);
        } else return null;
    }

    public ArrayList searchmenuitems(IMenuitemsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchmenuitems(IMenuitemsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search menuitem in database for menuitemPK:
     * @param menuitemPK: Menuitem Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMenuitemExists(IMenuitemPK menuitemPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((MenuitemPK)menuitemPK);
        } else return false;
    }

    /**
     * try to insert Menuitem in database
     * @param film: Menuitem object
     * @throws DBException
     */
    public void insertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(menuitem);
        }
    }

    /**
     * check if MenuitemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Menuitem object
     * @throws DBException
     */
    public void insertupdateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        if(this.getMenuitemExists(menuitem.getPrimaryKey())) {
            super.updateEntity(menuitem);
        } else {
            super.insertEntity(menuitem);
        }
    }

    /**
     * try to update Menuitem in database
     * @param film: Menuitem object
     * @throws DBException
     */
    public void updateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(menuitem);
        }
    }

    /**
     * try to delete Menuitem in database
     * @param film: Menuitem object
     * @throws DBException
     */
    public void deleteMenuitem(IMenuitem menuitem) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteMenuitem(menuitem.getOwnerobject(), menuitem.getPrimaryKey());
            super.deleteEntity(menuitem);
        }
    }

    /**
     * check data rules in Menuitem, throw DataException with customized message if rules do not apply
     * @param film: Menuitem object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMenuitem menuitem) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Menuitem.Mainmenu - Menu.Mainmenu
        //foreign key Menuitem.Menu - Menu.Menu
        //Primary key
        if(menuitem.getTabpanel()!=null && menuitem.getTabpanel().length()>IMenuitem.SIZE_TABPANEL) {
            message.append("Tabpanel is langer dan toegestaan. Max aantal karakters: " + IMenuitem.SIZE_TABPANEL + "\n");
        }
        if(menuitem.getEditpanel()!=null && menuitem.getEditpanel().length()>IMenuitem.SIZE_EDITPANEL) {
            message.append("Editpanel is langer dan toegestaan. Max aantal karakters: " + IMenuitem.SIZE_EDITPANEL + "\n");
        }
        if(menuitem.getServlet()!=null && menuitem.getServlet().length()>IMenuitem.SIZE_SERVLET) {
            message.append("Servlet is langer dan toegestaan. Max aantal karakters: " + IMenuitem.SIZE_SERVLET + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where menuitemPK is used in a primary key
     * @param menuitemPK: Menuitem primary key
     */
    public void cascadedeleteMenuitem(String senderobject, IMenuitemPK menuitemPK) {
    }

    /**
     * @param menuPK: foreign key for Menu
     * @delete all Menuitem Entity objects for Menu in database
     * @throws film.general.exception.CustomException
     */
    public void delete4menu(String senderobject, IMenuPK menuPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Menuitem.SQLDelete4menu, menuPK.getKeyFields());
        }
    }

    /**
     * @param menuPK: foreign key for Menu
     * @return all Menuitem Entity objects for Menu
     * @throws film.general.exception.CustomException
     */
    public ArrayList getMenuitems4menu(IMenuPK menuPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Menuitem.SQLSelect4menu, menuPK.getKeyFields());
        } else return new ArrayList();
    }

    /**
     * get all Menuitem objects for sqlparameters
     * @return ArrayList of Menuitem objects
     * @throws DBException
     */
    public ArrayList getMenuitems(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Menuitem.SQLSelect;
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
     * delete all Menuitem objects for sqlparameters
     * @throws DBException
     */
    public void delMenuitem(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Menuitem.table;
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
