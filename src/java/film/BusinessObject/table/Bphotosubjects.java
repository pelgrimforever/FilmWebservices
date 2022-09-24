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
import film.conversion.entity.EMphotosubjects;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPhotosubjectssearch;
import film.logicentity.Photosubjects;

public abstract class Bphotosubjects extends TableBusinessrules {

    public Bphotosubjects(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMphotosubjects()));
    }

    public Bphotosubjects(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMphotosubjects()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IPhotosubjects newPhotosubjects() {
    	return new Photosubjects();
    }
    
    public IPhotosubjects newPhotosubjects(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new Photosubjects(film, id, cat1, cat2, subject);
    }

    public IPhotosubjects newPhotosubjects(IPhotosubjectsPK photosubjectsPK) {
        return new Photosubjects((PhotosubjectsPK)photosubjectsPK);
    }

    public IPhotosubjectsPK newPhotosubjectsPK() {
        return new PhotosubjectsPK();
    }

    public IPhotosubjectsPK newPhotosubjectsPK(java.lang.String film, int id, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new PhotosubjectsPK(film, id, cat1, cat2, subject);
    }

    public ArrayList<Photosubjects> getPhotosubjectss() throws DBException {
        return (ArrayList<Photosubjects>)tableio.getEntities(EMphotosubjects.SQLSelectAll);
    }

    public Photosubjects getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return (Photosubjects)tableio.getEntity((PhotosubjectsPK)photosubjectsPK);
    }

    public ArrayList<Photosubjects> searchphotosubjectss(IPhotosubjectssearch search) throws DBException {
        return (ArrayList<Photosubjects>)tableio.search(search);
    }

    public ArrayList<Photosubjects> searchphotosubjectss(IPhotosubjectssearch search, String orderby) throws DBException {
        return (ArrayList<Photosubjects>)tableio.search(search, orderby);
    }

    public boolean getPhotosubjectsExists(IPhotosubjectsPK photosubjectsPK) throws DBException {
        return tableio.getEntityExists((PhotosubjectsPK)photosubjectsPK);
    }

    public Photosubjects getEntity(String sql) throws DBException {
        return (Photosubjects)tableio.getEntity(sql);
    }
    
    public Photosubjects getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Photosubjects)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Photosubjects> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Photosubjects> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Photosubjects> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Photosubjects> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertPhotosubjects(SQLTqueue transactionqueue, IPhotosubjects photosubjects) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, photosubjects);
    }

    public void insertupdatePhotosubjects(SQLTqueue transactionqueue, IPhotosubjects photosubjects) throws DBException, DataException {
    	checkDATA(photosubjects);
        if(this.getPhotosubjectsExists(photosubjects.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, photosubjects);
        } else {
            tableio.insertEntity(transactionqueue, photosubjects);
        }
    }

    public void updatePhotosubjects(SQLTqueue transactionqueue, IPhotosubjects photosubjects) throws DBException, DataException {
    	checkDATA(photosubjects);
        tableio.updateEntity(transactionqueue, photosubjects);
    }

    public void deletePhotosubjects(SQLTqueue transactionqueue, IPhotosubjects photosubjects) throws DBException {
        cascadedeletePhotosubjects(transactionqueue, photosubjects.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, photosubjects);
    }

    private void checkDATA(IPhotosubjects photosubjects) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Photosubjects.Film - Photo.Film
        //foreign key Photosubjects.Id - Photo.Id
        //foreign key Photosubjects.Cat1 - Subject.Cat1
        //foreign key Photosubjects.Cat2 - Subject.Cat2
        //foreign key Photosubjects.Subject - Subject.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeletePhotosubjects(SQLTqueue transactionqueue, IPhotosubjectsPK photosubjectsPK) {
    }

    public void delete4photo(SQLTqueue transactionqueue, IPhotoPK photoPK) {
        tableio.addStatement(transactionqueue, EMphotosubjects.SQLDelete4photo, photoPK.getSQLprimarykey());
    }

    public ArrayList<Photosubjects> getPhotosubjectss4photo(IPhotoPK photoPK) throws CustomException {
        return tableio.getEntities(EMphotosubjects.SQLSelect4photo, photoPK.getSQLprimarykey());
    }
    public void delete4subject(SQLTqueue transactionqueue, ISubjectPK subjectPK) {
        tableio.addStatement(transactionqueue, EMphotosubjects.SQLDelete4subject, subjectPK.getSQLprimarykey());
    }

    public ArrayList<Photosubjects> getPhotosubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        return tableio.getEntities(EMphotosubjects.SQLSelect4subject, subjectPK.getSQLprimarykey());
    }

    public ArrayList<Photosubjects> getPhotosubjectss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMphotosubjects.SQLSelect);
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
        return (ArrayList<Photosubjects>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delPhotosubjects(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Photosubjects.table);
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
