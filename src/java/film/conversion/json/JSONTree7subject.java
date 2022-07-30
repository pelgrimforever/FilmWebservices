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
import film.entity.pk.Tree7subjectPK;
import film.interfaces.entity.pk.ITree7subjectPK;
import film.interfaces.logicentity.ITree7subject;
import film.logicentity.Tree7subject;
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
public class JSONTree7subject {
    
    public static JSONArray toJSONArray(ArrayList tree7subjects) {
        JSONArray jsontree7subjects = new JSONArray();
        Iterator tree7subjectsI = tree7subjects.iterator();
        while(tree7subjectsI.hasNext()) {
            jsontree7subjects.add(toJSON((Tree7subject)tree7subjectsI.next()));
        }
        return jsontree7subjects;
    }

    public static JSONObject toJSON(ITree7subjectPK tree7subjectPK) {
        JSONObject json = null;
        if(tree7subjectPK!=null) {
            json = new JSONObject();
            json.put("subjectid", String.valueOf(tree7subjectPK.getSubjectid()));
        }
        return json;
    }

    public static JSONObject toJSON(ITree7subject tree7subject) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(tree7subject.getPrimaryKey()));
        json.put("tree7subjectParentsubjectidPK", JSONTree7subject.toJSON(tree7subject.getTree7subjectparentsubjectidPK()));
        json.put("tree7id", tree7subject.getTree7id());
        json.put("subject", tree7subject.getSubject());
        json.put("treestep", tree7subject.getTreestep());
//Custom code, do not change this line
        ArrayList parents = new ArrayList();
        ITree7subject parent;
        JSONArray jsonparents = new JSONArray();
        if(tree7subject.getParents()!=null) {
            Iterator<ITree7subject> parentsI = tree7subject.getParents().iterator();
            while(parentsI.hasNext()) {
                jsonparents.add(toJSON(parentsI.next()));
            }
            json.put("parents", jsonparents);
        }
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Tree7subjectsearch tree7subjectsearch) {
        JSONObject json = new JSONObject();
        if(tree7subjectsearch.used()) {
            byte andoroperator = tree7subjectsearch.getAndoroperator();
            int maxresults = tree7subjectsearch.getMaxresults();
            boolean docount = tree7subjectsearch.getDocount();
            Iterator<EntityPK> primarykeysI = tree7subjectsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = tree7subjectsearch.getFieldsearchers().iterator();
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
            if(tree7subjectsearch.getTree7subjectparentsubjectidsearch()!=null && tree7subjectsearch.getTree7subjectparentsubjectidsearch().used()) {
                kss.put("tree7subjectParentsubjectidsearcher", JSONTree7subject.toJSON((Tree7subjectsearch)tree7subjectsearch.getTree7subjectparentsubjectidsearch()));
            }
            if(tree7subjectsearch.getPhototree7subjectsearch()!=null && tree7subjectsearch.getPhototree7subjectsearch().used()) {
                kss.put("phototree7subjectsearcher", JSONPhototree7subject.toJSON((Phototree7subjectsearch)tree7subjectsearch.getPhototree7subjectsearch()));
            }
            if(tree7subjectsearch.getRelPhotosearch()!=null && tree7subjectsearch.getRelPhotosearch().used()) {
                kss.put("photosearcher", JSONPhototree7subject.toJSON((Phototree7subjectsearch)tree7subjectsearch.getRelPhotosearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Tree7subjectsearch toTree7subjectsearch(JSONObject json) {
        Tree7subjectsearch tree7subjectsearch = new Tree7subjectsearch();
        tree7subjectsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        tree7subjectsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        tree7subjectsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            tree7subjectsearch.addPrimarykey(Tree7subjectPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("subjectid");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tree7subjectsearch.subjectid(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("tree7id");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            tree7subjectsearch.tree7id(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("subject");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            tree7subjectsearch.subject(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("treestep");
        if(field!=null) {
            Double[] valuearray = JSONConversion.getDoublevalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            tree7subjectsearch.treestep(valuearray, operators, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("tree7subjectParentsubjectidsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tree7subjectsearch tree7subjectParentsubjectidsearch = JSONTree7subject.toTree7subjectsearch((JSONObject)keysearch.get(i));
                tree7subjectsearch.tree7subjectParentsubjectid(tree7subjectParentsubjectidsearch);
            }
        }
        keysearch = (JSONArray)kss.get("phototree7subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Phototree7subjectsearch phototree7subjectsearch = JSONPhototree7subject.toPhototree7subjectsearch((JSONObject)keysearch.get(i));
                tree7subjectsearch.phototree7subject(phototree7subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                tree7subjectsearch.relphoto(photosearch);
            }
        }
        return tree7subjectsearch;
    }
    
    public static Tree7subjectPK toTree7subjectPK(JSONObject json) {
        Tree7subjectPK tree7subjectPK = null;
        if(json!=null) {
            tree7subjectPK = new Tree7subjectPK(JSONConversion.getlong(json, "subjectid"));
        }
        return tree7subjectPK;
    }

    public static Tree7subject toTree7subject(JSONObject json) {
        Tree7subject tree7subject = new Tree7subject(toTree7subjectPK((JSONObject)json.get("PK")));
        updateTree7subject(tree7subject, json);
        return tree7subject;
    }

    public static void updateTree7subject(ITree7subject tree7subject, JSONObject json) {
        tree7subject.setTree7subjectparentsubjectidPK(JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectParentsubjectidPK")));
        tree7subject.setTree7id(JSONConversion.getString(json, "tree7id"));
        tree7subject.setSubject(JSONConversion.getString(json, "subject"));
        tree7subject.setTreestep(JSONConversion.getint(json, "treestep"));
    }

    public static Tree7subject initTree7subject(JSONObject json) {
        Tree7subject tree7subject = new Tree7subject(toTree7subjectPK((JSONObject)json.get("PK")));
        tree7subject.initTree7subjectparentsubjectidPK(JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectParentsubjectidPK")));
        tree7subject.initTree7id(JSONConversion.getString(json, "tree7id"));
        tree7subject.initSubject(JSONConversion.getString(json, "subject"));
        tree7subject.initTreestep(JSONConversion.getint(json, "treestep"));
        return tree7subject;
    }
}

