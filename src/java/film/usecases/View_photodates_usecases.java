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

public class View_photodates_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_photodates blview_photodates = new BLview_photodates(sqlreader);
    
    public View_photodates_usecases() {
        this(false);
    }
    
    public View_photodates_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_photodates.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_photodates> get_all() throws DBException {
        return blview_photodates.getView_photodatess();
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<View_photodates> get_private_photodates(boolean privateaccess) throws DBException {
        return blview_photodates.getView_photodatess(privateaccess);
    }
//Custom code, do not change this line   

}

