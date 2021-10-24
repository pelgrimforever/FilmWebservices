/*
 * Bsubjectcat.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
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
import film.conversion.json.JSONSubjectcat;
import film.conversion.entity.EMsubjectcat;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.ISubjectcatsearch;
import film.logicentity.Subjectcat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Business Entity class Bsubjectcat
 *
 * Superclass for manipulating data- and database objects
 * for Entity Subjectcat and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bsubjectcat extends BLtable {

    /**
     * Constructor, sets Subjectcat as default Entity
     */
    public Bsubjectcat() {
        super(new Subjectcat(), new EMsubjectcat());
    }

    /**
     * Constructor, sets Subjectcat as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bsubjectcat(BLtable transactionobject) {
        super(transactionobject, new Subjectcat(), new EMsubjectcat());
    }

    /**
     * create new empty Subjectcat object
     * @return empty ISubjectcat
     */
    public ISubjectcat newSubjectcat() {
    	return new Subjectcat();
    }
    
    /**
     * create new empty Subjectcat object
     * create new primary key with given parameters
     * @param cat primary key field
     * @return ISubjectcat with primary key
     */
    public ISubjectcat newSubjectcat(java.lang.String cat) {
        return new Subjectcat(cat);
    }

    /**
     * create new empty Subjectcat object with given primary key
     * @param subjectcatPK: primary key for Subjectcat
     * @return ISubjectcat with primary key
     */
    public ISubjectcat newSubjectcat(ISubjectcatPK subjectcatPK) {
        return new Subjectcat((SubjectcatPK)subjectcatPK);
    }

    /**
     * create new empty primary key
     * @return empty SubjectcatPK
     */
    public ISubjectcatPK newSubjectcatPK() {
        return new SubjectcatPK();
    }

    /**
     * create new primary key with given parameters
     * @param cat primary key field
     * @return new ISubjectcatPK
     */
    public ISubjectcatPK newSubjectcatPK(java.lang.String cat) {
        return new SubjectcatPK(cat);
    }

    /**
     * get all Subjectcat objects from database
     * @return ArrayList of Subjectcat objects
     * @throws DBException
     */
    public ArrayList<Subjectcat> getSubjectcats() throws DBException {
        return (ArrayList<Subjectcat>)super.getEntities(EMsubjectcat.SQLSelectAll);
    }

    /**
     * search Subjectcat for primary key
     * @param subjectcatPK: Subjectcat primary key
     * @return Subjectcat object
     * @throws DBException
     */
    public Subjectcat getSubjectcat(ISubjectcatPK subjectcatPK) throws DBException {
        return (Subjectcat)super.getEntity((SubjectcatPK)subjectcatPK);
    }

    /**
     * search subjectcat with ISubjectcatsearch parameters
     * @param search ISubjectcatsearch
     * @return ArrayList of Subjectcat
     * @throws DBException 
     */
    public ArrayList<Subjectcat> searchsubjectcats(ISubjectcatsearch search) throws DBException {
        return (ArrayList<Subjectcat>)this.search(search);
    }

    /**
     * search subjectcat with ISubjectcatsearch parameters, order by orderby sql clause
     * @param search ISubjectcatsearch
     * @param orderby sql order by string
     * @return ArrayList of Subjectcat
     * @throws DBException 
     */
    public ArrayList<Subjectcat> searchsubjectcats(ISubjectcatsearch search, String orderby) throws DBException {
        return (ArrayList<Subjectcat>)this.search(search, orderby);
    }

    /**
     * Search subjectcat in database for subjectcatPK:
     * @param subjectcatPK: Subjectcat Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getSubjectcatExists(ISubjectcatPK subjectcatPK) throws DBException {
        return super.getEntityExists((SubjectcatPK)subjectcatPK);
    }

    /**
     * try to insert Subjectcat in database
     * @param subjectcat Subjectcat object
     * @throws DBException
     * @throws DataException
     */
    public void insertSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.insertEntity(subjectcat);
    }

    /**
     * check if SubjectcatPK exists
     * insert if not, update if found
     * do not commit transaction
     * @param subjectcat Subjectcat object
     * @throws DBException
     * @throws DataException
     */
    public void insertupdateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        if(this.getSubjectcatExists(subjectcat.getPrimaryKey())) {
            super.updateEntity(subjectcat);
        } else {
            super.insertEntity(subjectcat);
        }
    }

    /**
     * try to update Subjectcat in database
     * @param subjectcat Subjectcat object
     * @throws DBException
     * @throws DataException
     */
    public void updateSubjectcat(ISubjectcat subjectcat) throws DBException, DataException {
        super.updateEntity(subjectcat);
    }

    /**
     * try to delete Subjectcat in database
     * @param subjectcat Subjectcat object
     * @throws DBException
     */
    public void deleteSubjectcat(ISubjectcat subjectcat) throws DBException {
        cascadedeleteSubjectcat(subjectcat.getPrimaryKey());
        super.deleteEntity(subjectcat);
    }

    /**
     * check data rules in Subjectcat, throw DataException with customized message if rules do not apply
     * @param subjectcat Subjectcat object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(ISubjectcat subjectcat) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        if(subjectcat.getDescription()!=null && subjectcat.getDescription().length()>ISubjectcat.SIZE_DESCRIPTION) {
            message.append("Description is langer dan toegestaan. Max aantal karakters: ").append(ISubjectcat.SIZE_DESCRIPTION).append("\n");
        }
        if(subjectcat.getDescription()==null) {
            message.append("Description mag niet leeg zijn.\n");
        }
        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where subjectcatPK is used in a primary key
     * @param subjectcatPK: Subjectcat primary key
     */
    public void cascadedeleteSubjectcat(ISubjectcatPK subjectcatPK) {
        BLsubject blsubjectCat1 = new BLsubject(this);
        blsubjectCat1.delete4subjectcatCat1(subjectcatPK);
        BLsubject blsubjectCat2 = new BLsubject(this);
        blsubjectCat2.delete4subjectcatCat2(subjectcatPK);
    }

    /**
     * @param subjectPK: parent Subject for child object Subjectcat Entity
     * @return child Subjectcat Entity object
     * @throws CustomException
     */
    public Subjectcat getSubjectcat1(ISubjectPK subjectPK) throws CustomException {
        SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat1());
        return this.getSubjectcat(subjectcatPK);
    }

    /**
     * @param subjectPK: parent Subject for child object Subjectcat Entity
     * @return child Subjectcat Entity object
     * @throws CustomException
     */
    public Subjectcat getSubjectcat2(ISubjectPK subjectPK) throws CustomException {
        SubjectcatPK subjectcatPK = new SubjectcatPK(subjectPK.getCat2());
        return this.getSubjectcat(subjectcatPK);
    }


    /**
     * get all Subjectcat objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @param sortlist sql sort string
     * @param sortoperator asc/desc
     * @return ArrayList of Subjectcat objects
     * @throws DBException
     */
    public ArrayList<Subjectcat> getSubjectcats(SQLparameters sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        StringBuilder sql = new StringBuilder(EMsubjectcat.SQLSelect);
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
        return (ArrayList<Subjectcat>)super.getEntities(sql.toString(), sqlparameters);
    }

    /**
     * delete all Subjectcat objects for sqlparameters
     * @param sqlparameters SQLparameters object
     * @param andoroperator "and"/"or"
     * @throws DBException
     */
    public void delSubjectcat(SQLparameters sqlparameters, String andoroperator) throws DBException {
        StringBuilder sql = new StringBuilder("delete from ").append(Subjectcat.table);
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
