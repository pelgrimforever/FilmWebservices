/*
 * BLview_backupstatus.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.11.2012 13:49
 *
 */

package film.BusinessObject.Logic;

import film.BusinessObject.view.Bview_backupstatus;
import film.conversion.entity.EMview_backupstatus;
import general.exception.DBException;
import java.util.ArrayList;

/**
 * Business Logic Entity class BLview_backupstatus
 *
 * Class for manipulating data- and database objects
 * for View View_backupstatus and direct related data
 * This class is only generated once
 * Implement here all additional business logic
 *
 * @author Franky Laseure
 */
public class BLview_backupstatus extends Bview_backupstatus {
//Metacoder: NO AUTHOMATIC UPDATE
	
    /**
     * Constructor, sets View_backupstatus as default Entity
     */
    public BLview_backupstatus() {
    }
    
    public ArrayList getView_backupstatus_Allbackup() throws DBException {
        return this.getEntities(EMview_backupstatus.SQLSelect4AllBackup);
    }
    
}
