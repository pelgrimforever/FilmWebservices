/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IArealevel2;
import film.logicentity.Arealevel2;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Barealevel2;
import film.conversion.entity.EMarealevel2;
import general.exception.DataException;
import film.interfaces.entity.pk.IArealevel1PK;
import general.exception.CustomException;
import java.util.ArrayList;

public class BLarealevel2 extends Barealevel2 {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLarealevel2(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLarealevel2(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getArealevel2s4arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return this.getEntities(EMarealevel2.SQLSelect4arealevel1, arealevel1PK.getSQLprimarykey());
    }
    
    @Override
    public void insertArealevel2(SQLTqueue transactionqueue,IArealevel2 arealevel2) throws DBException, DataException {
        if(arealevel2.getName()==null) arealevel2.setName(arealevel2.getPrimaryKey().getAl2code());
        super.insertArealevel2(transactionqueue,arealevel2);
    }
}
