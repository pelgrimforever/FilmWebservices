/*
 * XMLFilmsubjects.java
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
import film.entity.pk.FilmsubjectsPK;
import film.interfaces.entity.pk.IFilmsubjectsPK;
import film.logicentity.Filmsubjects;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLFilmsubjects {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IFilmsubjectsPK filmsubjectsPK) {
        PK.addContent(XMLElement.newContent("film", filmsubjectsPK.getFilm()));
        PK.addContent(XMLElement.newContent("cat1", filmsubjectsPK.getCat1()));
        PK.addContent(XMLElement.newContent("cat2", filmsubjectsPK.getCat2()));
        PK.addContent(XMLElement.newContent("subject", filmsubjectsPK.getSubject()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element FilmsubjectsXML, Filmsubjects filmsubjects) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, filmsubjects.getPrimaryKey());
        FilmsubjectsXML.addContent(PK);
    }
}

