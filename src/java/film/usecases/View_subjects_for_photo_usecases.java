/*
 * Generated on 27.6.2022 16:45
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

/**
 * @author Franky Laseure
 */
public class View_subjects_for_photo_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLview_subjects_for_photo blview_subjects_for_photo = new BLview_subjects_for_photo(sqlreader);
    
    public View_subjects_for_photo_usecases() {
        this(false);
    }
    
    public View_subjects_for_photo_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_subjects_for_photo.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_subjects_for_photo> get_all() throws DBException {
        return blview_subjects_for_photo.getView_subjects_for_photos();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

