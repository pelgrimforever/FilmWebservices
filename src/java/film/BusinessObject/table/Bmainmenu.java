/*
 * Bmainmenu.java
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
import film.conversion.json.JSONMainmenu;
import film.conversion.entity.EMmainmenu;
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
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public abstract class Bmainmenu extends BLtable {

    /**
     * Constructor, sets Mainmenu as default Entity
     */
    public Bmainmenu() {
        super(new Mainmenu(), new EMmainmenu());
    }

    /**
     * Constructor, sets Mainmenu as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bmainmenu(BLtable transactionobject) {
        super(transactionobject, new Mainmenu(), new EMmainmenu());
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
     * @param mainmenu primary key field
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
     * @param mainmenu primary key field
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
    public ArrayList<Mainmenu> getMainmenus() throws DBException {
        return (ArrayList<Mainmenu>)super.getEntities(EMmainmenu.SQLSelectAll);
    }

    /**
     * search Mainmenu for primary key
     * @param mainmenuPK: Mainmenu primary key
     * @return Mainmenu object
     * @throws DBException
     */
    public Mainmenu getMainmenu(IMainmenuPK mainmenuPK) throws DBException {
        return (Mainmenu)super.getEntity((MainmenuPK)mainmenuPK);
    }

    /**
     * search mainmenu with IMainmenusearch parameters
     * @param search IMainmenusearch
     * @return ArrayList of Mainmenu
     * @throws DBException 
     */
    public ArrayList<Mainmenu> searchmainmenus(IMainmenusearch search) throws DBException {
        return (ArrayList<Mainmenu>)this.search(search);
    }

    /**
     * search mainmenu with IMainmenusearch parameters, order by orderby sql clause
     * @param search IMainmenusearch
     * @param orderby sql order by string
     * @return ArrayList of Mainmenu
     * @throws DBException 
     */
    public ArrayList<Mainmenu> searchmainmenus(IMainmenusearch search, String orderby) throws DBException {
        return (ArrayList<Mainmenu>)this.search(search, orderby);
    }

    /**
     * Search mainmenu in database for mainmenuPK:
     * @param mainmenuPK: Mainmenu Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getMainmenuExists(IMainmenuPK mainmenuPK) throws DBException {
        return super.getEntityExists((MainmenuPK)mainmenuPK);
    }

    /**
     * try to insert Mainmenu in database
     * @param mainmenu Mainmenu object
     * @throws DBException
     * @throws DataException
     */
    public void insertMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        super.insertEntity(mainmenu);
    }

    /**
     * check if MainmenuPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param mainmenu Mainmenu object
     * @throws DBException
     * @throws DataException
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
     * @param mainmenu Mainmenu object
     * @throws DBException
     * @throws DataException
     */
    public void updateMainmenu(IMainmenu mainmenu) throws DBException, DataException {
        super.updateEntity(mainmenu);
    }

    /**
     * try to delete Mainmenu in database
     * @param mainmenu Mainmenu object
     * @throws DBException
     */
    public void deleteMainmenu(IMainmenu mainmenu) throws DBException {
        cascadedeleteMainmenu(mainmenu.getPrimaryKey());
        super.deleteEntity(mainmenu);
    }

    /**
     * check data rules in Mainmenu, throw DataException with customized message if rules do not apply
     * @param mainmenu Mainmenu object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IMainmenu mainmenu) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(mainmenu.getPopuplabel()!=null && mainmenu.getPopuplabel().length()>IMainmenu.SIZE_POPUPLABEL) {
            message.append("Popuplabel is langer dan toegestaan. Max aantal karakters: ").append(IMainmenu.SIZE_POPUPLABEL).append("\n");
        }
        if(mainmenu.getPopuplabel()==null) {
            message.append("Popuplabel mag niet leeg zijn.\n");
        }
        if(mainmenu.getIcon()!=null && mainmenu.getIcon().length()>IMainmenu.SIZE_ICON) {
            message.append("Icon is langer dan toegestaan. Max aantal karakters: ").append(IMainmenu.SIZE_ICON).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where mainmenuPK is used in a primary key
     * @param mainmenuPK: Mainmenu primary key
     */
    public void cascadedeleteMainmenu(IMainmenuPK mainmenuPK) {
        BLmenu blmenu = new BLmenu(this);
        blmenu.delete4mainmenu(mainmenuPK);
    }

    /**
     * @param menuPK: parent Menu for child object Mainmenu Entity
     * @return child Mainmenu Entity object
     * @throws CustomException
     */
    public Mainmenu getMenu(IMenuPK menuPK) throws CustomException {
        MainmenuPK mainmenuPK = new MainmenuPK(menuPK.getMainmenu());
        return this.getMainmenu(mainmenuPK);
    }


    /**
     * get all Mainmenu objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Mainmenu objects
     * @throws DBException
     */
    public ArrayList<Mainmenu> getMainmenus(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMmainmenu.SQLSelect);
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
        return (ArrayList<Mainmenu>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Mainmenu objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delMainmenu(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Mainmenu.table);
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
