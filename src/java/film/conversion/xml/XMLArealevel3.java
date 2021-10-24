/*
 * XMLArealevel3.java
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
import film.entity.pk.Arealevel3PK;
import film.interfaces.entity.pk.IArealevel3PK;
import film.logicentity.Arealevel3;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLArealevel3 {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IArealevel3PK arealevel3PK) {
        PK.addContent(XMLElement.newContent("countrycode", arealevel3PK.getCountrycode()));
        PK.addContent(XMLElement.newContent("al1code", arealevel3PK.getAl1code()));
        PK.addContent(XMLElement.newContent("al2code", arealevel3PK.getAl2code()));
        PK.addContent(XMLElement.newContent("al3code", arealevel3PK.getAl3code()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Arealevel3XML, Arealevel3 arealevel3) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, arealevel3.getPrimaryKey());
        Arealevel3XML.addContent(PK);
        Arealevel3XML.addContent(XMLElement.newContent("name", arealevel3.getName()));
        if(arealevel3.getLocation()!=null) {
            Arealevel3XML.addContent(XMLElement.newContent("location", GISConversion.toJSON(arealevel3.getLocation()).toJSONString()));
        }
        if(arealevel3.getBounds()!=null) {
            Arealevel3XML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(arealevel3.getBounds()).toJSONString()));
        }
        if(arealevel3.getViewport()!=null) {
            Arealevel3XML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(arealevel3.getViewport()).toJSONString()));
        }
        Arealevel3XML.addContent(XMLElement.newContent("approximate", arealevel3.getApproximate()));
    }
}

