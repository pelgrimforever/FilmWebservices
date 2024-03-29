/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
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

public class XMLSubjectcat {
    
    public static void addXML(Element PK, ISubjectcatPK subjectcatPK) {
        PK.addContent(XMLElement.newContent("cat", subjectcatPK.getCat()));
    }

    public static void addXML(Element SubjectcatXML, Subjectcat subjectcat) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, subjectcat.getPrimaryKey());
        SubjectcatXML.addContent(PK);
        SubjectcatXML.addContent(XMLElement.newContent("catno", subjectcat.getCatno()));
        SubjectcatXML.addContent(XMLElement.newContent("description", subjectcat.getDescription()));
    }
}

