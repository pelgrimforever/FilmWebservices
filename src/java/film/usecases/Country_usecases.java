/*
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.usecases;

import db.*;
import data.conversion.JSONConversion;
import data.interfaces.db.Filedata;
import data.gis.shape.piPoint;
import film.BusinessObject.Logic.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.searchentity.*;
import film.interfaces.entity.pk.*;
import film.logicentity.*;
import film.logicentity.Country;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Country_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLcountry blcountry = new BLcountry(sqlreader);
    
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
        SQLTqueue tq = new SQLTqueue();
        blcountry.insertupdateCountry(tq, country);
        sqlwriter.Commit2DB(tq);
    }
//Custom code, do not change this line   

    public long count() throws DBException {
        return blcountry.count();
    }
    
    public ArrayList<Country> get_all() throws DBException {
        return blcountry.getCountrys();
    }
    
    public boolean getCountryExists(ICountryPK countryPK) throws DBException {
        return blcountry.getCountryExists(countryPK);
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

    public void insertCountry(ICountry country) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcountry.insertCountry(tq, country);
        sqlwriter.Commit2DB(tq);
    }

    public void updateCountry(ICountry country) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcountry.updateCountry(tq, country);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteCountry(ICountry country) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blcountry.deleteCountry(tq, country);
        sqlwriter.Commit2DB(tq);
    }

}

