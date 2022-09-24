/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 31.11.2012 13:49
 * @author Franky Laseure
 */

package film.BusinessObject.Logic;

import db.SQLreader;
import film.BusinessObject.view.Bview_backupstatus;
import film.conversion.entity.EMview_backupstatus;
import general.exception.DBException;
import java.util.ArrayList;

public class BLview_backupstatus extends Bview_backupstatus {
//Metacoder: NO AUTHOMATIC UPDATE
	
    public BLview_backupstatus(SQLreader sqlreader) {
        super(sqlreader);
    }
    
    public ArrayList getView_backupstatus_Allbackup() throws DBException {
        return viewio.getEntities(EMview_backupstatus.SQLSelect4AllBackup);
    }
    
}
