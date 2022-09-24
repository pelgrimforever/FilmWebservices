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
import film.logicentity.Sublocality;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Sublocality_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsublocality blsublocality = new BLsublocality(sqlreader);
    
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
        return blsublocality.getSublocalityExists(sublocalityPK);
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

    public void insertSublocality(ISublocality sublocality) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsublocality.insertSublocality(tq, sublocality);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSublocality(ISublocality sublocality) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsublocality.updateSublocality(tq, sublocality);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSublocality(ISublocality sublocality) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsublocality.deleteSublocality(tq, sublocality);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Locality(ILocalityPK localityPK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsublocality.delete4locality(tq, localityPK);
        sqlwriter.Commit2DB(tq);
    }
    
}

