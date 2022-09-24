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

public class Geography_columns_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private BLgeography_columns blgeography_columns = new BLgeography_columns(sqlreader);
    
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

