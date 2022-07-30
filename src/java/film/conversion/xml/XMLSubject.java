/*
 * XMLSubject.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2022 10:45
 *
 */
 
package film.conversion.xml;

import XML.XMLElement;
import java.io.IOException;
import object.Objectoperation;
import data.conversion.JSONConversion;
import data.gis.shape.GISConversion;
import data.interfaces.db.EntityPK;
import data.interfaces.db.Fieldsearcher;
import film.entity.pk.SubjectPK;
import film.interfaces.entity.pk.ISubjectPK;
import film.logicentity.Subject;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSubject {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISubjectPK subjectPK) {
        PK.addContent(XMLElement.newContent("cat1", subjectPK.getCat1()));
        PK.addContent(XMLElement.newContent("cat2", subjectPK.getCat2()));
        PK.addContent(XMLElement.newContent("id", subjectPK.getId()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SubjectXML, Subject subject) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, subject.getPrimaryKey());
        SubjectXML.addContent(PK);
        if(subject.getTree7subjectPK()!=null) {
            Element tree7subjectPK = XMLElement.newContent("tree7subjectPK", "");
            XMLTree7subject.addXML(tree7subjectPK, subject.getTree7subjectPK());
            SubjectXML.addContent(tree7subjectPK);
        }
        SubjectXML.addContent(XMLElement.newContent("subject", subject.getSubject()));
        SubjectXML.addContent(XMLElement.newContent("description", subject.getDescription()));
    }
}

