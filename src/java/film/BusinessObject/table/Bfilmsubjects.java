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
import film.conversion.entity.EMfilmsubjects;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IFilmsubjectssearch;
import film.logicentity.Filmsubjects;

public abstract class Bfilmsubjects extends TableBusinessrules {

    public Bfilmsubjects(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMfilmsubjects()));
    }

    public Bfilmsubjects(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMfilmsubjects()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public IFilmsubjects newFilmsubjects() {
    	return new Filmsubjects();
    }
    
    public IFilmsubjects newFilmsubjects(java.lang.String film, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new Filmsubjects(film, cat1, cat2, subject);
    }

    public IFilmsubjects newFilmsubjects(IFilmsubjectsPK filmsubjectsPK) {
        return new Filmsubjects((FilmsubjectsPK)filmsubjectsPK);
    }

    public IFilmsubjectsPK newFilmsubjectsPK() {
        return new FilmsubjectsPK();
    }

    public IFilmsubjectsPK newFilmsubjectsPK(java.lang.String film, java.lang.String cat1, java.lang.String cat2, int subject) {
        return new FilmsubjectsPK(film, cat1, cat2, subject);
    }

    public ArrayList<Filmsubjects> getFilmsubjectss() throws DBException {
        return (ArrayList<Filmsubjects>)tableio.getEntities(EMfilmsubjects.SQLSelectAll);
    }

    public Filmsubjects getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return (Filmsubjects)tableio.getEntity((FilmsubjectsPK)filmsubjectsPK);
    }

    public ArrayList<Filmsubjects> searchfilmsubjectss(IFilmsubjectssearch search) throws DBException {
        return (ArrayList<Filmsubjects>)tableio.search(search);
    }

    public ArrayList<Filmsubjects> searchfilmsubjectss(IFilmsubjectssearch search, String orderby) throws DBException {
        return (ArrayList<Filmsubjects>)tableio.search(search, orderby);
    }

    public boolean getFilmsubjectsExists(IFilmsubjectsPK filmsubjectsPK) throws DBException {
        return tableio.getEntityExists((FilmsubjectsPK)filmsubjectsPK);
    }

    public Filmsubjects getEntity(String sql) throws DBException {
        return (Filmsubjects)tableio.getEntity(sql);
    }
    
    public Filmsubjects getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Filmsubjects)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Filmsubjects> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Filmsubjects> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Filmsubjects> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Filmsubjects> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertFilmsubjects(SQLTqueue transactionqueue, IFilmsubjects filmsubjects) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, filmsubjects);
    }

    public void insertupdateFilmsubjects(SQLTqueue transactionqueue, IFilmsubjects filmsubjects) throws DBException, DataException {
    	checkDATA(filmsubjects);
        if(this.getFilmsubjectsExists(filmsubjects.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, filmsubjects);
        } else {
            tableio.insertEntity(transactionqueue, filmsubjects);
        }
    }

    public void updateFilmsubjects(SQLTqueue transactionqueue, IFilmsubjects filmsubjects) throws DBException, DataException {
    	checkDATA(filmsubjects);
        tableio.updateEntity(transactionqueue, filmsubjects);
    }

    public void deleteFilmsubjects(SQLTqueue transactionqueue, IFilmsubjects filmsubjects) throws DBException {
        cascadedeleteFilmsubjects(transactionqueue, filmsubjects.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, filmsubjects);
    }

    private void checkDATA(IFilmsubjects filmsubjects) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Filmsubjects.Film - Film.Id
        //foreign key Filmsubjects.Cat1 - Subject.Cat1
        //foreign key Filmsubjects.Cat2 - Subject.Cat2
        //foreign key Filmsubjects.Subject - Subject.Id
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteFilmsubjects(SQLTqueue transactionqueue, IFilmsubjectsPK filmsubjectsPK) {
    }

    public void delete4subject(SQLTqueue transactionqueue, ISubjectPK subjectPK) {
        tableio.addStatement(transactionqueue, EMfilmsubjects.SQLDelete4subject, subjectPK.getSQLprimarykey());
    }

    public ArrayList<Filmsubjects> getFilmsubjectss4subject(ISubjectPK subjectPK) throws CustomException {
        return tableio.getEntities(EMfilmsubjects.SQLSelect4subject, subjectPK.getSQLprimarykey());
    }
    public void delete4film(SQLTqueue transactionqueue, IFilmPK filmPK) {
        tableio.addStatement(transactionqueue, EMfilmsubjects.SQLDelete4film, filmPK.getSQLprimarykey());
    }

    public ArrayList<Filmsubjects> getFilmsubjectss4film(IFilmPK filmPK) throws CustomException {
        return tableio.getEntities(EMfilmsubjects.SQLSelect4film, filmPK.getSQLprimarykey());
    }

    public ArrayList<Filmsubjects> getFilmsubjectss(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMfilmsubjects.SQLSelect);
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
        return (ArrayList<Filmsubjects>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delFilmsubjects(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Filmsubjects.table);
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
