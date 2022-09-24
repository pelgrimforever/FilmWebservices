/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IArealevel1;
import film.logicentity.Arealevel1;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Barealevel1;
import film.conversion.entity.EMarealevel1;
import general.exception.DataException;
import film.interfaces.entity.pk.ICountryPK;
import general.exception.CustomException;
import java.util.ArrayList;

public class BLarealevel1 extends Barealevel1 {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLarealevel1(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLarealevel1(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getArealevel1s4country(ICountryPK countryPK) throws CustomException {
        return this.getEntities(EMarealevel1.SQLSelect4country, countryPK.getSQLprimarykey());
    }
    
    @Override
    public void insertArealevel1(SQLTqueue transactionqueue, IArealevel1 arealevel1) throws DBException, DataException {
        if(arealevel1.getName()==null) arealevel1.setName(arealevel1.getPrimaryKey().getAl1code());
        super.insertArealevel1(transactionqueue, arealevel1);
    }
}
