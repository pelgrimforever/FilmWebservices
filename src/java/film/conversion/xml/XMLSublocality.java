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
import film.entity.pk.SublocalityPK;
import film.interfaces.entity.pk.ISublocalityPK;
import film.logicentity.Sublocality;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLSublocality {
    
    public static void addXML(Element PK, ISublocalityPK sublocalityPK) {
        PK.addContent(XMLElement.newContent("countrycode", sublocalityPK.getCountrycode()));
        PK.addContent(XMLElement.newContent("postalcode", sublocalityPK.getPostalcode()));
        PK.addContent(XMLElement.newContent("locality", sublocalityPK.getLocality()));
        PK.addContent(XMLElement.newContent("sublocality", sublocalityPK.getSublocality()));
    }

    public static void addXML(Element SublocalityXML, Sublocality sublocality) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, sublocality.getPrimaryKey());
        SublocalityXML.addContent(PK);
        if(sublocality.getLocation()!=null) {
            SublocalityXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(sublocality.getLocation()).toJSONString()));
        }
        if(sublocality.getBounds()!=null) {
            SublocalityXML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(sublocality.getBounds()).toJSONString()));
        }
        if(sublocality.getViewport()!=null) {
            SublocalityXML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(sublocality.getViewport()).toJSONString()));
        }
        SublocalityXML.addContent(XMLElement.newContent("approximate", sublocality.getApproximate()));
    }
}

