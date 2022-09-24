/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMcreator;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ICreatorsearch;
import film.logicentity.Creator;

public abstract class Bcreator extends TableBusinessrules {

    public Bcreator(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMcreator()));
    }

    public Bcreator(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMcreator()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ICreator newCreator() {
    	return new Creator();
    }
    
    public ICreator newCreator(java.lang.String creatorid) {
        return new Creator(creatorid);
    }

    public ICreator newCreator(ICreatorPK creatorPK) {
        return new Creator((CreatorPK)creatorPK);
    }

    public ICreatorPK newCreatorPK() {
        return new CreatorPK();
    }

    public ICreatorPK newCreatorPK(java.lang.String creatorid) {
        return new CreatorPK(creatorid);
    }

    public ArrayList<Creator> getCreators() throws DBException {
        return (ArrayList<Creator>)tableio.getEntities(EMcreator.SQLSelectAll);
    }

    public Creator getCreator(ICreatorPK creatorPK) throws DBException {
        return (Creator)tableio.getEntity((CreatorPK)creatorPK);
    }

    public ArrayList<Creator> searchcreators(ICreatorsearch search) throws DBException {
        return (ArrayList<Creator>)tableio.search(search);
    }

    public ArrayList<Creator> searchcreators(ICreatorsearch search, String orderby) throws DBException {
        return (ArrayList<Creator>)tableio.search(search, orderby);
    }

    public boolean getCreatorExists(ICreatorPK creatorPK) throws DBException {
        return tableio.getEntityExists((CreatorPK)creatorPK);
    }

    public Creator getEntity(String sql) throws DBException {
        return (Creator)tableio.getEntity(sql);
    }
    
    public Creator getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Creator)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Creator> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Creator> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Creator> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Creator> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertCreator(SQLTqueue transactionqueue, ICreator creator) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, creator);
    }

    public void insertupdateCreator(SQLTqueue transactionqueue, ICreator creator) throws DBException, DataException {
    	checkDATA(creator);
        if(this.getCreatorExists(creator.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, creator);
        } else {
            tableio.insertEntity(transactionqueue, creator);
        }
    }

    public void updateCreator(SQLTqueue transactionqueue, ICreator creator) throws DBException, DataException {
    	checkDATA(creator);
        tableio.updateEntity(transactionqueue, creator);
    }

    public void deleteCreator(SQLTqueue transactionqueue, ICreator creator) throws DBException {
        cascadedeleteCreator(transactionqueue, creator.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, creator);
    }

    private void checkDATA(ICreator creator) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(creator.getName()!=null && creator.getName().length()>ICreator.SIZE_NAME) {
            message.append("Name is langer dan toegestaan. Max aantal karakters: ").append(ICreator.SIZE_NAME).append("\n");
        }
        if(creator.getSurname()!=null && creator.getSurname().length()>ICreator.SIZE_SURNAME) {
            message.append("Surname is langer dan toegestaan. Max aantal karakters: ").append(ICreator.SIZE_SURNAME).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteCreator(SQLTqueue transactionqueue, ICreatorPK creatorPK) {
    }


    public ArrayList<Creator> getCreators(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMcreator.SQLSelect);
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
        return (ArrayList<Creator>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delCreator(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Creator.table);
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
