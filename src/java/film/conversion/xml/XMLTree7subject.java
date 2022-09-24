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
import film.entity.pk.Tree7subjectPK;
import film.interfaces.entity.pk.ITree7subjectPK;
import film.logicentity.Tree7subject;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLTree7subject {
    
    public static void addXML(Element PK, ITree7subjectPK tree7subjectPK) {
        PK.addContent(XMLElement.newContent("subjectid", tree7subjectPK.getSubjectid()));
    }

    public static void addXML(Element Tree7subjectXML, Tree7subject tree7subject) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, tree7subject.getPrimaryKey());
        Tree7subjectXML.addContent(PK);
        if(tree7subject.getTree7subjectparentsubjectidPK()!=null) {
            Element tree7subjectParentsubjectidPK = XMLElement.newContent("tree7subjectParentsubjectidPK", "");
            XMLTree7subject.addXML(tree7subjectParentsubjectidPK, tree7subject.getTree7subjectparentsubjectidPK());
            Tree7subjectXML.addContent(tree7subjectParentsubjectidPK);
        }
        Tree7subjectXML.addContent(XMLElement.newContent("tree7id", tree7subject.getTree7id()));
        Tree7subjectXML.addContent(XMLElement.newContent("subject", tree7subject.getSubject()));
        Tree7subjectXML.addContent(XMLElement.newContent("treestep", tree7subject.getTreestep()));
    }
}

