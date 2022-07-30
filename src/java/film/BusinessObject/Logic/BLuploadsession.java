/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLTqueue;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.IUploadsession;
import film.logicentity.Uploadsession;
import film.BusinessObject.table.Buploadsession;
import film.conversion.entity.EMuploadsession;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

/**
 * @author Franky Laseure
 */
public class BLuploadsession extends Buploadsession {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = true; //set this to true if only a loggin account has access to this data
	
    public BLuploadsession(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLuploadsession(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    @Override
    public ArrayList getUploadsessions() throws DBException {
        return this.getEntities(EMuploadsession.SQLSelectAllsorded);
    }

    public void insertCompletesession(SQLTqueue transactionqueue, ArrayList uploadsessions) throws DBException, DataException {
        //if Uploadsession table is empty, insert records
        //else only update
        String sql = "select count(distinct tablecount.*) as count from uploadsession as tablecount";
        long count = this.count(sql, null);
        if(count==0) {
            Uploadsession uploadsession;
            for(int i=0; i<uploadsessions.size(); i++) {
                uploadsession = (Uploadsession)uploadsessions.get(i);
                //allways force update of filmgroupid
                uploadsession.setFilmgroupid(uploadsession.getFilmgroupid());
                insertUploadsession(transactionqueue, uploadsession);
            }
        } else {
            //Delete all lines first
            Uploadsession uploadsession;
            for(int i=0; i<uploadsessions.size(); i++) {
                uploadsession = (Uploadsession)uploadsessions.get(i);
                //allways force update of filmgroupid
                uploadsession.setFilmgroupid(uploadsession.getFilmgroupid());
                updateUploadsession(transactionqueue, uploadsession);
            }
        }
    }

}
