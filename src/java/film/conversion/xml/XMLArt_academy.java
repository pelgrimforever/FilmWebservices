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
import film.entity.pk.Art_academyPK;
import film.interfaces.entity.pk.IArt_academyPK;
import film.logicentity.Art_academy;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLArt_academy {
    
    public static void addXML(Element PK, IArt_academyPK art_academyPK) {
        PK.addContent(XMLElement.newContent("academyid", art_academyPK.getAcademyid()));
    }

    public static void addXML(Element Art_academyXML, Art_academy art_academy) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, art_academy.getPrimaryKey());
        Art_academyXML.addContent(PK);
        Art_academyXML.addContent(XMLElement.newContent("academy", art_academy.getAcademy()));
        Art_academyXML.addContent(XMLElement.newContent("academylocation", art_academy.getAcademylocation()));
    }
}

