/*
 * Bpostalcode.java
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
import film.conversion.json.JSONPostalcode;
import film.data.ProjectConstants;
import film.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.entity.pk.*;
import film.interfaces.searchentity.IPostalcodesearch;
import film.logicentity.Postalcode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import org.postgresql.geometric.PGpoint;
import org.postgis.PGgeometry;
import org.json.simple.JSONObject;

/**
 * Business Entity class Bpostalcode
 *
 * Superclass for manipulating data- and database objects
 * for Entity Postalcode and direct related data
 * This class is overwritten each time the code generator runs
 * and is not meant to be changed
 *
 * @author Franky Laseure
 */
public abstract class Bpostalcode extends GeneralEntityObject implements ProjectConstants {

    /**
     * Constructor, sets Postalcode as default Entity
     */
    public Bpostalcode() {
        super(new SQLMapper_pgsql(connectionpool, "Postalcode"), new Postalcode());
    }

    /**
     * Constructor, sets Postalcode as default Entity
     * sets transaction queue from given GeneralEntityObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralEntityObjects that holds the transaction queue
     */
    public Bpostalcode(GeneralEntityInterface transactionobject) {
        super(transactionobject, new Postalcode());
    }

    /**
     * Map ResultSet Field values to Postalcode
     * @param dbresult: Database ResultSet
     */
    public Postalcode mapResultSet2Entity(ResultSet dbresult) throws SQLException {
        PostalcodePK postalcodePK = null;
        Postalcode postalcode;
        if(dbresult==null) {
            postalcode = new Postalcode(postalcodePK);
        } else {
            try {
                postalcodePK = new PostalcodePK(dbresult.getString("countrycode"), dbresult.getString("postalcode"));
                postalcode = new Postalcode(postalcodePK);
                postalcode.initArealevel3PK(new Arealevel3PK(dbresult.getString("countrycode"), dbresult.getString("al1code"), dbresult.getString("al2code"), dbresult.getString("al3code")));
                if(dbresult.wasNull()) postalcode.setArealevel3PK(null);                
                Object o_location = dbresult.getObject("location");
                if(o_location!=null) {
                    piShape c_location = new psqlGeometry((PGgeometry)o_location);
                    postalcode.initLocation(c_location.abstractclone());
                }
                Object o_bounds = dbresult.getObject("bounds");
                if(o_bounds!=null) {
                    piShape c_bounds = new psqlGeometry((PGgeometry)o_bounds);
                    postalcode.initBounds(c_bounds.abstractclone());
                }
                Object o_viewport = dbresult.getObject("viewport");
                if(o_viewport!=null) {
                    piShape c_viewport = new psqlGeometry((PGgeometry)o_viewport);
                    postalcode.initViewport(c_viewport.abstractclone());
                }
                postalcode.initApproximate(dbresult.getBoolean("approximate"));
            }
            catch(SQLException sqle) {
                throw sqle;
            }
        }
        this.loadExtra(dbresult, postalcode);
        return postalcode;
    }

    /**
     * create new empty Postalcode object
     * @return empty IPostalcode
     */
    public IPostalcode newPostalcode() {
    	return new Postalcode();
    }
    
    /**
     * create new empty Postalcode object
     * create new primary key with given parameters
     * @return IPostalcode with primary key
     */
    public IPostalcode newPostalcode(java.lang.String countrycode, java.lang.String postalcode) {
        return new Postalcode(countrycode, postalcode);
    }

    /**
     * create new empty Postalcode object with given primary key
     * @param postalcodePK: primary key for Postalcode
     * @return IPostalcode with primary key
     */
    public IPostalcode newPostalcode(IPostalcodePK postalcodePK) {
        return new Postalcode((PostalcodePK)postalcodePK);
    }

    /**
     * create new empty primary key
     * @return empty PostalcodePK
     */
    public IPostalcodePK newPostalcodePK() {
        return new PostalcodePK();
    }

    /**
     * create new primary key with given parameters
     * @return new IPostalcodePK
     */
    public IPostalcodePK newPostalcodePK(java.lang.String countrycode, java.lang.String postalcode) {
        return new PostalcodePK(countrycode, postalcode);
    }

    /**
     * get all Postalcode objects from database
     * @return ArrayList of Postalcode objects
     * @throws DBException
     */
    public ArrayList getPostalcodes() throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Postalcode.SQLSelectAll);
        } else return new ArrayList();
    }

    /**
     * search Postalcode for primary key
     * @param postalcodePK: Postalcode primary key
     * @return Postalcode object
     * @throws DBException
     */
    public Postalcode getPostalcode(IPostalcodePK postalcodePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return (Postalcode)super.getEntity((PostalcodePK)postalcodePK);
        } else return null;
    }

    public ArrayList searchpostalcodes(IPostalcodesearch search) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return this.search(search);
        } else return new ArrayList();
    }

    public ArrayList searchpostalcodes(IPostalcodesearch search, String orderby) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return this.search(search, orderby);
        } else return new ArrayList();
    }

    /**
     * Search postalcode in database for postalcodePK:
     * @param postalcodePK: Postalcode Primary Key, only valid for the initialized Entity
     * @return true if found in database
     * @throws DBException
     */
    public boolean getPostalcodeExists(IPostalcodePK postalcodePK) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
	        return super.getEntityExists((PostalcodePK)postalcodePK);
        } else return false;
    }

    /**
     * try to insert Postalcode in database
     * @param film: Postalcode object
     * @throws DBException
     */
    public void insertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.insertEntity(postalcode);
        }
    }

    /**
     * check if PostalcodePK exists
     * insert if not, update if found
     * do not commit transaction
     * @param film: Postalcode object
     * @throws DBException
     */
    public void insertupdatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        if(this.getPostalcodeExists(postalcode.getPrimaryKey())) {
            super.updateEntity(postalcode);
        } else {
            super.insertEntity(postalcode);
        }
    }

    /**
     * try to update Postalcode in database
     * @param film: Postalcode object
     * @throws DBException
     */
    public void updatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.updateEntity(postalcode);
        }
    }

    /**
     * try to delete Postalcode in database
     * @param film: Postalcode object
     * @throws DBException
     */
    public void deletePostalcode(IPostalcode postalcode) throws DBException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            cascadedeletePostalcode(postalcode.getOwnerobject(), postalcode.getPrimaryKey());
            super.deleteEntity(postalcode);
        }
    }

    /**
     * check data rules in Postalcode, throw DataException with customized message if rules do not apply
     * @param film: Postalcode object
     * @throws DataException
     * @throws DBException
     */
    public void checkDATA(IPostalcode postalcode) throws DataException, DBException {
        StringBuffer message = new StringBuffer();
        //Primary key
        //Primary key
	//if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getCountrycode()!=null && postalcode.getArealevel3PK().getCountrycode().length()>IPostalcode.SIZE_COUNTRYCODE) {
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getCountrycode()!=null && postalcode.getArealevel3PK().getCountrycode().length()>IPostalcode.SIZE_COUNTRYCODE) {
            message.append("Countrycode is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_COUNTRYCODE + "\n");
        }
	//if(postalcode.getArealevel3PK()==null || postalcode.getArealevel3PK().getCountrycode()==null) {
        if(postalcode.getArealevel3PK()==null || postalcode.getArealevel3PK().getCountrycode()==null) {
            message.append("Countrycode mag niet leeg zijn.\n");
        }
	//if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl1code()!=null && postalcode.getArealevel3PK().getAl1code().length()>IPostalcode.SIZE_AL1CODE) {
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl1code()!=null && postalcode.getArealevel3PK().getAl1code().length()>IPostalcode.SIZE_AL1CODE) {
            message.append("Al1code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL1CODE + "\n");
        }
	//if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl2code()!=null && postalcode.getArealevel3PK().getAl2code().length()>IPostalcode.SIZE_AL2CODE) {
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl2code()!=null && postalcode.getArealevel3PK().getAl2code().length()>IPostalcode.SIZE_AL2CODE) {
            message.append("Al2code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL2CODE + "\n");
        }
	//if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl3code()!=null && postalcode.getArealevel3PK().getAl3code().length()>IPostalcode.SIZE_AL3CODE) {
        if(postalcode.getArealevel3PK()!=null && postalcode.getArealevel3PK().getAl3code()!=null && postalcode.getArealevel3PK().getAl3code().length()>IPostalcode.SIZE_AL3CODE) {
            message.append("Al3code is langer dan toegestaan. Max aantal karakters: " + IPostalcode.SIZE_AL3CODE + "\n");
        }

        if(message.length()>0) {
            throw new DataException(message.toString());
        }
    }
        
    /**
     * delete all records in tables where postalcodePK is used in a primary key
     * @param postalcodePK: Postalcode primary key
     */
    public void cascadedeletePostalcode(String senderobject, IPostalcodePK postalcodePK) {
        BLlocality bllocality = new BLlocality(this);
        bllocality.delete4postalcode(senderobject, postalcodePK);
    }

    /**
     * @param arealevel3PK: foreign key for Arealevel3
     * @delete all Postalcode Entity objects for Arealevel3 in database
     * @throws film.general.exception.CustomException
     */
    public void delete4arealevel3(String senderobject, IArealevel3PK arealevel3PK) {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            super.addStatement(senderobject, Postalcode.SQLDelete4arealevel3, arealevel3PK.getKeyFields());
        }
    }

    /**
     * @param arealevel3PK: foreign key for Arealevel3
     * @return all Postalcode Entity objects for Arealevel3
     * @throws film.general.exception.CustomException
     */
    public ArrayList getPostalcodes4arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            return getMapper().loadEntityVector(this, Postalcode.SQLSelect4arealevel3, arealevel3PK.getKeyFields());
        } else return new ArrayList();
    }
    /**
     * @param localityPK: parent Locality for child object Postalcode Entity
     * @return child Postalcode Entity object
     * @throws film.general.exception.CustomException
     */
    public IPostalcode getLocality(ILocalityPK localityPK) throws CustomException {
        if(!this.getLogginrequired() || this.getLogginrequired() && this.isAuthenticated()) {
            PostalcodePK postalcodePK = new PostalcodePK(localityPK.getCountrycode(), localityPK.getPostalcode());
            return this.getPostalcode(postalcodePK);
        } else return null;
    }


    /**
     * get all Postalcode objects for sqlparameters
     * @return ArrayList of Postalcode objects
     * @throws DBException
     */
    public ArrayList getPostalcodes(Object[][] sqlparameters, String andoroperator, String sortlist, String sortoperator) throws DBException {
        String sql =  Postalcode.SQLSelect;
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
     * delete all Postalcode objects for sqlparameters
     * @throws DBException
     */
    public void delPostalcode(String senderobject, Object[][] sqlparameters, String andoroperator) throws DBException {
        String sql =  "Delete from " + Postalcode.table;
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
