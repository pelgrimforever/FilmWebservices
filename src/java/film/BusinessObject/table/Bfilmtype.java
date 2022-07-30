/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMfilmtype;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmtypesearch;
import film.logicentity.Filmtype;

/**
 * @author Franky Laseure
 */
public abstract class Bfilmtype extends TableBusinessrules {

    public Bfilmtype(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfilmtype()));
    }

    public Bfilmtype(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfilmtype()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFilmtype newFilmtype() {
    	return new Filmtype();
    }
    
    public IFilmtype newFilmtype(java.lang.String type) {
        return new Filmtype(type);
    }

    public IFilmtype newFilmtype(IFilmtypePK filmtypePK) {
        return new Filmtype((FilmtypePK)filmtypePK);
    }

    public IFilmtypePK newFilmtypePK() {
        return new FilmtypePK();
    }

    public IFilmtypePK newFilmtypePK(java.lang.String type) {
        return new FilmtypePK(type);
    }

    public ArrayList<Filmtype> getFilmtypes() throws DBException {
        return (ArrayList<Filmtype>)tableio.getEntities(EMfilmtype.SQLSelectAll);
    }

    public Filmtype getFilmtype(IFilmtypePK filmtypePK) throws DBException {
        return (Filmtype)tableio.getEntity((FilmtypePK)filmtypePK);
    }

    public ArrayList<Filmtype> searchfilmtypes(IFilmtypesearch search) throws DBException {
        return (ArrayList<Filmtype>)tableio.search(search);
    }

    public ArrayList<Filmtype> searchfilmtypes(IFilmtypesearch search, String orderby) throws DBException {
        return (ArrayList<Filmtype>)tableio.search(search, orderby);
    }

    public boolean getFilmtypeExists(IFilmtypePK filmtypePK) throws DBException {
        return tableio.getEntityExists((FilmtypePK)filmtypePK);
    }

    public Filmtype getEntity(String sql) throws DBException {
        return (Filmtype)tableio.getEntity(sql);
    }
    
    public Filmtype getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Filmtype)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Filmtype> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Filmtype> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Filmtype> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Filmtype> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFilmtype(SQLTqueue transactionqueue, IFilmtype filmtype) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, filmtype);
    }

    public void insertupdateFilmtype(SQLTqueue transactionqueue, IFilmtype filmtype) throws DBException, DataException {
    	checkDATA(filmtype);
        if(this.getFilmtypeExists(filmtype.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, filmtype);
        } else {
            tableio.insertEntity(transactionqueue, filmtype);
        }
    }

    public void updateFilmtype(SQLTqueue transactionqueue, IFilmtype filmtype) throws DBException, DataException {
    	checkDATA(filmtype);
        tableio.updateEntity(transactionqueue, filmtype);
    }

    public void deleteFilmtype(SQLTqueue transactionqueue, IFilmtype filmtype) throws DBException {
        cascadedeleteFilmtype(transactionqueue, filmtype.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, filmtype);
    }

    private void checkDATA(IFilmtype filmtype) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(filmtype.getDescription()!=null && filmtype.getDescription().length()>IFilmtype.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IFilmtype.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteFilmtype(SQLTqueue transactionqueue, IFilmtypePK filmtypePK) {
    }


    public ArrayList<Filmtype> getFilmtypes(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilmtype.SQLSelect);
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
        return (ArrayList<Filmtype>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFilmtype(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Filmtype.table);
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
