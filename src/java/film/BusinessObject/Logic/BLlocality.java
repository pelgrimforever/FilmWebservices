/*
 * BLlocality.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 *
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import data.interfaces.db.LogicEntity;
import film.interfaces.logicentity.ILocality;
import film.logicentity.Locality;
import BusinessObject.GeneralEntityObject;
import film.BusinessObject.table.Blocality;
import general.exception.DataException;
import film.interfaces.BusinessObject.IBLlocality;
import film.interfaces.entity.pk.IArealevel1PK;
import film.interfaces.entity.pk.IArealevel2PK;
import film.interfaces.entity.pk.IArealevel3PK;
import film.interfaces.entity.pk.ICountryPK;
import general.exception.CustomException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLlocality
 *
 * Class for manipulating data- and database objects
 * for Entity Locality and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLlocality extends Blocality implements IBLlocality {
//ProjectGenerator: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    /**
     * Constructor, sets Locality as default Entity
     */
    public BLlocality() {
        this.setLogginrequired(isprivatetable);
    }

    /**
     * Constructor, sets Locality as default Entity
     * sets transaction queue from given GeneralObject implementation
     * all transactions will commit at same time
     * @param transactionobject: GeneralObjects that holds the transaction queue
     */
    public BLlocality(GeneralEntityObject transactionobject) {
        super(transactionobject);
        this.setLogginrequired(isprivatetable);
    }

    /**
     * load extra fields from adjusted sql statement
     */
    @Override
    public void loadExtra(ResultSet dbresult, LogicEntity locality) throws SQLException {
        
    }
    
    /**
     * @param countryPK: foreign key for Country
     * @return all Locality Entity objects for countryPK
     * @throws film.general.exception.CustomException
     */
    public ArrayList getLocalitys4country(ICountryPK countryPK) throws CustomException {
        return getMapper().loadEntityVector(this, Locality.SQLSelect4countryPK, countryPK.getKeyFields());
    }
    
    /**
     * @param arealevel1PK: foreign key for Arealevel1
     * @return all Locality Entity objects for arealevel1PK
     * @throws film.general.exception.CustomException
     */
    public ArrayList getLocalitys4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return getMapper().loadEntityVector(this, Locality.SQLSelect4arealevel1PK, arealevel1PK.getKeyFields());
    }
    
    /**
     * @param arealevel2PK: foreign key for Arealevel2
     * @return all Locality Entity objects for arealevel2PK
     * @throws film.general.exception.CustomException
     */
    public ArrayList getLocalitys4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return getMapper().loadEntityVector(this, Locality.SQLSelect4arealevel2PK, arealevel2PK.getKeyFields());
    }
    
    /**
     * @param arealevel3PK: foreign key for Arealevel3
     * @return all Locality Entity objects for arealevel3PK
     * @throws film.general.exception.CustomException
     */
    public ArrayList getLocalitys4arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return getMapper().loadEntityVector(this, Locality.SQLSelect4arealevel3PK, arealevel3PK.getKeyFields());
    }
    
    /**
     * try to insert Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void insertLocality(ILocality locality) throws DBException, DataException {
        trans_insertLocality(locality);
        super.Commit2DB();
    }
    
    /**
     * try to insert Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureinsertLocality(ILocality locality) throws DBException, DataException {
        trans_insertLocality(locality);
        super.Commit2DB();
    }
    
    /**
     * check if Locality exists
     * if not, try to insert Locality in database
     * @param locality: Locality object
     * @throws DBException
     */
    public void insertcheckLocality(ILocality locality) throws DBException, DataException {
        if(this.getLocality(locality.getPrimaryKey())==null) {
            insertLocality(locality);
        }
    }
    
    /**
     * try to update Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void updateLocality(ILocality locality) throws DBException, DataException {
        trans_updateLocality(locality);
        super.Commit2DB();
    }
    
    /**
     * try to update Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void secureupdateLocality(ILocality locality) throws DBException, DataException {
        trans_updateLocality(locality);
        super.Commit2DB();
    }
    
    /**
     * try to delete Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void deleteLocality(ILocality locality) throws DBException {
        trans_deleteLocality(locality);
        super.Commit2DB();
    }

    /**
     * try to delete Locality object in database
     * commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void securedeleteLocality(ILocality locality) throws DBException {
        trans_deleteLocality(locality);
        super.Commit2DB();
    }

    /**
     * try to insert Locality object in database
     * do not commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_insertLocality(ILocality locality) throws DBException, DataException {
        super.checkDATA(locality);
        super.insertLocality((Locality)locality);
    }
    
    /**
     * try to update Locality object in database
     * do not commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     * @throws film.general.exception.DataException
     */
    public void trans_updateLocality(ILocality locality) throws DBException, DataException {
        super.checkDATA(locality);
        super.updateLocality((Locality)locality);
    }
    
    /**
     * try to delete Locality object in database
     * do not commit transaction
     * @param locality: Locality Entity Object
     * @throws film.general.exception.CustomException
     */
    public void trans_deleteLocality(ILocality locality) throws DBException {
        super.deleteLocality((Locality)locality);
    }
}
