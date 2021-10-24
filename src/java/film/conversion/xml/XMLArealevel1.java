/*
 * XMLArealevel1.java
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
import film.entity.pk.Arealevel1PK;
import film.interfaces.entity.pk.IArealevel1PK;
import film.logicentity.Arealevel1;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLArealevel1 {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IArealevel1PK arealevel1PK) {
        PK.addContent(XMLElement.newContent("countrycode", arealevel1PK.getCountrycode()));
        PK.addContent(XMLElement.newContent("al1code", arealevel1PK.getAl1code()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Arealevel1XML, Arealevel1 arealevel1) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, arealevel1.getPrimaryKey());
        Arealevel1XML.addContent(PK);
        Arealevel1XML.addContent(XMLElement.newContent("name", arealevel1.getName()));
        if(arealevel1.getLocation()!=null) {
            Arealevel1XML.addContent(XMLElement.newContent("location", GISConversion.toJSON(arealevel1.getLocation()).toJSONString()));
        }
        if(arealevel1.getBounds()!=null) {
            Arealevel1XML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(arealevel1.getBounds()).toJSONString()));
        }
        if(arealevel1.getViewport()!=null) {
            Arealevel1XML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(arealevel1.getViewport()).toJSONString()));
        }
        Arealevel1XML.addContent(XMLElement.newContent("approximate", arealevel1.getApproximate()));
    }
}

