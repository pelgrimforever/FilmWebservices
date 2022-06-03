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
import film.logicview.View_photodates;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_photodates_usecases {

    private boolean loggedin = false;
    private BLview_photodates blview_photodates = new BLview_photodates();
    
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

