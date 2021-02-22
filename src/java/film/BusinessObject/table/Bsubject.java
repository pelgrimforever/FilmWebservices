/*
 * Bsubject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 4.1.2021 12:6
 *
 */

package film.BusinessObject.table;

import BusinessObject.GeneralEntityInterface;
import BusinessObject.GeneralEntityObject;
import general.exception.*;
import java.util.ArrayList;

import data.gis.shape.*;
import db.SQLMapper_pgsql;
import data.interfaces.db.Filedata;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONSubject;
import film.data.ProjectConstants;
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
public abstract class Bsubject extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Subject as default Entity
     */
    public Bsubject() {
        super(new SQLMapper_pgsql(connectionpool, "Subject"), new Subject());
    }

    /**
     * Constructor, sets Subject as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsubject(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Subject());
    }

    /**
     * Map ResultSet Field values to Subject
     * @param dbresult: Database ResultSet
     */
    public Subject mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        SubjectPK subjectPK = null;
        Subject subject;
        if(dbresult==null) {
            subject = new Subject(subjectPK);
        } else {
            try {
                subjectPK = new SubjectPK(dbresult.getString("cat1"), dbresult.getString("cat2"), dbresult.getInt("id"));
                subject = new Subject(subjectPK);
                subject.initTree7subjectPK(new Tree7subjectPK(dbresult.getLong("tree7subjectid")));
                if(dbresult.wasNull()) subject.setTree7subjectPK(null);                
                subject.initSubject(dbresult.getString("subject"));
                subject.initDescription(dbresult.getString("description"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, subject);
        return subject;
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
    public ArrayList getSubjects() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Subject.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Subject for primary key
     * @param subjectPK: Subject primary key
     * @return Subject object
     * @throws DBException
     */
    public Subject getSubject(ISubjectPK subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Subject)super.getEntity((SubjectPK)subjectPK);
        } else return null;
    }

    public ArrayList searchsubjects(ISubjectsearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchsubjects(ISubjectsearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search subject in database for subjectPK:
     * @param subjectPK: Subject Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSubjectExists(ISubjectPK subjectPK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((SubjectPK)subjectPK);
        } else return false;
    }

    /**
     * try to insert Subject in database
     * @param film: Subject object
     * @throws DBException
     */
    public void insertSubject(ISubject subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(subject);
        }
    }

    /**
     * check if SubjectPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Subject object
     * @throws DBException
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
     * @param film: Subject object
     * @throws DBException
     */
    public void updateSubject(ISubject subject) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(subject);
        }
    }

    /**
     * try to delete Subject in database
     * @param film: Subject object
     * @throws DBException
     */
    public void deleteSubject(ISubject subject) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeleteSubject(subject.getOwnerobject(), subject.getPrimaryKey());
            super.deleteEntity(subject);
        }
    }

    /**
     * check data rules in Subject, throw DataException with customized message if rules do not apply
     * @param film: Subject object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISubject subject) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //foreign key Subject.Cat1 - Subjectcat.Cat
        //foreign key Subject.Cat2 - Subjectcat.Cat
        //Primary key

        if(subject.getSubject()!=null && subject.getSubject().length()>ISubject.SIZE_SUBJECT) {
            message.append("Subject is langer dan toegestaan. Max aantal karakters: " + ISubject.SIZE_SUBJECT + "\n");
        }
        if(subject.getSubject()==null) {
            message.append("Subject mag niet leeg zijn.\n");
        }
        if(subject.getDescription()!=null && subject.getDescription().length()>ISubject.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: " + ISubject.SIZE_DESCRIPTION + "\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where subjectPK is used in a primary key
     * @param subjectPK: Subject primary key
     */
    public void cascadedeleteSubject(String senderobject, ISubjectPK subjectPK) {
        BLfilmsubjects blfilmsubjects = new BLfilmsubjects(this);
        blfilmsubjects.delete4subject(senderobject, subjectPK);
        BLphotosubjects blphotosubjects = new BLphotosubjects(this);
        blphotosubjects.delete4subject(senderobject, subjectPK);
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @delete all Subject Entity objects for Subjectcat in database
     * @throws film.general.exception.CustomException
     */
    public void delete4subjectcatCat1(String senderobject, ISubjectcatPK subjectcatPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Subject.SQLDelete4subjectcatCat1, subjectcatPK.getKeyFields());
        }
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @return all Subject Entity objects for Subjectcat
     * @throws film.general.exception.CustomException
     */
    public ArrayList getSubjects4subjectcatCat1(ISubjectcatPK subjectcatPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Subject.SQLSelect4subjectcatCat1, subjectcatPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @delete all Subject Entity objects for Tree7subject in database
     * @throws film.general.exception.CustomException
     */
    public void delete4tree7subject(String senderobject, ITree7subjectPK tree7subjectPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Subject.SQLDelete4tree7subject, tree7subjectPK.getKeyFields());
        }
    }

    /**
     * @param tree7subjectPK: foreign key for Tree7subject
     * @return all Subject Entity objects for Tree7subject
     * @throws film.general.exception.CustomException
     */
    public ArrayList getSubjects4tree7subject(ITree7subjectPK tree7subjectPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Subject.SQLSelect4tree7subject, tree7subjectPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @delete all Subject Entity objects for Subjectcat in database
     * @throws film.general.exception.CustomException
     */
    public void delete4subjectcatCat2(String senderobject, ISubjectcatPK subjectcatPK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Subject.SQLDelete4subjectcatCat2, subjectcatPK.getKeyFields());
        }
    }

    /**
     * @param subjectcatPK: foreign key for Subjectcat
     * @return all Subject Entity objects for Subjectcat
     * @throws film.general.exception.CustomException
     */
    public ArrayList getSubjects4subjectcatCat2(ISubjectcatPK subjectcatPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Subject.SQLSelect4subjectcatCat2, subjectcatPK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param filmsubjectsPK: parent Filmsubjects for child object Subject Entity
     * @return child Subject Entity object
     * @throws film.general.exception.CustomException
     */
    public ISubject getFilmsubjects(IFilmsubjectsPK filmsubjectsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SubjectPK subjectPK = new SubjectPK(filmsubjectsPK.getCat1(), filmsubjectsPK.getCat2(), filmsubjectsPK.getSubject());
            return this.getSubject(subjectPK);
        } else return null;
    }

    /**
     * @param photosubjectsPK: parent Photosubjects for child object Subject Entity
     * @return child Subject Entity object
     * @throws film.general.exception.CustomException
     */
    public ISubject getPhotosubjects(IPhotosubjectsPK photosubjectsPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            SubjectPK subjectPK = new SubjectPK(photosubjectsPK.getCat1(), photosubjectsPK.getCat2(), photosubjectsPK.getSubject());
            return this.getSubject(subjectPK);
        } else return null;
    }


    /**
     * get all Subject objects for sqlparameters
     * @return ArrayList of Subject objects
     * @throws DBException
     */
    public ArrayList getSubjects(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Subject.SQLSelect;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        if(sortlist.length()>0) {
            sql += " order by " + sortlist + " " + sortoperator;
        }
        return getMapper().loadEntityVector(this, sql, sqlparameters);
    }

    /**
     * delete all Subject objects for sqlparameters
     * @throws DBException
     */
    public void delSubject(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Subject.table;
        int l = sqlparameters.length;
        if(sqlparameters.length>0) {
            sql += " where ";
            for(int i=0; i<l; i++) {
                sql += String.valueOf(sqlparameters[i][0]) + " = :" + String.valueOf(sqlparameters[i][0]) + ": ";
                if(i<l-1) sql += " " + andoroperator + " ";
            }
        }
        this.addStatement(senderobject, sql, sqlparameters);
    }


}
