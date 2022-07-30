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
import film.logicentity.Postalcode;
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
public class Postalcode_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLpostalcode blpostalcode = new BLpostalcode(sqlreader);
    
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
        return blpostalcode.getPostalcodeExists(postalcodePK);
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

    public void insertPostalcode(IPostalcode postalcode) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blpostalcode.insertPostalcode(tq, postalcode);
        sqlwriter.Commit2DB(tq);
    }

    public void updatePostalcode(IPostalcode postalcode) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blpostalcode.updatePostalcode(tq, postalcode);
        sqlwriter.Commit2DB(tq);
    }

    public void deletePostalcode(IPostalcode postalcode) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blpostalcode.deletePostalcode(tq, postalcode);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Arealevel3(IArealevel3PK arealevel3PK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blpostalcode.delete4arealevel3(tq, arealevel3PK);
        sqlwriter.Commit2DB(tq);
    }
    
}

