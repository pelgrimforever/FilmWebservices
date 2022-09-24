/**
 * @author Franky Laseure
 */
package film.BusinessObject.Logic;

import db.SQLreader;
import db.ViewBusinessrules;
import db.ViewIO;
import film.conversion.entity.EMviewdescriptions;

public class BLviewdescriptions extends ViewBusinessrules {
	
    public BLviewdescriptions(SQLreader sqlreader) {
        super(new ViewIO(sqlreader, new EMviewdescriptions()));
    }
}
