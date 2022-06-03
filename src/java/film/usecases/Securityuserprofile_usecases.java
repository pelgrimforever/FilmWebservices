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
import film.logicentity.Securityuserprofile;
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
    private BLsecurityuserprofile blsecurityuserprofile = new BLsecurityuserprofile();
    
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
        return blsecurityuserprofile.getEntityExists(securityuserprofilePK);
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

    public void secureinsertSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        blsecurityuserprofile.secureinsertSecurityuserprofile(securityuserprofile);
    }

    public void secureupdateSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        blsecurityuserprofile.secureupdateSecurityuserprofile(securityuserprofile);
    }

    public void securedeleteSecurityuserprofile(ISecurityuserprofile securityuserprofile) throws DBException, DataException {
        blsecurityuserprofile.securedeleteSecurityuserprofile(securityuserprofile);
    }
}

