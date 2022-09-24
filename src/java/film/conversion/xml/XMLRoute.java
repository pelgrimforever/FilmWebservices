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
import film.entity.pk.RoutePK;
import film.interfaces.entity.pk.IRoutePK;
import film.logicentity.Route;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLRoute {
    
    public static void addXML(Element PK, IRoutePK routePK) {
        PK.addContent(XMLElement.newContent("countrycode", routePK.getCountrycode()));
        PK.addContent(XMLElement.newContent("postalcode", routePK.getPostalcode()));
        PK.addContent(XMLElement.newContent("locality", routePK.getLocality()));
        PK.addContent(XMLElement.newContent("sublocality", routePK.getSublocality()));
        PK.addContent(XMLElement.newContent("routecode", routePK.getRoutecode()));
    }

    public static void addXML(Element RouteXML, Route route) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, route.getPrimaryKey());
        RouteXML.addContent(PK);
        RouteXML.addContent(XMLElement.newContent("name", route.getName()));
        if(route.getLocation()!=null) {
            RouteXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(route.getLocation()).toJSONString()));
        }
        if(route.getBounds()!=null) {
            RouteXML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(route.getBounds()).toJSONString()));
        }
        if(route.getViewport()!=null) {
            RouteXML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(route.getViewport()).toJSONString()));
        }
        RouteXML.addContent(XMLElement.newContent("approximate", route.getApproximate()));
    }
}

