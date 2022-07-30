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
import film.logicentity.Securityuserprofile;
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
public class Securityuserprofile_usecases {

    private boolean loggedin = false;
    private SQLreader sqlreader = new SQLreader();
    private SQLTwriter sqlwriter = new SQLTwriter();
    private BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile(sqlreader);
    
    public Securityuserprofile_usecases() {
        this(false);
    }
    
    public Securityuserprofile_usecases(boolean loggedin) {
        this.loggedin = loggedin;
        blsecurityuserprofile.setAuthenticated(loggedin);
    }
    
//Custom code, do not change this line
//add here custom operations
//Custom code, do not change this line   

    public long count() throws DBException {
        return blsecurityuserprofile.count();
    }
    
    public ArrayList<Securityuserprofile> get_all() throws DBException {
        return blsecurityuserprofile.getSecurityuserprofiles();
    }
    
    public boolean getSecurityuserprofileExists(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return blsecurityuserprofile.getSecurityuserprofileExists(securityuserprofilePK);
    }
    
    public Securityuserprofile get_securityuserprofile_by_primarykey(ISecurityuserprofilePK securityuserprofilePK) throws DBException {
        return blsecurityuserprofile.getSecurityuserprofile(securityuserprofilePK);
    }

    public ArrayList<Securityuserprofile> get_securityuserprofile_with_foreignkey_securityprofile(ISecurityprofilePK securityprofilePK) throws CustomException {
        return blsecurityuserprofile.getSecurityuserprofiles4securityprofile(securityprofilePK);
    }
    
    public ArrayList<Securityuserprofile> search_securityuserprofile(ISecurityuserprofilesearch securityuserprofilesearch) throws CustomException {
        return blsecurityuserprofile.search(securityuserprofilesearch);
    }
    
    public long search_securityuserprofile_count(ISecurityuserprofilesearch securityuserprofilesearch) throws CustomException {
        return blsecurityuserprofile.searchcount(securityuserprofilesearch);
    }

    public void insertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityuserprofile.insertSecurityuserprofile(tq, securityuserprofile);
        sqlwriter.Commit2DB(tq);
    }

    public void updateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityuserprofile.updateSecurityuserprofile(tq, securityuserprofile);
        sqlwriter.Commit2DB(tq);
    }

    public void deleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityuserprofile.deleteSecurityuserprofile(tq, securityuserprofile);
        sqlwriter.Commit2DB(tq);
    }

    public void delete_all_containing_Securityprofile(ISecurityprofilePK securityprofilePK) throws CustomException {
        SQLTqueue tq = new SQLTqueue();
        blsecurityuserprofile.delete4securityprofile(tq, securityprofilePK);
        sqlwriter.Commit2DB(tq);
    }
    
}

