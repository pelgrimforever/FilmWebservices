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
import film.logicentity.Country;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Country_usecases {

    private boolean loggedin = false;
    private BLcountry blcountry = new BLcountry();
    
    public Country_usecases() {
        this(false);
    }
    
    public Country_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blcountry.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
    public void insert_country_with_check(ICountry country) throws DBException, DataException {
        blcountry.insertcheckCountry(country);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcountry.count();
    }
    
    public ArrayList<Country> get_all() throws DBException {
        return blcountry.getCountrys();
    }
    
    public boolean getCountryExists(ICountryPK countryPK) throws DBException {
        return blcountry.getEntityExists(countryPK);
    }
    
    public Country get_country_by_primarykey(ICountryPK countryPK) throws DBException {
        return blcountry.getCountry(countryPK);
    }

    public Country get_country_with_externalforeignkey_arealevel1(IArealevel1PK arealevel1PK) throws CustomException {
        return blcountry.getArealevel1(arealevel1PK);
    }
    
    public ArrayList<Country> search_country(ICountrysearch countrysearch) throws CustomException {
        return blcountry.search(countrysearch);
    }
    
    public long search_country_count(ICountrysearch countrysearch) throws CustomException {
        return blcountry.searchcount(countrysearch);
    }

    public void secureinsertCountry(ICountry country) throws DBException, DataException {
        blcountry.secureinsertCountry(country);
    }

    public void secureupdateCountry(ICountry country) throws DBException, DataException {
        blcountry.secureupdateCountry(country);
    }

    public void securedeleteCountry(ICountry country) throws DBException, DataException {
        blcountry.securedeleteCountry(country);
    }
}

