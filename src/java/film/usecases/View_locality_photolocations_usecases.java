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
import film.logicview.View_locality_photolocations;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_locality_photolocations_usecases {

    private boolean loggedin = false;
    private BLview_locality_photolocations blview_locality_photolocations = new BLview_locality_photolocations();
    
    public View_locality_photolocations_usecases() {
        this(false);
    }
    
    public View_locality_photolocations_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_locality_photolocations.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_locality_photolocations> get_all() throws DBException {
        return blview_locality_photolocations.getView_locality_photolocationss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

