/*
 * XMLFilmtype.java
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
import film.entity.pk.FilmtypePK;
import film.interfaces.entity.pk.IFilmtypePK;
import film.logicentity.Filmtype;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLFilmtype {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IFilmtypePK filmtypePK) {
        PK.addContent(XMLElement.newContent("type", filmtypePK.getType()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element FilmtypeXML, Filmtype filmtype) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, filmtype.getPrimaryKey());
        FilmtypeXML.addContent(PK);
        FilmtypeXML.addContent(XMLElement.newContent("description", filmtype.getDescription()));
    }
}

