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
import film.logicview.View_subjects_for_film;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_subjects_for_film_usecases {

    private boolean loggedin = false;
    private BLview_subjects_for_film blview_subjects_for_film = new BLview_subjects_for_film();
    
    public View_subjects_for_film_usecases() {
        this(false);
    }
    
    public View_subjects_for_film_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_subjects_for_film.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_subjects_for_film> get_all() throws DBException {
        return blview_subjects_for_film.getView_subjects_for_films();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

