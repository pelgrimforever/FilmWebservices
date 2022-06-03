/*
 * WSSubject.java
 *
 * Created on Dec 23, 2012, 7:24 PM
 * Generated on 1.5.2022 20:24
 *
 */

package film.webservices;

import film.BusinessObject.Logic.*;
import film.conversion.json.*;
import film.entity.pk.*;
import film.interfaces.entity.pk.*;
import film.interfaces.logicentity.*;
import film.interfaces.webservice.WSISubject;
import film.logicentity.Subject;
import film.searchentity.Subjectsearch;
import general.exception.CustomException;
import general.exception.DataException;
import general.exception.DBException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebService(endpointInterface = "film.interfaces.webservice.WSISubject")
public class WSSubject implements WSISubject {

    private JSONArray toJSONArray(ArrayList subjects) {
        JSONArray jsonsubjects = new JSONArray();
        Iterator subjectsI = subjects.iterator();
        while(subjectsI.hasNext()) {
            jsonsubjects.add(JSONSubject.toJSON((Subject)subjectsI.next()));
        }
        return jsonsubjects;
    }

    /**
     * Web service operation
     */
    //@WebMethod(operationName = "getSubjects")
    @Override
    public String getSubjects() {
        try {
            BLsubject blsubject = new BLsubject();
            ArrayList subjects = blsubject.getAll();
            JSONArray jsonsubjects = toJSONArray(subjects);
            return jsonsubjects.toJSONString();
        }
        catch(DBException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "search")
    @Override
    public String search(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        String result = "";
        Subject subject;
        try {
            Subjectsearch subjectsearch = JSONSubject.toSubjectsearch((JSONObject)parser.parse(json));
            ArrayList subjects = blsubject.search(subjectsearch);
            JSONArray jsonsubjects = toJSONArray(subjects);
            result = jsonsubjects.toJSONString();
        }
        catch(ParseException e) {
            result = "";
        }
        catch(DBException e) {
            result = "";
        }
        return result;
    }

    //@WebMethod(operationName = "getSubject")
    @Override
    public String getSubject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        String result = "";
        Subject subject;
        try {
            SubjectPK subjectPK = JSONSubject.toSubjectPK((JSONObject)parser.parse(json));
            subject = blsubject.getSubject(subjectPK);
            if(subject!=null) {
                result = JSONSubject.toJSON(subject).toJSONString();
            }
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
        return result;
    }

    //@WebMethod(operationName = "insertSubject")
    @Override
    public void insertSubject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        try {
            ISubject subject = JSONSubject.toSubject((JSONObject)parser.parse(json));
            blsubject.insertSubject(subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "updateSubject")
    @Override
    public void updateSubject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        try {
            ISubject subject = JSONSubject.toSubject((JSONObject)parser.parse(json));
            blsubject.updateSubject(subject);
        }
        catch(ParseException e) {
        }
        catch(DataException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "deleteSubject")
    @Override
    public void deleteSubject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        try {
            ISubject subject = JSONSubject.toSubject((JSONObject)parser.parse(json));
            blsubject.deleteSubject(subject);
        }
        catch(ParseException e) {
        }
        catch(DBException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4subjectcatCat1")
    @Override
    public String getSubjects4subjectcatCat1(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ISubjectcatPK subjectcatCat1PK = JSONSubjectcat.toSubjectcatPK((JSONObject)parser.parse(json));
            ArrayList subjects = blsubject.getSubjects4subjectcatCat1(subjectcatCat1PK);
            JSONArray jsonsubjects = toJSONArray(subjects);
            return jsonsubjects.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subjectcatCat1")
    @Override
    public void delete4subjectcatCat1(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ISubjectcatPK subjectcatCat1PK = JSONSubjectcat.toSubjectcatPK((JSONObject)parser.parse(json));
            blsubject.delete4subjectcatCat1(subjectcatCat1PK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4tree7subject")
    @Override
    public String getSubjects4tree7subject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ITree7subjectPK tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            ArrayList subjects = blsubject.getSubjects4tree7subject(tree7subjectPK);
            JSONArray jsonsubjects = toJSONArray(subjects);
            return jsonsubjects.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4tree7subject")
    @Override
    public void delete4tree7subject(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ITree7subjectPK tree7subjectPK = JSONTree7subject.toTree7subjectPK((JSONObject)parser.parse(json));
            blsubject.delete4tree7subject(tree7subjectPK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4subjectcatCat2")
    @Override
    public String getSubjects4subjectcatCat2(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ISubjectcatPK subjectcatCat2PK = JSONSubjectcat.toSubjectcatPK((JSONObject)parser.parse(json));
            ArrayList subjects = blsubject.getSubjects4subjectcatCat2(subjectcatCat2PK);
            JSONArray jsonsubjects = toJSONArray(subjects);
            return jsonsubjects.toJSONString();
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "delete4subjectcatCat2")
    @Override
    public void delete4subjectcatCat2(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            ISubjectcatPK subjectcatCat2PK = JSONSubjectcat.toSubjectcatPK((JSONObject)parser.parse(json));
            blsubject.delete4subjectcatCat2(subjectcatCat2PK);
        }
        catch(ParseException e) {
        }
    }

    //@WebMethod(operationName = "getSubjects4filmsubjects")
    @Override
    public String getSubjects4filmsubjects(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            String result = null;
            IFilmsubjectsPK filmsubjectsPK = JSONFilmsubjects.toFilmsubjectsPK((JSONObject)parser.parse(json));
            subject = (Subject)blsubject.getFilmsubjects(filmsubjectsPK);
            if(subject!=null) {
                result = JSONSubject.toJSON(subject).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }

    //@WebMethod(operationName = "getSubjects4photosubjects")
    @Override
    public String getSubjects4photosubjects(String json) {
        BLsubject blsubject = new BLsubject();
        JSONParser parser = new JSONParser();
        Subject subject;
        try {
            String result = null;
            IPhotosubjectsPK photosubjectsPK = JSONPhotosubjects.toPhotosubjectsPK((JSONObject)parser.parse(json));
            subject = (Subject)blsubject.getPhotosubjects(photosubjectsPK);
            if(subject!=null) {
                result = JSONSubject.toJSON(subject).toJSONString();
            }
            return result;
        }
        catch(ParseException e) {
            return null;
        }
        catch(DBException e) {
            return null;
        }
        catch(CustomException e) {
            return null;
        }
    }


}

