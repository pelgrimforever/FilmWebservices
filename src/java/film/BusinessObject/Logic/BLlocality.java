/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ILocality;
import film.logicentity.Locality;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Blocality;
import film.conversion.entity.EMlocality;
import general.exception.DataException;
import film.interfaces.entity.pk.IArealevel1PK;
import film.interfaces.entity.pk.IArealevel2PK;
import film.interfaces.entity.pk.IArealevel3PK;
import film.interfaces.entity.pk.ICountryPK;
import general.exception.CustomException;
import java.util.ArrayList;

public class BLlocality extends Blocality {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLlocality(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLlocality(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getLocalitys4country(ICountryPK countryPK) throws CustomException {
        return this.getEntities(EMlocality.SQLSelect4countryPK, countryPK.getSQLprimarykey());
    }
    
    public ArrayList getLocalitys4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return this.getEntities(EMlocality.SQLSelect4arealevel1PK, arealevel1PK.getSQLprimarykey());
    }
    
    public ArrayList getLocalitys4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return this.getEntities(EMlocality.SQLSelect4arealevel2PK, arealevel2PK.getSQLprimarykey());
    }
    
    public ArrayList getLocalitys4arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return this.getEntities(EMlocality.SQLSelect4arealevel3PK, arealevel3PK.getSQLprimarykey());
    }    

    public void insertcheckLocality(SQLTqueue transactionqueue, ILocality locality) throws DBException, DataException {
        if(!this.getLocalityExists(locality.getPrimaryKey()))
            insertLocality(transactionqueue, locality);
    }
}
