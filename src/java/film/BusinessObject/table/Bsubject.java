/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */

package film.BusinessObject.table;

import general.exception.*;
import java.util.ArrayList;
import db.*;
import data.interfaces.db.*;
import film.conversion.entity.EMsubject;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISubjectsearch;
import film.logicentity.Subject;

/**
 * @author Franky Laseure
 */
public abstract class Bsubject extends TableBusinessrules {

    public Bsubject(SQLreader sqlreader) {
        super(new TableIO(sqlreader, new EMsubject()));
    }

    public Bsubject(TableBusinessrules businessrules) {
        super(new TableIO(businessrules.getTableio(), new EMsubject()));
        this.tableio.setAuthenticated(tableio!=null && tableio.isAuthenticated());
    }

    public ISubject newSubject() {
    	return new Subject();
    }
    
    public ISubject newSubject(java.lang.String cat1, java.lang.String cat2, int id) {
        return new Subject(cat1, cat2, id);
    }

    public ISubject newSubject(ISubjectPK subjectPK) {
        return new Subject((SubjectPK)subjectPK);
    }

    public ISubjectPK newSubjectPK() {
        return new SubjectPK();
    }

    public ISubjectPK newSubjectPK(java.lang.String cat1, java.lang.String cat2, int id) {
        return new SubjectPK(cat1, cat2, id);
    }

    public ArrayList<Subject> getSubjects() throws DBException {
        return (ArrayList<Subject>)tableio.getEntities(EMsubject.SQLSelectAll);
    }

    public Subject getSubject(ISubjectPK subjectPK) throws DBException {
        return (Subject)tableio.getEntity((SubjectPK)subjectPK);
    }

    public ArrayList<Subject> searchsubjects(ISubjectsearch search) throws DBException {
        return (ArrayList<Subject>)tableio.search(search);
    }

    public ArrayList<Subject> searchsubjects(ISubjectsearch search, String orderby) throws DBException {
        return (ArrayList<Subject>)tableio.search(search, orderby);
    }

    public boolean getSubjectExists(ISubjectPK subjectPK) throws DBException {
        return tableio.getEntityExists((SubjectPK)subjectPK);
    }

    public Subject getEntity(String sql) throws DBException {
        return (Subject)tableio.getEntity(sql);
    }
    
    public Subject getEntity(String sql, SQLparameters parameters) throws DBException {
        return (Subject)tableio.getEntity(sql, parameters);
    }
    
    public ArrayList<Subject> getEntities(String sql) throws DBException {
        return tableio.getEntities(sql);
    }
    
    public ArrayList<Subject> getEntities(String sql, SQLparameters parameters) throws DBException {
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

    public ArrayList<Subject> search(Tablesearcher search) throws DBException {
        return tableio.search(search);
    }

    public ArrayList<Subject> search(Tablesearcher search, String orderby) throws DBException {
        return tableio.search(search, orderby);
    }

    public long searchcount(Tablesearcher search) throws DBException {
        return tableio.searchcount(search);
    }

    public void insertSubject(SQLTqueue transactionqueue, ISubject subject) throws DBException, DataException {
        tableio.insertEntity(transactionqueue, subject);
    }

    public void insertupdateSubject(SQLTqueue transactionqueue, ISubject subject) throws DBException, DataException {
    	checkDATA(subject);
        if(this.getSubjectExists(subject.getPrimaryKey())) {
            tableio.updateEntity(transactionqueue, subject);
        } else {
            tableio.insertEntity(transactionqueue, subject);
        }
    }

    public void updateSubject(SQLTqueue transactionqueue, ISubject subject) throws DBException, DataException {
    	checkDATA(subject);
        tableio.updateEntity(transactionqueue, subject);
    }

    public void deleteSubject(SQLTqueue transactionqueue, ISubject subject) throws DBException {
        cascadedeleteSubject(transactionqueue, subject.getPrimaryKey());
        tableio.deleteEntity(transactionqueue, subject);
    }

    private void checkDATA(ISubject subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Subject.Cat1 - Subjectcat.Cat
        //foreign key Subject.Cat2 - Subjectcat.Cat
        //Primary key
        if(subject.getSubject()!=null && subject.getSubject().length()>ISubject.SIZE_SUBJECT) {
            message.append("Subject is langer dan toegestaan. Max aantal karakters: ").append(ISubject.SIZE_SUBJECT).append("\n");
        }
        if(subject.getSubject()==null) {
            message.append("Subject mag niet leeg zijn.\n");
        }
        if(subject.getDescription()!=null && subject.getDescription().length()>ISubject.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(ISubject.SIZE_DESCRIPTION).append("\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    public void cascadedeleteSubject(SQLTqueue transactionqueue, ISubjectPK subjectPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.setAuthenticated(isAuthenticated());
        blfilmsubjects.delete4subject(transactionqueue, subjectPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.setAuthenticated(isAuthenticated());
        blphotosubjects.delete4subject(transactionqueue, subjectPK);
    }

    public void delete4subjectcatCat1(SQLTqueue transactionqueue, ISubjectcatPK subjectcatPK) {
        tableio.addStatement(transactionqueue, EMsubject.SQLDelete4subjectcatCat1, subjectcatPK.getSQLprimarykey());
    }

    public ArrayList<Subject> getSubjects4subjectcatCat1(ISubjectcatPK subjectcatPK) throws CustomException {
        return tableio.getEntities(EMsubject.SQLSelect4subjectcatCat1, subjectcatPK.getSQLprimarykey());
    }
    public void delete4tree7subject(SQLTqueue transactionqueue, ITree7subjectPK tree7subjectPK) {
        tableio.addStatement(transactionqueue, EMsubject.SQLDelete4tree7subject, tree7subjectPK.getSQLprimarykey());
    }

    public ArrayList<Subject> getSubjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return tableio.getEntities(EMsubject.SQLSelect4tree7subject, tree7subjectPK.getSQLprimarykey());
    }
    public void delete4subjectcatCat2(SQLTqueue transactionqueue, ISubjectcatPK subjectcatPK) {
        tableio.addStatement(transactionqueue, EMsubject.SQLDelete4subjectcatCat2, subjectcatPK.getSQLprimarykey());
    }

    public ArrayList<Subject> getSubjects4subjectcatCat2(ISubjectcatPK subjectcatPK) throws CustomException {
        return tableio.getEntities(EMsubject.SQLSelect4subjectcatCat2, subjectcatPK.getSQLprimarykey());
    }
    public Subject getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        SubjectPK subjectPK = new SubjectPK(filmsubjectsPK.getCat1(), filmsubjectsPK.getCat2(), filmsubjectsPK.getSubject());
        return this.getSubject(subjectPK);
    }

    public Subject getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        SubjectPK subjectPK = new SubjectPK(photosubjectsPK.getCat1(), photosubjectsPK.getCat2(), photosubjectsPK.getSubject());
        return this.getSubject(subjectPK);
    }


    public ArrayList<Subject> getSubjects(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsubject.SQLSelect);
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
        return (ArrayList<Subject>)tableio.getEntities(sql.toString(), sqlparameters);
    }

    public void delSubject(SQLTqueue transactionqueue, SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Subject.table);
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
