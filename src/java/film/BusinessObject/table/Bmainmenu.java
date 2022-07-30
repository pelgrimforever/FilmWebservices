/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMmainmenu;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IMainmenusearch;
import film.logicentity.Mainmenu;

/**
 * @author Franky Laseure
 */
public abstract class Bmainmenu extends TableBusinessrules {

    public Bmainmenu(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMmainmenu()));
    }

    public Bmainmenu(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMmainmenu()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IMainmenu newMainmenu() {
    	return new Mainmenu();
    }
    
    public IMainmenu newMainmenu(java.lang.String mainmenu) {
        return new Mainmenu(mainmenu);
    }

    public IMainmenu newMainmenu(IMainmenuPK mainmenuPK) {
        return new Mainmenu((MainmenuPK)mainmenuPK);
    }

    public IMainmenuPK newMainmenuPK() {
        return new MainmenuPK();
    }

    public IMainmenuPK newMainmenuPK(java.lang.String mainmenu) {
        return new MainmenuPK(mainmenu);
    }

    public ArrayList<Mainmenu> getMainmenus() throws DBException {
        return (ArrayList<Mainmenu>)tableio.getEntities(EMmainmenu.SQLSelectAll);
    }

    public Mainmenu getMainmenu(IMainmenuPK mainmenuPK) throws DBException {
        return (Mainmenu)tableio.getEntity((MainmenuPK)mainmenuPK);
    }

    public ArrayList<Mainmenu> searchmainmenus(IMainmenusearch search) throws DBException {
        return (ArrayList<Mainmenu>)tableio.search(search);
    }

    public ArrayList<Mainmenu> searchmainmenus(IMainmenusearch search, String orderby) throws DBException {
        return (ArrayList<Mainmenu>)tableio.search(search, orderby);
    }

    public boolean getMainmenuExists(IMainmenuPK mainmenuPK) throws DBException {
        return tableio.getEntityExists((MainmenuPK)mainmenuPK);
    }

    public Mainmenu getEntity(String sql) throws DBException {
        return (Mainmenu)tableio.getEntity(sql);
    }
    
    public Mainmenu getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Mainmenu)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Mainmenu> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Mainmenu> getEntities(String sql, SQLparameters parameters) throws DBException {
        return tableio.getEntities(sql, parameters);
    }

    public long count() throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }
    
    public long count(String sql, SQLparameters parameters) throws DBException {
        long count = 0;
        if(tableio.isReadAllowed())
            count = tableio.count();
        return count;
    }

    public ArrayList<Mainmenu> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Mainmenu> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertMainmenu(SQLTqueue transactionqueue, IMainmenu mainmenu) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, mainmenu);
    }

    public void insertupdateMainmenu(SQLTqueue transactionqueue, IMainmenu mainmenu) throws DBException, DataException {
    	checkDATA(mainmenu);
        if(this.getMainmenuExists(mainmenu.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, mainmenu);
        } else {
            tableio.insertEntity(transactionqueue, mainmenu);
        }
    }

    public void updateMainmenu(SQLTqueue transactionqueue, IMainmenu mainmenu) throws DBException, DataException {
    	checkDATA(mainmenu);
        tableio.updateEntity(transactionqueue, mainmenu);
    }

    public void deleteMainmenu(SQLTqueue transactionqueue, IMainmenu mainmenu) throws DBException {
        cascadedeleteMainmenu(transactionqueue, mainmenu.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, mainmenu);
    }

    private void checkDATA(IMainmenu mainmenu) throws DataException, DBException {
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
        
    public void cascadedeleteMainmenu(SQLTqueue transactionqueue, IMainmenuPK mainmenuPK) {
        BLmenu blmenu = new BLmenu(this);
        blmenu.setAuthenticated(isAuthenticated());
        blmenu.delete4mainmenu(transactionqueue, mainmenuPK);
    }

    public Mainmenu getMenu(IMenuPK menuPK) throws CustomException {
        MainmenuPK mainmenuPK = new MainmenuPK(menuPK.getMainmenu());
        return this.getMainmenu(mainmenuPK);
    }


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
        return (ArrayList<Mainmenu>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delMainmenu(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        tableio.addStatement(transactionqueue, sql.toString(), sqlparameters);
    }


}
