/*
 * XMLCreator.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 24.9.2021 14:50
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
import film.entity.pk.CreatorPK;
import film.interfaces.entity.pk.ICreatorPK;
import film.logicentity.Creator;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLCreator {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ICreatorPK creatorPK) {
        PK.addContent(XMLElement.newContent("creatorid", creatorPK.getCreatorid()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element CreatorXML, Creator creator) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, creator.getPrimaryKey());
        CreatorXML.addContent(PK);
        CreatorXML.addContent(XMLElement.newContent("name", creator.getName()));
        CreatorXML.addContent(XMLElement.newContent("surname", creator.getSurname()));
    }
}

