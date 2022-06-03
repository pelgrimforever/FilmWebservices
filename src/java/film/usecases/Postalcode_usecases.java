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
import film.logicentity.Postalcode;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Postalcode_usecases {

    private boolean loggedin = false;
    private BLpostalcode blpostalcode = new BLpostalcode();
    
    public Postalcode_usecases() {
        this(false);
    }
    
    public Postalcode_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blpostalcode.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blpostalcode.count();
    }
    
    public ArrayList<Postalcode> get_all() throws DBException {
        return blpostalcode.getPostalcodes();
    }
    
    public boolean getPostalcodeExists(IPostalcodePK postalcodePK) throws DBException {
        return blpostalcode.getEntityExists(postalcodePK);
    }
    
    public Postalcode get_postalcode_by_primarykey(IPostalcodePK postalcodePK) throws DBException {
        return blpostalcode.getPostalcode(postalcodePK);
    }

    public ArrayList<Postalcode> get_postalcode_with_foreignkey_arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        return blpostalcode.getPostalcodes4arealevel3(arealevel3PK);
    }
    
    public Postalcode get_postalcode_with_externalforeignkey_locality(ILocalityPK localityPK) throws CustomException {
        return blpostalcode.getLocality(localityPK);
    }
    
    public ArrayList<Postalcode> search_postalcode(IPostalcodesearch postalcodesearch) throws CustomException {
        return blpostalcode.search(postalcodesearch);
    }
    
    public long search_postalcode_count(IPostalcodesearch postalcodesearch) throws CustomException {
        return blpostalcode.searchcount(postalcodesearch);
    }

    public void secureinsertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        blpostalcode.secureinsertPostalcode(postalcode);
    }

    public void secureupdatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        blpostalcode.secureupdatePostalcode(postalcode);
    }

    public void securedeletePostalcode(IPostalcode postalcode) throws DBException, DataException {
        blpostalcode.securedeletePostalcode(postalcode);
    }
}

