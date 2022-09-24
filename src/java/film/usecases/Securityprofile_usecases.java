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
import film.logicentity.Securityprofile;
import film.logicview.*;
import film.usecases.custom.*;
import general.exception.*;
import java.sql.Date;
import java.io.*;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class Securityprofile_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsecurityprofile blsecurityprofile = new BLsecurityprofile(sqlreader);
    
    public Securityprofile_usecases() {
        this(false);
    }
    
    public Securityprofile_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsecurityprofile.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsecurityprofile.count();
    }
    
    public ArrayList<Securityprofile> get_all() throws DBException {
        return blsecurityprofile.getSecurityprofiles();
    }
    
    public boolean getSecurityprofileExists(ISecurityprofilePK securityprofilePK) throws DBException {
        return blsecurityprofile.getSecurityprofileExists(securityprofilePK);
    }
    
    public Securityprofile get_securityprofile_by_primarykey(ISecurityprofilePK securityprofilePK) throws DBException {
        return blsecurityprofile.getSecurityprofile(securityprofilePK);
    }

    public Securityprofile get_securityprofile_with_externalforeignkey_securityuserprofile(ISecurityuserprofilePK securityuserprofilePK) throws CustomException {
        return blsecurityprofile.getSecurityuserprofile(securityuserprofilePK);
    }
    
    public ArrayList<Securityprofile> search_securityprofile(ISecurityprofilesearch securityprofilesearch) throws CustomException {
        return blsecurityprofile.search(securityprofilesearch);
    }
    
    public long search_securityprofile_count(ISecurityprofilesearch securityprofilesearch) throws CustomException {
        return blsecurityprofile.searchcount(securityprofilesearch);
    }

    public void insertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityprofile.insertSecurityprofile(tq, securityprofile);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityprofile.updateSecurityprofile(tq, securityprofile);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityprofile.deleteSecurityprofile(tq, securityprofile);
        sqlwriter.Commit2DB(tq);
    }

}

