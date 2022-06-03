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
import film.logicentity.Sublocality;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Sublocality_usecases {

    private boolean loggedin = false;
    private BLsublocality blsublocality = new BLsublocality();
    
    public Sublocality_usecases() {
        this(false);
    }
    
    public Sublocality_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsublocality.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsublocality.count();
    }
    
    public ArrayList<Sublocality> get_all() throws DBException {
        return blsublocality.getSublocalitys();
    }
    
    public boolean getSublocalityExists(ISublocalityPK sublocalityPK) throws DBException {
        return blsublocality.getEntityExists(sublocalityPK);
    }
    
    public Sublocality get_sublocality_by_primarykey(ISublocalityPK sublocalityPK) throws DBException {
        return blsublocality.getSublocality(sublocalityPK);
    }

    public ArrayList<Sublocality> get_sublocality_with_foreignkey_locality(ILocalityPK localityPK) throws CustomException {
        return blsublocality.getSublocalitys4locality(localityPK);
    }
    
    public Sublocality get_sublocality_with_externalforeignkey_route(IRoutePK routePK) throws CustomException {
        return blsublocality.getRoute(routePK);
    }
    
    public ArrayList<Sublocality> search_sublocality(ISublocalitysearch sublocalitysearch) throws CustomException {
        return blsublocality.search(sublocalitysearch);
    }
    
    public long search_sublocality_count(ISublocalitysearch sublocalitysearch) throws CustomException {
        return blsublocality.searchcount(sublocalitysearch);
    }

    public void secureinsertSublocality(ISublocality sublocality) throws DBException, DataException {
        blsublocality.secureinsertSublocality(sublocality);
    }

    public void secureupdateSublocality(ISublocality sublocality) throws DBException, DataException {
        blsublocality.secureupdateSublocality(sublocality);
    }

    public void securedeleteSublocality(ISublocality sublocality) throws DBException, DataException {
        blsublocality.securedeleteSublocality(sublocality);
    }
}

