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
import film.entity.pk.CreatorPK;
import film.interfaces.entity.pk.ICreatorPK;
import film.interfaces.logicentity.ICreator;
import film.logicentity.Creator;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONCreator {
    
    public static JSONArray toJSONArray(ArrayList creators) {
        JSONArray jsoncreators = new JSONArray();
        Iterator creatorsI = creators.iterator();
        while(creatorsI.hasNext()) {
            jsoncreators.add(toJSON((Creator)creatorsI.next()));
        }
        return jsoncreators;
    }

    public static JSONObject toJSON(ICreatorPK creatorPK) {
        JSONObject json = null;
        if(creatorPK!=null) {
            json = new JSONObject();
            json.put("creatorid", creatorPK.getCreatorid());
        }
        return json;
    }

    public static JSONObject toJSON(ICreator creator) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(creator.getPrimaryKey()));
        json.put("name", creator.getName());
        json.put("surname", creator.getSurname());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Creatorsearch creatorsearch) {
        JSONObject json = new JSONObject();
        if(creatorsearch.used()) {
            byte andoroperator = creatorsearch.getAndoroperator();
            int maxresults = creatorsearch.getMaxresults();
            boolean docount = creatorsearch.getDocount();
            Iterator<EntityPK> primarykeysI = creatorsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = creatorsearch.getFieldsearchers().iterator();
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
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Creatorsearch toCreatorsearch(JSONObject json) {
        Creatorsearch creatorsearch = new Creatorsearch();
        creatorsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        creatorsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        creatorsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            creatorsearch.addPrimarykey(CreatorPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("creatorid");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            creatorsearch.creatorid(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("name");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            creatorsearch.name(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("surname");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            creatorsearch.surname(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        return creatorsearch;
    }
    
    public static CreatorPK toCreatorPK(JSONObject json) {
        CreatorPK creatorPK = null;
        if(json!=null) {
            creatorPK = new CreatorPK(JSONConversion.getString(json, "creatorid"));
        }
        return creatorPK;
    }

    public static Creator toCreator(JSONObject json) {
        Creator creator = new Creator(toCreatorPK((JSONObject)json.get("PK")));
        updateCreator(creator, json);
        return creator;
    }

    public static void updateCreator(ICreator creator, JSONObject json) {
        creator.setName(JSONConversion.getString(json, "name"));
        creator.setSurname(JSONConversion.getString(json, "surname"));
    }

    public static Creator initCreator(JSONObject json) {
        Creator creator = new Creator(toCreatorPK((JSONObject)json.get("PK")));
        creator.initName(JSONConversion.getString(json, "name"));
        creator.initSurname(JSONConversion.getString(json, "surname"));
        return creator;
    }
}

