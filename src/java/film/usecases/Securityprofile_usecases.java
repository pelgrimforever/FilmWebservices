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
import film.logicentity.Securityprofile;
import general.exception.*;
import java.sql.Date;
import java.util.*;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * @author Franky Laseure
 */
public class Securityprofile_usecases {

    private boolean loggedin = false;
    private BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
    
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
        return blsecurityprofile.getEntityExists(securityprofilePK);
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

    public void secureinsertSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        blsecurityprofile.secureinsertSecurityprofile(securityprofile);
    }

    public void secureupdateSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        blsecurityprofile.secureupdateSecurityprofile(securityprofile);
    }

    public void securedeleteSecurityprofile(ISecurityprofile securityprofile) throws DBException, DataException {
        blsecurityprofile.securedeleteSecurityprofile(securityprofile);
    }
}

