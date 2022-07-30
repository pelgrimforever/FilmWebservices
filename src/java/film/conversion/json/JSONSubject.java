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
import film.entity.pk.SubjectPK;
import film.interfaces.entity.pk.ISubjectPK;
import film.interfaces.logicentity.ISubject;
import film.logicentity.Subject;
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
public class JSONSubject {
    
    public static JSONArray toJSONArray(ArrayList subjects) {
        JSONArray jsonsubjects = new JSONArray();
        Iterator subjectsI = subjects.iterator();
        while(subjectsI.hasNext()) {
            jsonsubjects.add(toJSON((Subject)subjectsI.next()));
        }
        return jsonsubjects;
    }

    public static JSONObject toJSON(ISubjectPK subjectPK) {
        JSONObject json = null;
        if(subjectPK!=null) {
            json = new JSONObject();
            json.put("cat1", subjectPK.getCat1());
            json.put("cat2", subjectPK.getCat2());
            json.put("id", subjectPK.getId());
        }
        return json;
    }

    public static JSONObject toJSON(ISubject subject) {
        JSONObject json = new JSONObject();
        json.put("PK", toJSON(subject.getPrimaryKey()));
        json.put("tree7subjectPK", JSONTree7subject.toJSON(subject.getTree7subjectPK()));
        json.put("subject", subject.getSubject());
        json.put("description", subject.getDescription());
//Custom code, do not change this line
//Custom code, do not change this line
        return json;
    }

    public static JSONObject toJSON(Subjectsearch subjectsearch) {
        JSONObject json = new JSONObject();
        if(subjectsearch.used()) {
            byte andoroperator = subjectsearch.getAndoroperator();
            int maxresults = subjectsearch.getMaxresults();
            boolean docount = subjectsearch.getDocount();
            Iterator<EntityPK> primarykeysI = subjectsearch.getPrimarykeys().iterator();
            Iterator<Fieldsearcher> fieldsearchersI = subjectsearch.getFieldsearchers().iterator();
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
            if(subjectsearch.getSubjectcatcat1search()!=null && subjectsearch.getSubjectcatcat1search().used()) {
                kss.put("subjectcatCat1searcher", JSONSubjectcat.toJSON((Subjectcatsearch)subjectsearch.getSubjectcatcat1search()));
            }
            if(subjectsearch.getTree7subjectsearch()!=null && subjectsearch.getTree7subjectsearch().used()) {
                kss.put("tree7subjectsearcher", JSONTree7subject.toJSON((Tree7subjectsearch)subjectsearch.getTree7subjectsearch()));
            }
            if(subjectsearch.getSubjectcatcat2search()!=null && subjectsearch.getSubjectcatcat2search().used()) {
                kss.put("subjectcatCat2searcher", JSONSubjectcat.toJSON((Subjectcatsearch)subjectsearch.getSubjectcatcat2search()));
            }
            if(subjectsearch.getFilmsubjectssearch()!=null && subjectsearch.getFilmsubjectssearch().used()) {
                kss.put("filmsubjectssearcher", JSONFilmsubjects.toJSON((Filmsubjectssearch)subjectsearch.getFilmsubjectssearch()));
            }
            if(subjectsearch.getRelFilmsearch()!=null && subjectsearch.getRelFilmsearch().used()) {
                kss.put("filmsearcher", JSONFilmsubjects.toJSON((Filmsubjectssearch)subjectsearch.getRelFilmsearch()));
            }
            if(subjectsearch.getPhotosubjectssearch()!=null && subjectsearch.getPhotosubjectssearch().used()) {
                kss.put("photosubjectssearcher", JSONPhotosubjects.toJSON((Photosubjectssearch)subjectsearch.getPhotosubjectssearch()));
            }
            if(subjectsearch.getRelPhotosearch()!=null && subjectsearch.getRelPhotosearch().used()) {
                kss.put("photosearcher", JSONPhotosubjects.toJSON((Photosubjectssearch)subjectsearch.getRelPhotosearch()));
            }
            json.put("keysearch", kss);
        }
        return json;
    }

    public static Subjectsearch toSubjectsearch(JSONObject json) {
        Subjectsearch subjectsearch = new Subjectsearch();
        subjectsearch.setANDORoperator(JSONConversion.getbyte(json, "andor"));
        subjectsearch.setMaxresults(JSONConversion.getint(json, "maxresults"));
        subjectsearch.setDocount(JSONConversion.getboolean(json, "docount"));
        JSONArray pks = (JSONArray)json.get("primarykeys");
        for(int i=0; i<pks.size(); i++) {
            subjectsearch.addPrimarykey(SubjectPK.getKey((String)pks.get(i)));
        }
        JSONObject fss = (JSONObject)json.get("fields");
        JSONObject field;
        field = (JSONObject)fss.get("id");
        if(field!=null) {
            long[] valuearray = JSONConversion.getLongvalues(field);
            byte[] operators = JSONConversion.getNumberoperators(field);
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectsearch.id(valuearray, operators, andor);
        }
        field = (JSONObject)fss.get("subject");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectsearch.subject(valuearray, compareoperator, andor);
        }
        field = (JSONObject)fss.get("description");
        if(field!=null) {
            String[] valuearray = JSONConversion.getStringvalues(field);
            byte compareoperator = JSONConversion.getbyte(field, "compareoperator");
            byte andor = JSONConversion.getbyte(field, "andor");
            subjectsearch.description(valuearray, compareoperator, andor);
        }
        JSONObject kss = (JSONObject)json.get("keysearch");
        JSONArray keysearch;
        keysearch = (JSONArray)kss.get("subjectcatCat1searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectcatsearch subjectcatCat1search = JSONSubjectcat.toSubjectcatsearch((JSONObject)keysearch.get(i));
                subjectsearch.subjectcatCat1(subjectcatCat1search);
            }
        }
        keysearch = (JSONArray)kss.get("tree7subjectsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Tree7subjectsearch tree7subjectsearch = JSONTree7subject.toTree7subjectsearch((JSONObject)keysearch.get(i));
                subjectsearch.tree7subject(tree7subjectsearch);
            }
        }
        keysearch = (JSONArray)kss.get("subjectcatCat2searcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Subjectcatsearch subjectcatCat2search = JSONSubjectcat.toSubjectcatsearch((JSONObject)keysearch.get(i));
                subjectsearch.subjectcatCat2(subjectcatCat2search);
            }
        }
        keysearch = (JSONArray)kss.get("filmsubjectssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmsubjectssearch filmsubjectssearch = JSONFilmsubjects.toFilmsubjectssearch((JSONObject)keysearch.get(i));
                subjectsearch.filmsubjects(filmsubjectssearch);
            }
        }
        keysearch = (JSONArray)kss.get("filmsearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Filmsearch filmsearch = JSONFilm.toFilmsearch((JSONObject)keysearch.get(i));
                subjectsearch.relfilm(filmsearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosubjectssearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosubjectssearch photosubjectssearch = JSONPhotosubjects.toPhotosubjectssearch((JSONObject)keysearch.get(i));
                subjectsearch.photosubjects(photosubjectssearch);
            }
        }
        keysearch = (JSONArray)kss.get("photosearcher");
        if(keysearch!=null) {
            for(int i=0; i<keysearch.size(); i++) {
                Photosearch photosearch = JSONPhoto.toPhotosearch((JSONObject)keysearch.get(i));
                subjectsearch.relphoto(photosearch);
            }
        }
        return subjectsearch;
    }
    
    public static SubjectPK toSubjectPK(JSONObject json) {
        SubjectPK subjectPK = null;
        if(json!=null) {
            subjectPK = new SubjectPK(JSONConversion.getString(json, "cat1"), JSONConversion.getString(json, "cat2"), JSONConversion.getint(json, "id"));
        }
        return subjectPK;
    }

    public static Subject toSubject(JSONObject json) {
        Subject subject = new Subject(toSubjectPK((JSONObject)json.get("PK")));
        updateSubject(subject, json);
        return subject;
    }

    public static void updateSubject(ISubject subject, JSONObject json) {
        subject.setTree7subjectPK(JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectPK")));
        subject.setSubject(JSONConversion.getString(json, "subject"));
        subject.setDescription(JSONConversion.getString(json, "description"));
    }

    public static Subject initSubject(JSONObject json) {
        Subject subject = new Subject(toSubjectPK((JSONObject)json.get("PK")));
        subject.initTree7subjectPK(JSONTree7subject.toTree7subjectPK((JSONObject)json.get("tree7subjectPK")));
        subject.initSubject(JSONConversion.getString(json, "subject"));
        subject.initDescription(JSONConversion.getString(json, "description"));
        return subject;
    }
}

