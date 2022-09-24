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
import film.conversion.entity.EMphototree7subject;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhototree7subjectsearch;
import film.logicentity.Phototree7subject;

public abstract class Bphototree7subject extends TableBusinessrules {

    public Bphototree7subject(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMphototree7subject()));
    }

    public Bphototree7subject(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMphototree7subject()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IPhototree7subject newPhototree7subject() {
    	return new Phototree7subject();
    }
    
    public IPhototree7subject newPhototree7subject(java.lang.String film, int id, long subjectid) {
        return new Phototree7subject(film, id, subjectid);
    }

    public IPhototree7subject newPhototree7subject(IPhototree7subjectPK phototree7subjectPK) {
        return new Phototree7subject((Phototree7subjectPK)phototree7subjectPK);
    }

    public IPhototree7subjectPK newPhototree7subjectPK() {
        return new Phototree7subjectPK();
    }

    public IPhototree7subjectPK newPhototree7subjectPK(java.lang.String film, int id, long subjectid) {
        return new Phototree7subjectPK(film, id, subjectid);
    }

    public ArrayList<Phototree7subject> getPhototree7subjects() throws DBException {
        return (ArrayList<Phototree7subject>)tableio.getEntities(EMphototree7subject.SQLSelectAll);
    }

    public Phototree7subject getPhototree7subject(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return (Phototree7subject)tableio.getEntity((Phototree7subjectPK)phototree7subjectPK);
    }

    public ArrayList<Phototree7subject> searchphototree7subjects(IPhototree7subjectsearch search) throws DBException {
        return (ArrayList<Phototree7subject>)tableio.search(search);
    }

    public ArrayList<Phototree7subject> searchphototree7subjects(IPhototree7subjectsearch search, String orderby) throws DBException {
        return (ArrayList<Phototree7subject>)tableio.search(search, orderby);
    }

    public boolean getPhototree7subjectExists(IPhototree7subjectPK phototree7subjectPK) throws DBException {
        return tableio.getEntityExists((Phototree7subjectPK)phototree7subjectPK);
    }

    public Phototree7subject getEntity(String sql) throws DBException {
        return (Phototree7subject)tableio.getEntity(sql);
    }
    
    public Phototree7subject getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Phototree7subject)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Phototree7subject> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Phototree7subject> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Phototree7subject> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Phototree7subject> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertPhototree7subject(SQLTqueue transactionqueue, IPhototree7subject phototree7subject) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, phototree7subject);
    }

    public void insertupdatePhototree7subject(SQLTqueue transactionqueue, IPhototree7subject phototree7subject) throws DBException, DataException {
    	checkDATA(phototree7subject);
        if(this.getPhototree7subjectExists(phototree7subject.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, phototree7subject);
        } else {
            tableio.insertEntity(transactionqueue, phototree7subject);
        }
    }

    public void updatePhototree7subject(SQLTqueue transactionqueue, IPhototree7subject phototree7subject) throws DBException, DataException {
    	checkDATA(phototree7subject);
        tableio.updateEntity(transactionqueue, phototree7subject);
    }

    public void deletePhototree7subject(SQLTqueue transactionqueue, IPhototree7subject phototree7subject) throws DBException {
        cascadedeletePhototree7subject(transactionqueue, phototree7subject.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, phototree7subject);
    }

    private void checkDATA(IPhototree7subject phototree7subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Phototree7subject.Film - Photo.Film
        //foreign key Phototree7subject.Id - Photo.Id
        //foreign key Phototree7subject.Subjectid - Tree7subject.Subjectid
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeletePhototree7subject(SQLTqueue transactionqueue, IPhototree7subjectPK phototree7subjectPK) {
    }

    public void delete4tree7subject(SQLTqueue transactionqueue, ITree7subjectPK tree7subjectPK) {
        tableio.addStatement(transactionqueue, EMphototree7subject.SQLDelete4tree7subject, tree7subjectPK.getSQLprimarykey());
    }

    public ArrayList<Phototree7subject> getPhototree7subjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return tableio.getEntities(EMphototree7subject.SQLSelect4tree7subject, tree7subjectPK.getSQLprimarykey());
    }
    public void delete4photo(SQLTqueue transactionqueue, IPhotoPK photoPK) {
        tableio.addStatement(transactionqueue, EMphototree7subject.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Phototree7subject> getPhototree7subjects4photo(IPhotoPK photoPK) throws CustomException {
        return tableio.getEntities(EMphototree7subject.SQLSelect4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Phototree7subject> getPhototree7subjects(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphototree7subject.SQLSelect);
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
        return (ArrayList<Phototree7subject>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delPhototree7subject(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Phototree7subject.table);
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
