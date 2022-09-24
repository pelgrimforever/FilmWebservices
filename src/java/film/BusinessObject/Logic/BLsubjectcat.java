/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on :codegenerator_date:
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import BusinessObject.BLtable;
import db.SQLparameters;
import db.SQLreader;
import db.TableBusinessrules;
import film.interfaces.logicentity.ISubjectcat;
import film.logicentity.Subjectcat;
import film.BusinessObject.table.Bsubjectcat;
import film.conversion.entity.EMsubjectcat;
import general.exception.DBException;
import general.exception.DataException;
import java.util.ArrayList;

public class BLsubjectcat extends Bsubjectcat {
//Metacoder: NO AUTHOMATIC UPDATE
    private boolean isprivatetable = false; //set this to true if only a loggin account has access to this data
	
    public BLsubjectcat(SQLreader sqlreader) {
        super(sqlreader);
        setLogginrequired(isprivatetable);
    }

    public BLsubjectcat(TableBusinessrules businessrules) {
        super(businessrules);
        tableio.setLogginrequired(isprivatetable);
    }

    public ArrayList getSubjectcats1() throws DBException {
        Object[][] parameter = { { "catno", 1 } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMsubjectcat.SQLSelectCatno, parameters);
    }

    public ArrayList getSubjectcats2() throws DBException {
        Object[][] parameter = { { "catno", 2 } };
        SQLparameters parameters = new SQLparameters(parameter);
        return this.getEntities(EMsubjectcat.SQLSelectCatno, parameters);
    }

}
