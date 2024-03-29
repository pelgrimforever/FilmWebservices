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
import film.entity.pk.Art_groupPK;
import film.interfaces.entity.pk.IArt_groupPK;
import film.logicentity.Art_group;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLArt_group {
    
    public static void addXML(Element PK, IArt_groupPK art_groupPK) {
        PK.addContent(XMLElement.newContent("groupid", art_groupPK.getGroupid()));
    }

    public static void addXML(Element Art_groupXML, Art_group art_group) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, art_group.getPrimaryKey());
        Art_groupXML.addContent(PK);
        Art_groupXML.addContent(XMLElement.newContent("groupname", art_group.getGroupname()));
    }
}

