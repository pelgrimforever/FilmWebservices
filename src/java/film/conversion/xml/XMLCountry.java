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
import film.entity.pk.CountryPK;
import film.interfaces.entity.pk.ICountryPK;
import film.logicentity.Country;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLCountry {
    
    public static void addXML(Element PK, ICountryPK countryPK) {
        PK.addContent(XMLElement.newContent("code", countryPK.getCode()));
    }

    public static void addXML(Element CountryXML, Country country) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, country.getPrimaryKey());
        CountryXML.addContent(PK);
        CountryXML.addContent(XMLElement.newContent("name", country.getName()));
        if(country.getLocation()!=null) {
            CountryXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(country.getLocation()).toJSONString()));
        }
        if(country.getBounds()!=null) {
            CountryXML.addContent(XMLElement.newContent("bounds", GISConversion.toJSON(country.getBounds()).toJSONString()));
        }
        if(country.getViewport()!=null) {
            CountryXML.addContent(XMLElement.newContent("viewport", GISConversion.toJSON(country.getViewport()).toJSONString()));
        }
        CountryXML.addContent(XMLElement.newContent("approximate", country.getApproximate()));
        CountryXML.addContent(XMLElement.newContent("hasarealevel1", country.getHasarealevel1()));
        CountryXML.addContent(XMLElement.newContent("hasarealevel2", country.getHasarealevel2()));
        CountryXML.addContent(XMLElement.newContent("hasarealevel3", country.getHasarealevel3()));
    }
}

