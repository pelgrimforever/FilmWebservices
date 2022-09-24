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
import film.logicentity.Filmtype;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Filmtype_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLfilmtype blfilmtype = new BLfilmtype(sqlreader);
    
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
        return blfilmtype.getFilmtypeExists(filmtypePK);
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

    public void insertFilmtype(IFilmtype filmtype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmtype.insertFilmtype(tq, filmtype);
        sqlwriter.Commit2DB(tq);
    }

    public void updateFilmtype(IFilmtype filmtype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmtype.updateFilmtype(tq, filmtype);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteFilmtype(IFilmtype filmtype) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blfilmtype.deleteFilmtype(tq, filmtype);
        sqlwriter.Commit2DB(tq);
    }

}

