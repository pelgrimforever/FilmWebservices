/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.4.2013 10:18
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import general.exception.DBException;
import film.interfaces.logicentity.IArealevel3;
import film.logicentity.Arealevel3;
import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.BusinessObject.table.Barealevel3;
import film.conversion.entity.EMarealevel3;
import general.exception.DataException;
import film.interfaces.entity.pk.IArealevel2PK;
import general.exception.CustomException;
import java.util.ArrayList;

public class BLarealevel3 extends Barealevel3 {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLarealevel3(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLarealevel3(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getArealevel3s4arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return this.getEntities(EMarealevel3.SQLSelect4arealevel2, arealevel2PK.getSQLprimarykey());
    }
    
    @Override
    public void insertArealevel3(SQLTqueue transactionqueue, IArealevel3 arealevel3) throws DBException, DataException {
        if(arealevel3.getName()==null) arealevel3.setName(arealevel3.getPrimaryKey().getAl3code());
        super.insertArealevel3(transactionqueue, arealevel3);
    }
}
