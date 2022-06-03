/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import film.interfaces.searchentity.*;
import film.logicview.*;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.logicview.View_backupstatus;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_backupstatus_usecases {

    private boolean loggedin = false;
    private BLview_backupstatus blview_backupstatus = new BLview_backupstatus();
    
    public View_backupstatus_usecases() {
        this(false);
    }
    
    public View_backupstatus_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_backupstatus.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_backupstatus> get_all() throws DBException {
        return blview_backupstatus.getView_backupstatuss();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_backupstatus> getView_backupstatus_Allbackup() throws DBException {
        return blview_backupstatus.getView_backupstatus_Allbackup();
    }
//Custom code, do not change this line   

}

