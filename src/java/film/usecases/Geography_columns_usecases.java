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
import film.logicview.Geography_columns;
import general.exception.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Geography_columns_usecases {

    private boolean loggedin = false;
    private BLgeography_columns blgeography_columns = new BLgeography_columns();
    
    public Geography_columns_usecases() {
        this(false);
    }
    
    public Geography_columns_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blgeography_columns.setAuthenticated(loggedin);
    }
    
    public ArrayList<Geography_columns> get_all() throws DBException {
        return blgeography_columns.getGeography_columnss();
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

}

