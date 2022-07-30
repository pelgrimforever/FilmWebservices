/*
 * XMLSubjectcat.java
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
import film.entity.pk.SubjectcatPK;
import film.interfaces.entity.pk.ISubjectcatPK;
import film.logicentity.Subjectcat;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSubjectcat {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISubjectcatPK subjectcatPK) {
        PK.addContent(XMLElement.newContent("cat", subjectcatPK.getCat()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element SubjectcatXML, Subjectcat subjectcat) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, subjectcat.getPrimaryKey());
        SubjectcatXML.addContent(PK);
        SubjectcatXML.addContent(XMLElement.newContent("catno", subjectcat.getCatno()));
        SubjectcatXML.addContent(XMLElement.newContent("description", subjectcat.getDescription()));
    }
}

