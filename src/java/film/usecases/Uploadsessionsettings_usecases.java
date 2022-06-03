/*
 * Generated on 1.5.2022 20:24
 */

package film.usecases;

import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.Uploadsessionsettings;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Uploadsessionsettings_usecases {

    private boolean loggedin = false;
    private BLuploadsessionsettings bluploadsessionsettings = new BLuploadsessionsettings();
    
    public Uploadsessionsettings_usecases() {
        this(false);
    }
    
    public Uploadsessionsettings_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bluploadsessionsettings.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void deleteall() throws DBException, DataException {
        bluploadsessionsettings.deleteall("Uploadsessionsettings_usecases.deleteall");
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bluploadsessionsettings.count();
    }
    
    public ArrayList<Uploadsessionsettings> get_all() throws DBException {
        return bluploadsessionsettings.getUploadsessionsettingss();
    }
    
    public boolean getUploadsessionsettingsExists(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return bluploadsessionsettings.getEntityExists(uploadsessionsettingsPK);
    }
    
    public Uploadsessionsettings get_uploadsessionsettings_by_primarykey(IUploadsessionsettingsPK uploadsessionsettingsPK) throws DBException {
        return bluploadsessionsettings.getUploadsessionsettings(uploadsessionsettingsPK);
    }

    public ArrayList<Uploadsessionsettings> search_uploadsessionsettings(IUploadsessionsettingssearch uploadsessionsettingssearch) throws CustomException {
        return bluploadsessionsettings.search(uploadsessionsettingssearch);
    }
    
    public long search_uploadsessionsettings_count(IUploadsessionsettingssearch uploadsessionsettingssearch) throws CustomException {
        return bluploadsessionsettings.searchcount(uploadsessionsettingssearch);
    }

    public void secureinsertUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        bluploadsessionsettings.secureinsertUploadsessionsettings(uploadsessionsettings);
    }

    public void secureupdateUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        bluploadsessionsettings.secureupdateUploadsessionsettings(uploadsessionsettings);
    }

    public void securedeleteUploadsessionsettings(IUploadsessionsettings uploadsessionsettings) throws DBException, DataException {
        bluploadsessionsettings.securedeleteUploadsessionsettings(uploadsessionsettings);
    }
}

