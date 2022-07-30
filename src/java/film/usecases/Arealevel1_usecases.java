/*
 * Generated on 27.6.2022 16:45
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
import film.logicentity.Arealevel1;
import film.logicview.*;
import film.usecases.custom.*;
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
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLarealevel1 blarealevel1 = new BLarealevel1(sqlreader);
    
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
        return blarealevel1.getArealevel1Exists(arealevel1PK);
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

    public void insertArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel1.insertArealevel1(tq, arealevel1);
        sqlwriter.Commit2DB(tq);
    }

    public void updateArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel1.updateArealevel1(tq, arealevel1);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteArealevel1(IArealevel1 arealevel1) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel1.deleteArealevel1(tq, arealevel1);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Country(ICountryPK countryPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel1.delete4country(tq, countryPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

