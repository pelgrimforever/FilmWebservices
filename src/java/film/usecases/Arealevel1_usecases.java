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
import film.logicentity.Arealevel1;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Arealevel1_usecases {

    private boolean loggedin = false;
    private BLarealevel1 blarealevel1 = new BLarealevel1();
    
    public Arealevel1_usecases() {
        this(false);
    }
    
    public Arealevel1_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blarealevel1.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blarealevel1.count();
    }
    
    public ArrayList<Arealevel1> get_all() throws DBException {
        return blarealevel1.getArealevel1s();
    }
    
    public boolean getArealevel1Exists(IArealevel1PK arealevel1PK) throws DBException {
        return blarealevel1.getEntityExists(arealevel1PK);
    }
    
    public Arealevel1 get_arealevel1_by_primarykey(IArealevel1PK arealevel1PK) throws DBException {
        return blarealevel1.getArealevel1(arealevel1PK);
    }

    public ArrayList<Arealevel1> get_arealevel1_with_foreignkey_country(ICountryPK countryPK) throws CustomException {
        return blarealevel1.getArealevel1s4country(countryPK);
    }
    
    public Arealevel1 get_arealevel1_with_externalforeignkey_arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return blarealevel1.getArealevel2(arealevel2PK);
    }
    
    public ArrayList<Arealevel1> search_arealevel1(IArealevel1search arealevel1search) throws CustomException {
        return blarealevel1.search(arealevel1search);
    }
    
    public long search_arealevel1_count(IArealevel1search arealevel1search) throws CustomException {
        return blarealevel1.searchcount(arealevel1search);
    }

    public void secureinsertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        blarealevel1.secureinsertArealevel1(arealevel1);
    }

    public void secureupdateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        blarealevel1.secureupdateArealevel1(arealevel1);
    }

    public void securedeleteArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        blarealevel1.securedeleteArealevel1(arealevel1);
    }
}

