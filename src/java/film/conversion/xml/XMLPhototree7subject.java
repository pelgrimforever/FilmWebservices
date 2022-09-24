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
import film.entity.pk.Phototree7subjectPK;
import film.interfaces.entity.pk.IPhototree7subjectPK;
import film.logicentity.Phototree7subject;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLPhototree7subject {
    
    public static void addXML(Element PK, IPhototree7subjectPK phototree7subjectPK) {
        PK.addContent(XMLElement.newContent("film", phototree7subjectPK.getFilm()));
        PK.addContent(XMLElement.newContent("id", phototree7subjectPK.getId()));
        PK.addContent(XMLElement.newContent("subjectid", phototree7subjectPK.getSubjectid()));
    }

    public static void addXML(Element Phototree7subjectXML, Phototree7subject phototree7subject) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, phototree7subject.getPrimaryKey());
        Phototree7subjectXML.addContent(PK);
    }
}

