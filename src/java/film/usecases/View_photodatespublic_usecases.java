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
import film.logicview.View_photodatespublic;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class View_photodatespublic_usecases {

    private boolean loggedin = false;
    private BLview_photodatespublic blview_photodatespublic = new BLview_photodatespublic();
    
    public View_photodatespublic_usecases() {
        this(false);
    }
    
    public View_photodatespublic_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blview_photodatespublic.setAuthenticated(loggedin);
    }
    
    public ArrayList<View_photodatespublic> get_all() throws DBException {
        return blview_photodatespublic.getView_photodatespublics();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

