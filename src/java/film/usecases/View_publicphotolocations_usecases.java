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
import film.logicview.View_publicphotolocations;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_publicphotolocations_usecases {

    private boolean loggedin = false;
    private BLview_publicphotolocations blview_publicphotolocations = new BLview_publicphotolocations();
    
    public View_publicphotolocations_usecases() {
        this(false);
    }
    
    public View_publicphotolocations_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_publicphotolocations.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_publicphotolocations> get_all() throws DBException {
        return blview_publicphotolocations.getView_publicphotolocationss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

