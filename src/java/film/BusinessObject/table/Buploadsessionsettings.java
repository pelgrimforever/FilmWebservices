/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMuploadsessionsettings;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsettingssearch;
import film.logicentity.Uploadsessionsettings;

/**
 * @author Franky Laseure
 */
public abstract class Buploadsessionsettings extends TableBusinessrules {

    public Buploadsessionsettings(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMuploadsessionsettings()));
    }

    public Buploadsessionsettings(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMuploadsessionsettings()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IUploadsessionsettings newUploadsessionsettings() {
    	return new Uploadsessionsettings();
    }
    
    public IUploadsessionsettings newUploadsessionsettings(java.lang.String directory) {
        return new Uploadsessionsettings(directory);
    }

    public IUploadsessionsettings newUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) {
        return new Uploadsessionsettings((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    public IUploadsessionsettingsPK newUploadsessionsettingsPK() {
        return new UploadsessionsettingsPK();
    }

    public IUploadsessionsettingsPK newUploadsessionsettingsPK(java.lang.String directory) {
        return new UploadsessionsettingsPK(directory);
    }

    public ArrayList<Uploadsessionsettings> getUploadsessionsettingss() throws DBException {
        return (ArrayList<Uploadsessionsettings>)tableio.getEntities(EMuploadsessionsettings.SQLSelectAll);
    }

    public Uploadsessionsettings getUploadsessionsettings(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return (Uploadsessionsettings)tableio.getEntity((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    public ArrayList<Uploadsessionsettings> searchuploadsessionsettingss(IUploadsessionsettingssearch search) throws DBException {
        return (ArrayList<Uploadsessionsettings>)tableio.search(search);
    }

    public ArrayList<Uploadsessionsettings> searchuploadsessionsettingss(IUploadsessionsettingssearch search, String orderby) throws DBException {
        return (ArrayList<Uploadsessionsettings>)tableio.search(search, orderby);
    }

    public boolean getUploadsessionsettingsExists(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return tableio.getEntityExists((UploadsessionsettingsPK)uploadsessionsettingsPK);
    }

    public Uploadsessionsettings getEntity(String sql) throws DBException {
        return (Uploadsessionsettings)tableio.getEntity(sql);
    }
    
    public Uploadsessionsettings getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Uploadsessionsettings)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Uploadsessionsettings> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Uploadsessionsettings> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Uploadsessionsettings> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Uploadsessionsettings> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertUploadsessionsettings(SQLTqueue transactionqueue, IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, uploadsessionsettings);
    }

    public void insertupdateUploadsessionsettings(SQLTqueue transactionqueue, IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
    	checkDATA(uploadsessionsettings);
        if(this.getUploadsessionsettingsExists(uploadsessionsettings.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, uploadsessionsettings);
        } else {
            tableio.insertEntity(transactionqueue, uploadsessionsettings);
        }
    }

    public void updateUploadsessionsettings(SQLTqueue transactionqueue, IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
    	checkDATA(uploadsessionsettings);
        tableio.updateEntity(transactionqueue, uploadsessionsettings);
    }

    public void deleteUploadsessionsettings(SQLTqueue transactionqueue, IUploadsessionsettings uploadsessionsettings) throws DBException {
        cascadedeleteUploadsessionsettings(transactionqueue, uploadsessionsettings.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, uploadsessionsettings);
    }

    private void checkDATA(IUploadsessionsettings uploadsessionsettings) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(uploadsessionsettings.getUploadtype()!=null && uploadsessionsettings.getUploadtype().length()>IUploadsessionsettings.SIZE_UPLOADTYPE) {
            message.append("Uploadtype is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_UPLOADTYPE).append("\n");
        }
        if(uploadsessionsettings.getUploadtype()==null) {
            message.append("Uploadtype mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getFilmgroups()!=null && uploadsessionsettings.getFilmgroups().length()>IUploadsessionsettings.SIZE_FILMGROUPS) {
            message.append("Filmgroups is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_FILMGROUPS).append("\n");
        }
        if(uploadsessionsettings.getFilmgroups()==null) {
            message.append("Filmgroups mag niet leeg zijn.\n");
        }
        if(uploadsessionsettings.getCopymode()!=null && uploadsessionsettings.getCopymode().length()>IUploadsessionsettings.SIZE_COPYMODE) {
            message.append("Copymode is langer dan toegestaan. Max aantal karakters: ").append(IUploadsessionsettings.SIZE_COPYMODE).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteUploadsessionsettings(SQLTqueue transactionqueue, IUploadsessionsettingsPK uploadsessionsettingsPK) {
    }


    public ArrayList<Uploadsessionsettings> getUploadsessionsettingss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuploadsessionsettings.SQLSelect);
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
        return (ArrayList<Uploadsessionsettings>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delUploadsessionsettings(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Uploadsessionsettings.table);
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
