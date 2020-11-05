/*
 * Bmainmenu.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 25.9.2020 11:35
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
import film.conversion.json.JSONMainmenu;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMainmenusearch;
import film.logicentity.Mainmenu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bmainmenu
 *
 * Superclass for manipulating data- and database objects
 * for Entity Mainmenu and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bmainmenu extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Mainmenu as default Entity
     */
    public Bmainmenu() {
        super(new SQLMapper_pgsql(connectionpool, "Mainmenu"), new Mainmenu());
    }

    /**
     * Constructor, sets Mainmenu as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmainmenu(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Mainmenu());
    }

    /**
     * Map ResultSet Field values to Mainmenu
     * @param dbresult: Database ResultSet
     */
    public Mainmenu mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        MainmenuPK mainmenuPK = null;
        Mainmenu mainmenu;
        if(dbresult==null) {
            mainmenu = new Mainmenu(mainmenuPK);
        } else {
            try {
                mainmenuPK = new MainmenuPK(dbresult.getString("mainmenu"));
                mainmenu = new Mainmenu(mainmenuPK);
                mainmenu.initPopuplabel(dbresult.getString("popuplabel"));
                mainmenu.initIcon(dbresult.getString("icon"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, mainmenu);
        return mainmenu;
    }

    /**
     * create new empty Mainmenu object
     * @return empty IMainmenu
     */
    public IMainmenu newMainmenu() {
    	return new Mainmenu();
    }
    
    /**
     * create new empty Mainmenu object
     * create new primary key with given parameters
     * @return IMainmenu with primary key
     */
    public IMainmenu newMainmenu(java.lang.String mainmenu) {
        return new Mainmenu(mainmenu);
    }

    /**
     * create new empty Mainmenu object with given primary key
     * @param mainmenuPK: primary key for Mainmenu
     * @return IMainmenu with primary key
     */
    public IMainmenu newMainmenu(IMainmenuPK mainmenuPK) {
        return new Mainmenu((MainmenuPK)mainmenuPK);
    }

    /**
     * create new empty primary key
     * @return empty MainmenuPK
     */
    public IMainmenuPK newMainmenuPK() {
        return new MainmenuPK();
    }

    /**
     * create new primary key with given parameters
     * @return new IMainmenuPK
     */
    public IMainmenuPK newMainmenuPK(java.lang.String mainmenu) {
        return new MainmenuPK(mainmenu);
    }

    /**
     * get all Mainmenu objects from database
     * @return ArrayList of Mainmenu objects
     * @throws DBException
     */
    public ArrayList getMainmenus() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Mainmenu.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Mainmenu for primary key
     * @param mainmenuPK: Mainmenu primary key
     * @return Mainmenu object
     * @throws DBException
     */
    public Mainmenu getMainmenu(IMainmenuPK mainmenuPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Mainmenu)super.getEntity((MainmenuPK)mainmenuPK);
        } else return null;
    }

    public ArrayList searchmainmenus(IMainmenusearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchmainmenus(IMainmenusearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search mainmenu in database for mainmenuPK:
     * @param mainmenuPK: Mainmenu Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMainmenuExists(IMainmenuPK mainmenuPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((MainmenuPK)mainmenuPK);
        } else return false;
    }

    /**
     * try to insert Mainmenu in database
     * @param film: Mainmenu object
     * @throws DBException
     */
    public void insertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(mainmenu);
        }
    }

    /**
     * check if MainmenuPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Mainmenu object
     * @throws DBException
     */
    public void insertupdateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        if(this.getMainmenuExists(mainmenu.getPrimaryKey())) {
            super.updateEntity(mainmenu);
        } else {
            super.insertEntity(mainmenu);
        }
    }

    /**
     * try to update Mainmenu in database
     * @param film: Mainmenu object
     * @throws DBException
     */
    public void updateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(mainmenu);
        }
    }

    /**
     * try to delete Mainmenu in database
     * @param film: Mainmenu object
     * @throws DBException
     */
    public void deleteMainmenu(IMainmenu mainmenu) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteMainmenu(mainmenu.getOwnerobject(), mainmenu.getPrimaryKey());
            super.deleteEntity(mainmenu);
        }
    }

    /**
     * check data rules in Mainmenu, throw DataException with customized message if rules do not apply
     * @param film: Mainmenu object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMainmenu mainmenu) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(mainmenu.getPopuplabel()!=null && mainmenu.getPopuplabel().length()>IMainmenu.SIZE_POPUPLABEL) {
            message.append("Popuplabel is langer dan toegestaan. Max aantal karakters: " + IMainmenu.SIZE_POPUPLABEL + "\n");
        }
        if(mainmenu.getPopuplabel()==null) {
            message.append("Popuplabel mag niet leeg zijn.\n");
        }
        if(mainmenu.getIcon()!=null && mainmenu.getIcon().length()>IMainmenu.SIZE_ICON) {
            message.append("Icon is langer dan toegestaan. Max aantal karakters: " + IMainmenu.SIZE_ICON + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where mainmenuPK is used in a primary key
     * @param mainmenuPK: Mainmenu primary key
     */
    public void cascadedeleteMainmenu(String senderobject, IMainmenuPK mainmenuPK) {
        BLmenu blmenu = new BLmenu(this);
        blmenu.delete4mainmenu(senderobject, mainmenuPK);
    }

    /**
     * @param menuPK: parent Menu for child object Mainmenu Entity
     * @return child Mainmenu Entity object
     * @throws film.general.exception.CustomException
     */
    public IMainmenu getMenu(IMenuPK menuPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            MainmenuPK mainmenuPK = new MainmenuPK(menuPK.getMainmenu());
            return this.getMainmenu(mainmenuPK);
        } else return null;
    }


    /**
     * get all Mainmenu objects for sqlparameters
     * @return ArrayList of Mainmenu objects
     * @throws DBException
     */
    public ArrayList getMainmenus(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Mainmenu.SQLSelect;
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
     * delete all Mainmenu objects for sqlparameters
     * @throws DBException
     */
    public void delMainmenu(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Mainmenu.table;
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
