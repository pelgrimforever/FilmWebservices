/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 27.6.2022 16:45
 */
 
package film.conversion.json;

import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import data.json.piJson;
import film.entity.pk.SecurityprofilePK;
import film.interfaces.entity.pk.ISecurityprofilePK;
import film.interfaces.logicentity.ISecurityprofile;
import film.logicentity.Securityprofile;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author Franky Laseure
 */
public class JSONSecurityprofile {
    
    public static JSONArray toJSONArray(ArrayList securityprofiles) {
        JSONArray jsonsecurityprofiles = new JSONArray();
        Iterator securityprofilesI = securityprofiles.iterator();
        while(securityprofilesI.hasNext()) {
            jsonsecurityprofiles.add(toJSON((Securityprofile)securityprofilesI.next()));
        }
        return jsonsecurityprofiles;
    }

    public static JSONObject toJSON(ISecurityprofilePK securityprofilePK) {
        JSONObject json = null;
        if(securityprofilePK!=null) {
            json = new JSONObject();
            json.put("userprofile", securityprofilePK.getUserprofile());
        }
        return json;
    }

    public static JSONObject toJSON(ISecurityprofile securityprofile) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(securityprofile.getPrimaryKey()));
        json.put("privateaccess", securityprofile.getPrivateaccess());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Securityprofilesearch securityprofilesearch) {
        JSONObject json = new JSONObject();
        if(securityprofilesearch.used()) {
            byte andoroperator = securityprofilesearch.getAndoroperator();
            int maxresults = securityprofilesearch.getMaxresults();
            boolean docount = securityprofilesearch.getDocount();
            Iterator<EntityPK> primarykeysI = securityprofilesearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = securityprofilesearch.getFieldsearchers().iterator();
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
            if(securityprofilesearch.getSecurityuserprofilesearch()!=null && securityprofilesearch.getSecurityuserprofilesearch().used()) {
                kss.put("securityuserprofilesearcher", JSONSecurityuserprofile.toJSON((Securityuserprofilesearch)securityprofilesearch.getSecurityuserprofilesearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Securityprofilesearch toSecurityprofilesearch(JSONObject json) {
        Securityprofilesearch securityprofilesearch = new Securityprofilesearch();
        securityprofilesearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        securityprofilesearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        securityprofilesearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            securityprofilesearch.addPrimarykey(SecurityprofilePK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("userprofile");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            securityprofilesearch.userprofile(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("privateaccess");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            securityprofilesearch.privateaccess(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("securityuserprofilesearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Securityuserprofilesearch securityuserprofilesearch = JSONSecurityuserprofile.toSecurityuserprofilesearch((JSONObject)keysearch.get(i));
                securityprofilesearch.securityuserprofile(securityuserprofilesearch);
            }
        }
        return securityprofilesearch;
    }
    
    public static SecurityprofilePK toSecurityprofilePK(JSONObject json) {
        SecurityprofilePK securityprofilePK = null;
        if(json!=null) {
            securityprofilePK = new SecurityprofilePK(JSONConversion.getString(json, "userprofile"));
        }
        return securityprofilePK;
    }

    public static Securityprofile toSecurityprofile(JSONObject json) {
        Securityprofile securityprofile = new Securityprofile(toSecurityprofilePK((JSONObject)json.get("PK")));
        updateSecurityprofile(securityprofile, json);
        return securityprofile;
    }

    public static void updateSecurityprofile(ISecurityprofile securityprofile, JSONObject json) {
        securityprofile.setPrivateaccess(JSONConversion.getboolean(json, "privateaccess"));
    }

    public static Securityprofile initSecurityprofile(JSONObject json) {
        Securityprofile securityprofile = new Securityprofile(toSecurityprofilePK((JSONObject)json.get("PK")));
        securityprofile.initPrivateaccess(JSONConversion.getboolean(json, "privateaccess"));
        return securityprofile;
    }
}

