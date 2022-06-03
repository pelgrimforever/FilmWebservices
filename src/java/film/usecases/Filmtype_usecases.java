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
import film.logicentity.Filmtype;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Filmtype_usecases {

    private boolean loggedin = false;
    private BLfilmtype blfilmtype = new BLfilmtype();
    
    public Filmtype_usecases() {
        this(false);
    }
    
    public Filmtype_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blfilmtype.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blfilmtype.count();
    }
    
    public ArrayList<Filmtype> get_all() throws DBException {
        return blfilmtype.getFilmtypes();
    }
    
    public boolean getFilmtypeExists(IFilmtypePK filmtypePK) throws DBException {
        return blfilmtype.getEntityExists(filmtypePK);
    }
    
    public Filmtype get_filmtype_by_primarykey(IFilmtypePK filmtypePK) throws DBException {
        return blfilmtype.getFilmtype(filmtypePK);
    }

    public ArrayList<Filmtype> search_filmtype(IFilmtypesearch filmtypesearch) throws CustomException {
        return blfilmtype.search(filmtypesearch);
    }
    
    public long search_filmtype_count(IFilmtypesearch filmtypesearch) throws CustomException {
        return blfilmtype.searchcount(filmtypesearch);
    }

    public void secureinsertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        blfilmtype.secureinsertFilmtype(filmtype);
    }

    public void secureupdateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        blfilmtype.secureupdateFilmtype(filmtype);
    }

    public void securedeleteFilmtype(IFilmtype filmtype) throws DBException, DataException {
        blfilmtype.securedeleteFilmtype(filmtype);
    }
}

