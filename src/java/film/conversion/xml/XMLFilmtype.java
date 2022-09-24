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
import film.entity.pk.FilmtypePK;
import film.interfaces.entity.pk.IFilmtypePK;
import film.logicentity.Filmtype;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLFilmtype {
    
    public static void addXML(Element PK, IFilmtypePK filmtypePK) {
        PK.addContent(XMLElement.newContent("type", filmtypePK.getType()));
    }

    public static void addXML(Element FilmtypeXML, Filmtype filmtype) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, filmtype.getPrimaryKey());
        FilmtypeXML.addContent(PK);
        FilmtypeXML.addContent(XMLElement.newContent("description", filmtype.getDescription()));
    }
}

