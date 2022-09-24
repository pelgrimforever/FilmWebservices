/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.gis.shape.piPoint;
import film.interfaces.searchentity.*;
import film.logicview.*;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.logicentity.*;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

public class View_backupstatus_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_backupstatus blview_backupstatus = new BLview_backupstatus(sqlreader);
    
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

