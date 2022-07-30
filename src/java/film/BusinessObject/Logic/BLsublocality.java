/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 6.4.2013 16:14
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.ISublocality;
import film.logicentity.Sublocality;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Bsublocality;
import film.conversion.entity.EMsublocality;
import general.exception.DataException;
import film.interfaces.entity.pk.ILocalityPK;
import general.exception.CustomException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLsublocality extends Bsublocality {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLsublocality(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLsublocality(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getSublocalitys4locality(ILocalityPK localityPK) throws CustomException {
        return this.getEntities(EMsublocality.SQLSelect4locality, localityPK.getSQLprimarykey());
    }        

    public void insertcheckSublocality(SQLTqueue transactionqueue, ISublocality sublocality) throws DBException, DataException {
        if(this.getSublocality(sublocality.getPrimaryKey())==null) {
            insertSublocality(transactionqueue, sublocality);
        }
    }
}
