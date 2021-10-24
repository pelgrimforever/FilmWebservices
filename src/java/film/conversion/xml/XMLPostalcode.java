/*
 * XMLPostalcode.java
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
import film.entity.pk.PostalcodePK;
import film.interfaces.entity.pk.IPostalcodePK;
import film.logicentity.Postalcode;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLPostalcode {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IPostalcodePK postalcodePK) {
        PK.addContent(XMLElement.newContent("countrycode", postalcodePK.getCountrycode()));
        PK.addContent(XMLElement.newContent("postalcode", postalcodePK.getPostalcode()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element PostalcodeXML, Postalcode postalcode) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, postalcode.getPrimaryKey());
        PostalcodeXML.addContent(PK);
        if(postalcode.getArealevel3PK()!=null) {
            Element arealevel3PK = XMLElement.newContent("arealevel3PK", "");
            XMLArealevel3.addXML(arealevel3PK, postalcode.getArealevel3PK());
            PostalcodeXML.addContent(arealevel3PK);
        }
        if(postalcode.getLocation()!=null) {
            PostalcodeXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(postalcode.getLocation()).toJSONString()));
        }
        if(postalcode.getBounds()!=null) {
            PostalcodeXML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(postalcode.getBounds()).toJSONString()));
        }
        if(postalcode.getViewport()!=null) {
            PostalcodeXML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(postalcode.getViewport()).toJSONString()));
        }
        PostalcodeXML.addContent(XMLElement.newContent("approximate", postalcode.getApproximate()));
    }
}

