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
import film.entity.pk.LocalityPK;
import film.interfaces.entity.pk.ILocalityPK;
import film.logicentity.Locality;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLLocality {
    
    public static void addXML(Element PK, ILocalityPK localityPK) {
        PK.addContent(XMLElement.newContent("countrycode", localityPK.getCountrycode()));
        PK.addContent(XMLElement.newContent("postalcode", localityPK.getPostalcode()));
        PK.addContent(XMLElement.newContent("locality", localityPK.getLocality()));
    }

    public static void addXML(Element LocalityXML, Locality locality) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, locality.getPrimaryKey());
        LocalityXML.addContent(PK);
        if(locality.getLocation()!=null) {
            LocalityXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(locality.getLocation()).toJSONString()));
        }
        if(locality.getBounds()!=null) {
            LocalityXML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(locality.getBounds()).toJSONString()));
        }
        if(locality.getViewport()!=null) {
            LocalityXML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(locality.getViewport()).toJSONString()));
        }
        LocalityXML.addContent(XMLElement.newContent("approximate", locality.getApproximate()));
        LocalityXML.addContent(XMLElement.newContent("hassublocality", locality.getHassublocality()));
    }
}

