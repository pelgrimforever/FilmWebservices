/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 9.3.2016 11:11
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import db.SQLreader;
import general.exception.DBException;
import film.BusinessObject.view.Bview_countryphotocount;
import film.conversion.entity.EMview_countryphotocount;
import film.conversion.entity.EMview_publiccountryphotocount;
import java.util.ArrayList;

public class BLview_countryphotocount extends Bview_countryphotocount {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_countryphotocount(SQLreader sqlreader) {
        super(sqlreader);
    }

    @Override
    public ArrayList getView_countryphotocounts() throws DBException {
        return viewio.getEntities(EMview_publiccountryphotocount.SQLSelectAll);
    }

    public ArrayList getAllView_countryphotocounts() throws DBException {
        return viewio.getEntities(EMview_countryphotocount.SQLSelectAll);
    }
}
