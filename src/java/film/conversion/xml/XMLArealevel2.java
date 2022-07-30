/*
 * XMLArealevel2.java
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
import film.entity.pk.Arealevel2PK;
import film.interfaces.entity.pk.IArealevel2PK;
import film.logicentity.Arealevel2;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLArealevel2 {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IArealevel2PK arealevel2PK) {
        PK.addContent(XMLElement.newContent("countrycode", arealevel2PK.getCountrycode()));
        PK.addContent(XMLElement.newContent("al1code", arealevel2PK.getAl1code()));
        PK.addContent(XMLElement.newContent("al2code", arealevel2PK.getAl2code()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Arealevel2XML, Arealevel2 arealevel2) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, arealevel2.getPrimaryKey());
        Arealevel2XML.addContent(PK);
        Arealevel2XML.addContent(XMLElement.newContent("name", arealevel2.getName()));
        if(arealevel2.getLocation()!=null) {
            Arealevel2XML.addContent(XMLElement.newContent("location", GISConversion.toJSON(arealevel2.getLocation()).toJSONString()));
        }
        if(arealevel2.getBounds()!=null) {
            Arealevel2XML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(arealevel2.getBounds()).toJSONString()));
        }
        if(arealevel2.getViewport()!=null) {
            Arealevel2XML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(arealevel2.getViewport()).toJSONString()));
        }
        Arealevel2XML.addContent(XMLElement.newContent("approximate", arealevel2.getApproximate()));
    }
}

