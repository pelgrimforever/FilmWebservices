/*
 * Bsubject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 1.5.2022 20:24
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
import film.conversion.json.JSONSubject;
import film.conversion.entity.EMsubject;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISubjectsearch;
import film.logicentity.Subject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsubject
 *
 * Superclass for manipulating data- and database objects
 * for Entity Subject and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsubject extends BLtable {

    /**
     * Constructor, sets Subject as default Entity
     */
    public Bsubject() {
        super(new Subject(), new EMsubject());
    }

    /**
     * Constructor, sets Subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsubject(BLtable transactionobject) {
        super(transactionobject, new Subject(), new EMsubject());
    }

    /**
     * create new empty Subject object
     * @return empty ISubject
     */
    public ISubject newSubject() {
    	return new Subject();
    }
    
    /**
     * create new empty Subject object
     * create new primary key with given parameters
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param id primary key field
     * @return ISubject with primary key
     */
    public ISubject newSubject(java.lang.String cat1, java.lang.String cat2, int id) {
        return new Subject(cat1, cat2, id);
    }

    /**
     * create new empty Subject object with given primary key
     * @param subjectPK: primary key for Subject
     * @return ISubject with primary key
     */
    public ISubject newSubject(ISubjectPK subjectPK) {
        return new Subject((SubjectPK)subjectPK);
    }

    /**
     * create new empty primary key
     * @return empty SubjectPK
     */
    public ISubjectPK newSubjectPK() {
        return new SubjectPK();
    }

    /**
     * create new primary key with given parameters
     * @param cat1 primary key field
     * @param cat2 primary key field
     * @param id primary key field
     * @return new ISubjectPK
     */
    public ISubjectPK newSubjectPK(java.lang.String cat1, java.lang.String cat2, int id) {
        return new SubjectPK(cat1, cat2, id);
    }

    /**
     * get all Subject objects from database
     * @return ArrayList of Subject objects
     * @throws DBException
     */
    public ArrayList<Subject> getSubjects() throws DBException {
        return (ArrayList<Subject>)super.getEntities(EMsubject.SQLSelectAll);
    }

    /**
     * search Subject for primary key
     * @param subjectPK: Subject primary key
     * @return Subject object
     * @throws DBException
     */
    public Subject getSubject(ISubjectPK subjectPK) throws DBException {
        return (Subject)super.getEntity((SubjectPK)subjectPK);
    }

    /**
     * search subject with ISubjectsearch parameters
     * @param search ISubjectsearch
     * @return ArrayList of Subject
     * @throws DBException 
     */
    public ArrayList<Subject> searchsubjects(ISubjectsearch search) throws DBException {
        return (ArrayList<Subject>)this.search(search);
    }

    /**
     * search subject with ISubjectsearch parameters, order by orderby sql clause
     * @param search ISubjectsearch
     * @param orderby sql order by string
     * @return ArrayList of Subject
     * @throws DBException 
     */
    public ArrayList<Subject> searchsubjects(ISubjectsearch search, String orderby) throws DBException {
        return (ArrayList<Subject>)this.search(search, orderby);
    }

    /**
     * Search subject in database for subjectPK:
     * @param subjectPK: Subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSubjectExists(ISubjectPK subjectPK) throws DBException {
        return super.getEntityExists((SubjectPK)subjectPK);
    }

    /**
     * try to insert Subject in database
     * @param subject Subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertSubject(ISubject subject) throws DBException, DataException {
        super.insertEntity(subject);
    }

    /**
     * check if SubjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param subject Subject object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSubject(ISubject subject) throws DBException, DataException {
        if(this.getSubjectExists(subject.getPrimaryKey())) {
            super.updateEntity(subject);
        } else {
            super.insertEntity(subject);
        }
    }

    /**
     * try to update Subject in database
     * @param subject Subject object
     * @throws DBException
     * @throws DataException
     */
    public void updateSubject(ISubject subject) throws DBException, DataException {
        super.updateEntity(subject);
    }

    /**
     * try to delete Subject in database
     * @param subject Subject object
     * @throws DBException
     */
    public void deleteSubject(ISubject subject) throws DBException {
        cascadedeleteSubject(subject.getPrimaryKey());
        super.deleteEntity(subject);
    }

    /**
     * check data rules in Subject, throw DataException with customized message if rules do not apply
     * @param subject Subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISubject subject) throws DataException, DBException {
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
        
    /**
     * delete all records in tables where subjectPK is used in a primary key
     * @param subjectPK: Subject primary key
     */
    public void cascadedeleteSubject(ISubjectPK subjectPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.delete4subject(subjectPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.delete4subject(subjectPK);
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @delete all Subject Entity objects for Subjectcat in database
     */
    public void delete4subjectcatCat1(ISubjectcatPK subjectcatPK) {
        super.addStatement(EMsubject.SQLDelete4subjectcatCat1, subjectcatPK.getSQLprimarykey());
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @return all Subject Entity objects for Subjectcat
     * @throws CustomException
     */
    public ArrayList<Subject> getSubjects4subjectcatCat1(ISubjectcatPK subjectcatPK) throws CustomException {
        return super.getEntities(EMsubject.SQLSelect4subjectcatCat1, subjectcatPK.getSQLprimarykey());
    }
    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Subject Entity objects for Tree7subject in database
     */
    public void delete4tree7subject(ITree7subjectPK tree7subjectPK) {
        super.addStatement(EMsubject.SQLDelete4tree7subject, tree7subjectPK.getSQLprimarykey());
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Subject Entity objects for Tree7subject
     * @throws CustomException
     */
    public ArrayList<Subject> getSubjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        return super.getEntities(EMsubject.SQLSelect4tree7subject, tree7subjectPK.getSQLprimarykey());
    }
    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @delete all Subject Entity objects for Subjectcat in database
     */
    public void delete4subjectcatCat2(ISubjectcatPK subjectcatPK) {
        super.addStatement(EMsubject.SQLDelete4subjectcatCat2, subjectcatPK.getSQLprimarykey());
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @return all Subject Entity objects for Subjectcat
     * @throws CustomException
     */
    public ArrayList<Subject> getSubjects4subjectcatCat2(ISubjectcatPK subjectcatPK) throws CustomException {
        return super.getEntities(EMsubject.SQLSelect4subjectcatCat2, subjectcatPK.getSQLprimarykey());
    }
    /**
     * @param filmsubjectsPK: parent Filmsubjects for child object Subject Entity
     * @return child Subject Entity object
     * @throws CustomException
     */
    public Subject getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        SubjectPK subjectPK = new SubjectPK(filmsubjectsPK.getCat1(), filmsubjectsPK.getCat2(), filmsubjectsPK.getSubject());
        return this.getSubject(subjectPK);
    }

    /**
     * @param photosubjectsPK: parent Photosubjects for child object Subject Entity
     * @return child Subject Entity object
     * @throws CustomException
     */
    public Subject getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        SubjectPK subjectPK = new SubjectPK(photosubjectsPK.getCat1(), photosubjectsPK.getCat2(), photosubjectsPK.getSubject());
        return this.getSubject(subjectPK);
    }


    /**
     * get all Subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Subject objects
     * @throws DBException
     */
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
        return (ArrayList<Subject>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Subject objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSubject(SQLparameters sqlparameters, String andoroperator) throws DBException {
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
        this.addStatement(sql.toString(), sqlparameters);
    }


}
