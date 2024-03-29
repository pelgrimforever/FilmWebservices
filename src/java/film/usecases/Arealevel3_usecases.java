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
import film.logicentity.Arealevel3;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Arealevel3_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLarealevel3 blarealevel3 = new BLarealevel3(sqlreader);
    
    public Arealevel3_usecases() {
        this(false);
    }
    
    public Arealevel3_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blarealevel3.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blarealevel3.count();
    }
    
    public ArrayList<Arealevel3> get_all() throws DBException {
        return blarealevel3.getArealevel3s();
    }
    
    public boolean getArealevel3Exists(IArealevel3PK arealevel3PK) throws DBException {
        return blarealevel3.getArealevel3Exists(arealevel3PK);
    }
    
    public Arealevel3 get_arealevel3_by_primarykey(IArealevel3PK arealevel3PK) throws DBException {
        return blarealevel3.getArealevel3(arealevel3PK);
    }

    public ArrayList<Arealevel3> get_arealevel3_with_foreignkey_arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        return blarealevel3.getArealevel3s4arealevel2(arealevel2PK);
    }
    
    public ArrayList<Arealevel3> search_arealevel3(IArealevel3search arealevel3search) throws CustomException {
        return blarealevel3.search(arealevel3search);
    }
    
    public long search_arealevel3_count(IArealevel3search arealevel3search) throws CustomException {
        return blarealevel3.searchcount(arealevel3search);
    }

    public void insertArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel3.insertArealevel3(tq, arealevel3);
        sqlwriter.Commit2DB(tq);
    }

    public void updateArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel3.updateArealevel3(tq, arealevel3);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteArealevel3(IArealevel3 arealevel3) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel3.deleteArealevel3(tq, arealevel3);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Arealevel2(IArealevel2PK arealevel2PK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blarealevel3.delete4arealevel2(tq, arealevel2PK);
        sqlwriter.Commit2DB(tq);
    }
    
}

