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
import film.logicentity.Arealevel2;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Arealevel2_usecases {

    private boolean loggedin = false;
    private BLarealevel2 blarealevel2 = new BLarealevel2();
    
    public Arealevel2_usecases() {
        this(false);
    }
    
    public Arealevel2_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blarealevel2.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blarealevel2.count();
    }
    
    public ArrayList<Arealevel2> get_all() throws DBException {
        return blarealevel2.getArealevel2s();
    }
    
    public boolean getArealevel2Exists(IArealevel2PK arealevel2PK) throws DBException {
        return blarealevel2.getEntityExists(arealevel2PK);
    }
    
    public Arealevel2 get_arealevel2_by_primarykey(IArealevel2PK arealevel2PK) throws DBException {
        return blarealevel2.getArealevel2(arealevel2PK);
    }

    public ArrayList<Arealevel2> get_arealevel2_with_foreignkey_arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return blarealevel2.getArealevel2s4arealevel1(arealevel1PK);
    }
    
    public Arealevel2 get_arealevel2_with_externalforeignkey_arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return blarealevel2.getArealevel3(arealevel3PK);
    }
    
    public ArrayList<Arealevel2> search_arealevel2(IArealevel2search arealevel2search) throws CustomException {
        return blarealevel2.search(arealevel2search);
    }
    
    public long search_arealevel2_count(IArealevel2search arealevel2search) throws CustomException {
        return blarealevel2.searchcount(arealevel2search);
    }

    public void secureinsertArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        blarealevel2.secureinsertArealevel2(arealevel2);
    }

    public void secureupdateArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        blarealevel2.secureupdateArealevel2(arealevel2);
    }

    public void securedeleteArealevel2(IArealevel2 arealevel2) throws DBException, DataException {
        blarealevel2.securedeleteArealevel2(arealevel2);
    }
}

