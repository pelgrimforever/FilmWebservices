/*
 * Security.java
 *
 * Created on Dec 23, 2012, 6:11 PM
 * Generated on 24.11.2012 14:11
 *
 */

package film.BusinessObject.security;

import film.BusinessObject.Logic.BLsecurityprofile;
import general.exception.DBException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import sitesecurity.entity.pk.SiteuserPK;
import sitesecurity.logicentity.Siteuser;

/**
 *
 * @author pelgrim
 */
public class Security {
//ProjectGenerator: NO AUTHOMATIC UPDATE

    private BLsecurityprofile blsecurityprofile = new BLsecurityprofile();
    
    public Security() {
    }

    public boolean check(String siteusername, String password) throws DBException {
        boolean authenticated = false;
/*        if(siteusername!=null && siteusername.length()>0) {
            Siteuser siteuser = blsiteuser.getSiteuser(new SiteuserPK(siteusername));
            if(siteuser!=null && !siteuser.isEmpty()) {
                authenticated = siteuser.getUserpassword().equals(password);
            }
        }*/
        return authenticated;
    }

    public ArrayList getGroups(String siteusername) throws DBException {
        ArrayList groups = new ArrayList();
        //groups = blgroup.getSitegroups(new SiteuserPK(siteusername));
        return groups;
    }

    public ArrayList getProfiles(String siteusername) throws DBException {
        return blsecurityprofile.getSecurityprofiles(siteusername);
    }

    public String encrypt(String string) {
        String returnstring = null;
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(string.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            returnstring = sb.toString();
        }
        catch(NoSuchAlgorithmException uee) {
        }
        return returnstring;
    }
}

