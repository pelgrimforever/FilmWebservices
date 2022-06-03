/*
 * Bmenuitem.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
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
import film.conversion.json.JSONMenuitem;
import film.conversion.entity.EMmenuitem;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bmenuitem extends BLtable {

    /**
     * Constructor, sets Menuitem as default Entity
     */
    public Bmenuitem() {
        super(new Menuitem(), new EMmenuitem());
    }

    /**
     * Constructor, sets Menuitem as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmenuitem(BLtable transactionobject) {
        super(transactionobject, new Menuitem(), new EMmenuitem());
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
     * @param mainmenu primary key field
     * @param menu primary key field
     * @param menuitem primary key field
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
     * @param mainmenu primary key field
     * @param menu primary key field
     * @param menuitem primary key field
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
    public ArrayList<Menuitem> getMenuitems() throws DBException {
        return (ArrayList<Menuitem>)super.getEntities(EMmenuitem.SQLSelectAll);
    }

    /**
     * search Menuitem for primary key
     * @param menuitemPK: Menuitem primary key
     * @return Menuitem object
     * @throws DBException
     */
    public Menuitem getMenuitem(IMenuitemPK menuitemPK) throws DBException {
        return (Menuitem)super.getEntity((MenuitemPK)menuitemPK);
    }

    /**
     * search menuitem with IMenuitemsearch parameters
     * @param search IMenuitemsearch
     * @return ArrayList of Menuitem
     * @throws DBException 
     */
    public ArrayList<Menuitem> searchmenuitems(IMenuitemsearch search) throws DBException {
        return (ArrayList<Menuitem>)this.search(search);
    }

    /**
     * search menuitem with IMenuitemsearch parameters, order by orderby sql clause
     * @param search IMenuitemsearch
     * @param orderby sql order by string
     * @return ArrayList of Menuitem
     * @throws DBException 
     */
    public ArrayList<Menuitem> searchmenuitems(IMenuitemsearch search, String orderby) throws DBException {
        return (ArrayList<Menuitem>)this.search(search, orderby);
    }

    /**
     * Search menuitem in database for menuitemPK:
     * @param menuitemPK: Menuitem Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMenuitemExists(IMenuitemPK menuitemPK) throws DBException {
        return super.getEntityExists((MenuitemPK)menuitemPK);
    }

    /**
     * try to insert Menuitem in database
     * @param menuitem Menuitem object
     * @throws DBException
     * @throws DataException
     */
    public void insertMenuitem(IMenuitem menuitem) throws DBException, DataException {
        super.insertEntity(menuitem);
    }

    /**
     * check if MenuitemPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param menuitem Menuitem object
     * @throws DBException
     * @throws DataException
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
     * @param menuitem Menuitem object
     * @throws DBException
     * @throws DataException
     */
    public void updateMenuitem(IMenuitem menuitem) throws DBException, DataException {
        super.updateEntity(menuitem);
    }

    /**
     * try to delete Menuitem in database
     * @param menuitem Menuitem object
     * @throws DBException
     */
    public void deleteMenuitem(IMenuitem menuitem) throws DBException {
        cascadedeleteMenuitem(menuitem.getPrimaryKey());
        super.deleteEntity(menuitem);
    }

    /**
     * check data rules in Menuitem, throw DataException with customized message if rules do not apply
     * @param menuitem Menuitem object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMenuitem menuitem) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Menuitem.Mainmenu - Menu.Mainmenu
        //foreign key Menuitem.Menu - Menu.Menu
        //Primary key
        if(menuitem.getTabpanel()!=null && menuitem.getTabpanel().length()>IMenuitem.SIZE_TABPANEL) {
            message.append("Tabpanel is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_TABPANEL).append("\n");
        }
        if(menuitem.getEditpanel()!=null && menuitem.getEditpanel().length()>IMenuitem.SIZE_EDITPANEL) {
            message.append("Editpanel is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_EDITPANEL).append("\n");
        }
        if(menuitem.getServlet()!=null && menuitem.getServlet().length()>IMenuitem.SIZE_SERVLET) {
            message.append("Servlet is langer dan toegestaan. Max aantal karakters: ").append(IMenuitem.SIZE_SERVLET).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where menuitemPK is used in a primary key
     * @param menuitemPK: Menuitem primary key
     */
    public void cascadedeleteMenuitem(IMenuitemPK menuitemPK) {
    }

    /**
     * @param menuPK: foreign key for Menu
     * @delete all Menuitem Entity objects for Menu in database
     */
    public void delete4menu(IMenuPK menuPK) {
        super.addStatement(EMmenuitem.SQLDelete4menu, menuPK.getSQLprimarykey());
    }

    /**
     * @param menuPK: foreign key for Menu
     * @return all Menuitem Entity objects for Menu
     * @throws CustomException
     */
    public ArrayList<Menuitem> getMenuitems4menu(IMenuPK menuPK) throws CustomException {
        return super.getEntities(EMmenuitem.SQLSelect4menu, menuPK.getSQLprimarykey());
    }

    /**
     * get all Menuitem objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Menuitem objects
     * @throws DBException
     */
    public ArrayList<Menuitem> getMenuitems(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmenuitem.SQLSelect);
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
        return (ArrayList<Menuitem>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Menuitem objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delMenuitem(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Menuitem.table);
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
