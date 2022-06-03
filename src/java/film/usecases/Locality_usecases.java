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
import film.logicentity.Locality;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Locality_usecases {

    private boolean loggedin = false;
    private BLlocality bllocality = new BLlocality();
    
    public Locality_usecases() {
        this(false);
    }
    
    public Locality_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        bllocality.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public ArrayList<Locality> get_for_country(ICountryPK countryPK) throws DBException, CustomException {
        return bllocality.getLocalitys4country(countryPK);
    }

    public ArrayList<Locality> get_for_arealevel1(IArealevel1PK arealevel1PK) throws DBException, CustomException {
        return bllocality.getLocalitys4arealevel1(arealevel1PK);
    }

    public ArrayList<Locality> get_for_arealevel2(IArealevel2PK arealevel2PK) throws DBException, CustomException {
        return bllocality.getLocalitys4arealevel2(arealevel2PK);
    }

    public ArrayList<Locality> get_for_arealevel3(IArealevel3PK arealevel3PK) throws DBException, CustomException {
        return bllocality.getLocalitys4arealevel3(arealevel3PK);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return bllocality.count();
    }
    
    public ArrayList<Locality> get_all() throws DBException {
        return bllocality.getLocalitys();
    }
    
    public boolean getLocalityExists(ILocalityPK localityPK) throws DBException {
        return bllocality.getEntityExists(localityPK);
    }
    
    public Locality get_locality_by_primarykey(ILocalityPK localityPK) throws DBException {
        return bllocality.getLocality(localityPK);
    }

    public ArrayList<Locality> get_locality_with_foreignkey_postalcode(IPostalcodePK postalcodePK) throws CustomException {
        return bllocality.getLocalitys4postalcode(postalcodePK);
    }
    
    public Locality get_locality_with_externalforeignkey_sublocality(ISublocalityPK sublocalityPK) throws CustomException {
        return bllocality.getSublocality(sublocalityPK);
    }
    
    public ArrayList<Locality> search_locality(ILocalitysearch localitysearch) throws CustomException {
        return bllocality.search(localitysearch);
    }
    
    public long search_locality_count(ILocalitysearch localitysearch) throws CustomException {
        return bllocality.searchcount(localitysearch);
    }

    public void secureinsertLocality(ILocality locality) throws DBException, DataException {
        bllocality.secureinsertLocality(locality);
    }

    public void secureupdateLocality(ILocality locality) throws DBException, DataException {
        bllocality.secureupdateLocality(locality);
    }

    public void securedeleteLocality(ILocality locality) throws DBException, DataException {
        bllocality.securedeleteLocality(locality);
    }
}

