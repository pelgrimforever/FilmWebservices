/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.SecurityuserprofilePK;
import film.interfaces.entity.pk.ISecurityuserprofilePK;
import film.interfaces.logicentity.ISecurityuserprofile;
import film.logicentity.Securityuserprofile;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONSecurityuserprofile {
    
    public static JSONArray toJSONArray(ArrayList securityuserprofiles) {
        JSONArray jsonsecurityuserprofiles = new JSONArray();
        Iterator securityuserprofilesI = securityuserprofiles.iterator();
        while(securityuserprofilesI.hasNext()) {
            jsonsecurityuserprofiles.add(toJSON((Securityuserprofile)securityuserprofilesI.next()));
        }
        return jsonsecurityuserprofiles;
    }

    public static JSONObject toJSON(ISecurityuserprofilePK securityuserprofilePK) {
        JSONObject json = null;
        if(securityuserprofilePK!=null) {
            json = new JSONObject();
            json.put("siteusername", securityuserprofilePK.getSiteusername());
            json.put("userprofile", securityuserprofilePK.getUserprofile());
        }
        return json;
    }

    public static JSONObject toJSON(ISecurityuserprofile securityuserprofile) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(securityuserprofile.getPrimaryKey()));
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Securityuserprofilesearch securityuserprofilesearch) {
        JSONObject json = new JSONObject();
        if(securityuserprofilesearch.used()) {
            byte andoroperator = securityuserprofilesearch.getAndoroperator();
            int maxresults = securityuserprofilesearch.getMaxresults();
            boolean docount = securityuserprofilesearch.getDocount();
            Iterator<EntityPK> primarykeysI = securityuserprofilesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = securityuserprofilesearch.getFieldsearchers().iterator();
            EntityPK primarykey;
            Fieldsearcher fieldsearcher;
            
            json.put("andor", andoroperator);
            json.put("maxresults", maxresults);
            json.put("docount", docount);
            JSONArray pks = new JSONArray();
            int i = 0;
            while(primarykeysI.hasNext()) {
                primarykey = primarykeysI.next();
                pks.add(primarykey.getKeystring());
            }
            json.put("primarykeys", pks);
            JSONObject fss = new JSONObject();
            while(fieldsearchersI.hasNext()) {
                fieldsearcher = fieldsearchersI.next();
                if(fieldsearcher.used()) {
                    fss.put(fieldsearcher.getShortFieldname(), JSONConversion.toJSON(fieldsearcher));
                }
            }
            json.put("fields", fss);
            JSONObject kss = new JSONObject();
            if(securityuserprofilesearch.getSecurityprofilesearch()!=null && securityuserprofilesearch.getSecurityprofilesearch().used()) {
                kss.put("securityprofilesearcher", JSONSecurityprofile.toJSON((Securityprofilesearch)securityuserprofilesearch.getSecurityprofilesearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Securityuserprofilesearch toSecurityuserprofilesearch(JSONObject json) {
        Securityuserprofilesearch securityuserprofilesearch = new Securityuserprofilesearch();
        securityuserprofilesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        securityuserprofilesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        securityuserprofilesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            securityuserprofilesearch.addPrimarykey(SecurityuserprofilePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("siteusername");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            securityuserprofilesearch.siteusername(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("securityprofilesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Securityprofilesearch securityprofilesearch = JSONSecurityprofile.toSecurityprofilesearch((JSONObject)keysearch.get(i));
                securityuserprofilesearch.securityprofile(securityprofilesearch);
            }
        }
        return securityuserprofilesearch;
    }
    
    public static SecurityuserprofilePK toSecurityuserprofilePK(JSONObject json) {
        SecurityuserprofilePK securityuserprofilePK = null;
        if(json!=null) {
            securityuserprofilePK = new SecurityuserprofilePK(JSONConversion.getString(json, "siteusername"), JSONConversion.getString(json, "userprofile"));
        }
        return securityuserprofilePK;
    }

    public static Securityuserprofile toSecurityuserprofile(JSONObject json) {
        Securityuserprofile securityuserprofile = new Securityuserprofile(toSecurityuserprofilePK((JSONObject)json.get("PK")));
        updateSecurityuserprofile(securityuserprofile, json);
        return securityuserprofile;
    }

    public static void updateSecurityuserprofile(ISecurityuserprofile securityuserprofile, JSONObject json) {
    }

    public static Securityuserprofile initSecurityuserprofile(JSONObject json) {
        Securityuserprofile securityuserprofile = new Securityuserprofile(toSecurityuserprofilePK((JSONObject)json.get("PK")));
        return securityuserprofile;
    }
}

