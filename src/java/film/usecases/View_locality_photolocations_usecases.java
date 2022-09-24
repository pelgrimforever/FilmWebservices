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

public class View_locality_photolocations_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_locality_photolocations blview_locality_photolocations = new BLview_locality_photolocations(sqlreader);
    
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

