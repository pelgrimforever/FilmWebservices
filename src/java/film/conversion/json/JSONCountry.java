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
import film.entity.pk.CountryPK;
import film.interfaces.entity.pk.ICountryPK;
import film.interfaces.logicentity.ICountry;
import film.logicentity.Country;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONCountry {
    
    public static JSONArray toJSONArray(ArrayList countrys) {
        JSONArray jsoncountrys = new JSONArray();
        Iterator countrysI = countrys.iterator();
        while(countrysI.hasNext()) {
            jsoncountrys.add(toJSON((Country)countrysI.next()));
        }
        return jsoncountrys;
    }

    public static JSONObject toJSON(ICountryPK countryPK) {
        JSONObject json = null;
        if(countryPK!=null) {
            json = new JSONObject();
            json.put("code", countryPK.getCode());
        }
        return json;
    }

    public static JSONObject toJSON(ICountry country) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(country.getPrimaryKey()));
        json.put("name", country.getName());
        if(country.getLocation()!=null) {
            json.put("location", GISConversion.toJSON(country.getLocation()));
        }
        if(country.getBounds()!=null) {
            json.put("bounds", GISConversion.toJSON(country.getBounds()));
        }
        if(country.getViewport()!=null) {
            json.put("viewport", GISConversion.toJSON(country.getViewport()));
        }
        json.put("approximate", country.getApproximate());
        json.put("hasarealevel1", country.getHasarealevel1());
        json.put("hasarealevel2", country.getHasarealevel2());
        json.put("hasarealevel3", country.getHasarealevel3());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Countrysearch countrysearch) {
        JSONObject json = new JSONObject();
        if(countrysearch.used()) {
            byte andoroperator = countrysearch.getAndoroperator();
            int maxresults = countrysearch.getMaxresults();
            boolean docount = countrysearch.getDocount();
            Iterator<EntityPK> primarykeysI = countrysearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = countrysearch.getFieldsearchers().iterator();
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
            if(countrysearch.getArealevel1search()!=null && countrysearch.getArealevel1search().used()) {
                kss.put("arealevel1searcher", JSONArealevel1.toJSON((Arealevel1search)countrysearch.getArealevel1search()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Countrysearch toCountrysearch(JSONObject json) {
        Countrysearch countrysearch = new Countrysearch();
        countrysearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        countrysearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        countrysearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            countrysearch.addPrimarykey(CountryPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("code");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            countrysearch.code(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            countrysearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("approximate");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            countrysearch.approximate(value);
        }
        field = (JSONObject)fss.get("hasarealevel1");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            countrysearch.hasarealevel1(value);
        }
        field = (JSONObject)fss.get("hasarealevel2");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            countrysearch.hasarealevel2(value);
        }
        field = (JSONObject)fss.get("hasarealevel3");
        if(field!=null) {
            boolean value = JSONConversion.getBooleanvalue(field);
            countrysearch.hasarealevel3(value);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("arealevel1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Arealevel1search arealevel1search = JSONArealevel1.toArealevel1search((JSONObject)keysearch.get(i));
                countrysearch.arealevel1(arealevel1search);
            }
        }
        return countrysearch;
    }
    
    public static CountryPK toCountryPK(JSONObject json) {
        CountryPK countryPK = null;
        if(json!=null) {
            countryPK = new CountryPK(JSONConversion.getString(json, "code"));
        }
        return countryPK;
    }

    public static Country toCountry(JSONObject json) {
        Country country = new Country(toCountryPK((JSONObject)json.get("PK")));
        updateCountry(country, json);
        return country;
    }

    public static void updateCountry(ICountry country, JSONObject json) {
        country.setName(JSONConversion.getString(json, "name"));
        country.setLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        country.setBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        country.setViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        country.setApproximate(JSONConversion.getboolean(json, "approximate"));
        country.setHasarealevel1(JSONConversion.getboolean(json, "hasarealevel1"));
        country.setHasarealevel2(JSONConversion.getboolean(json, "hasarealevel2"));
        country.setHasarealevel3(JSONConversion.getboolean(json, "hasarealevel3"));
    }

    public static Country initCountry(JSONObject json) {
        Country country = new Country(toCountryPK((JSONObject)json.get("PK")));
        country.initName(JSONConversion.getString(json, "name"));
        country.initLocation(GISConversion.topiShape((JSONObject)json.get("location")));
        country.initBounds(GISConversion.topiShape((JSONObject)json.get("bounds")));
        country.initViewport(GISConversion.topiShape((JSONObject)json.get("viewport")));
        country.initApproximate(JSONConversion.getboolean(json, "approximate"));
        country.initHasarealevel1(JSONConversion.getboolean(json, "hasarealevel1"));
        country.initHasarealevel2(JSONConversion.getboolean(json, "hasarealevel2"));
        country.initHasarealevel3(JSONConversion.getboolean(json, "hasarealevel3"));
        return country;
    }
}

