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
import film.conversion.entity.EMuploadsession;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IUploadsessionsearch;
import film.logicentity.Uploadsession;

public abstract class Buploadsession extends TableBusinessrules {

    public Buploadsession(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMuploadsession()));
    }

    public Buploadsession(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMuploadsession()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IUploadsession newUploadsession() {
    	return new Uploadsession();
    }
    
    public IUploadsession newUploadsession(java.lang.String filename) {
        return new Uploadsession(filename);
    }

    public IUploadsession newUploadsession(IUploadsessionPK uploadsessionPK) {
        return new Uploadsession((UploadsessionPK)uploadsessionPK);
    }

    public IUploadsessionPK newUploadsessionPK() {
        return new UploadsessionPK();
    }

    public IUploadsessionPK newUploadsessionPK(java.lang.String filename) {
        return new UploadsessionPK(filename);
    }

    public ArrayList<Uploadsession> getUploadsessions() throws DBException {
        return (ArrayList<Uploadsession>)tableio.getEntities(EMuploadsession.SQLSelectAll);
    }

    public Uploadsession getUploadsession(IUploadsessionPK uploadsessionPK) throws DBException {
        return (Uploadsession)tableio.getEntity((UploadsessionPK)uploadsessionPK);
    }

    public ArrayList<Uploadsession> searchuploadsessions(IUploadsessionsearch search) throws DBException {
        return (ArrayList<Uploadsession>)tableio.search(search);
    }

    public ArrayList<Uploadsession> searchuploadsessions(IUploadsessionsearch search, String orderby) throws DBException {
        return (ArrayList<Uploadsession>)tableio.search(search, orderby);
    }

    public boolean getUploadsessionExists(IUploadsessionPK uploadsessionPK) throws DBException {
        return tableio.getEntityExists((UploadsessionPK)uploadsessionPK);
    }

    public Uploadsession getEntity(String sql) throws DBException {
        return (Uploadsession)tableio.getEntity(sql);
    }
    
    public Uploadsession getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Uploadsession)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Uploadsession> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Uploadsession> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Uploadsession> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Uploadsession> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertUploadsession(SQLTqueue transactionqueue, IUploadsession uploadsession) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, uploadsession);
    }

    public void insertupdateUploadsession(SQLTqueue transactionqueue, IUploadsession uploadsession) throws DBException, DataException {
    	checkDATA(uploadsession);
        if(this.getUploadsessionExists(uploadsession.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, uploadsession);
        } else {
            tableio.insertEntity(transactionqueue, uploadsession);
        }
    }

    public void updateUploadsession(SQLTqueue transactionqueue, IUploadsession uploadsession) throws DBException, DataException {
    	checkDATA(uploadsession);
        tableio.updateEntity(transactionqueue, uploadsession);
    }

    public void deleteUploadsession(SQLTqueue transactionqueue, IUploadsession uploadsession) throws DBException {
        cascadedeleteUploadsession(transactionqueue, uploadsession.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, uploadsession);
    }

    private void checkDATA(IUploadsession uploadsession) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(uploadsession.getCreatorPK()!=null && uploadsession.getCreatorPK().getCreatorid()!=null && uploadsession.getCreatorPK().getCreatorid().length()>IUploadsession.SIZE_CREATOR) {
            message.append("Creator is langer dan toegestaan. Max aantal karakters: " + IUploadsession.SIZE_CREATOR + "\n");
        }

        if(uploadsession.getFilmgroupid()!=null && uploadsession.getFilmgroupid().length()>IUploadsession.SIZE_FILMGROUPID) {
            message.append("Filmgroupid is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_FILMGROUPID).append("\n");
        }
        if(uploadsession.getPhotosubjects()!=null && uploadsession.getPhotosubjects().length()>IUploadsession.SIZE_PHOTOSUBJECTS) {
            message.append("Photosubjects is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_PHOTOSUBJECTS).append("\n");
        }
        if(uploadsession.getDescription()!=null && uploadsession.getDescription().length()>IUploadsession.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(IUploadsession.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteUploadsession(SQLTqueue transactionqueue, IUploadsessionPK uploadsessionPK) {
    }

    public void delete4creator(SQLTqueue transactionqueue, ICreatorPK creatorPK) {
        tableio.addStatement(transactionqueue, EMuploadsession.SQLDelete4creator, creatorPK.getSQLprimarykey());
    }

    public ArrayList<Uploadsession> getUploadsessions4creator(ICreatorPK creatorPK) throws CustomException {
        return tableio.getEntities(EMuploadsession.SQLSelect4creator, creatorPK.getSQLprimarykey());
    }

    public ArrayList<Uploadsession> getUploadsessions(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMuploadsession.SQLSelect);
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
        return (ArrayList<Uploadsession>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delUploadsession(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Uploadsession.table);
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
