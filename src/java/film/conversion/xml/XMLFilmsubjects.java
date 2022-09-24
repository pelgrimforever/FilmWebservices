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
import film.entity.pk.FilmsubjectsPK;
import film.interfaces.entity.pk.IFilmsubjectsPK;
import film.logicentity.Filmsubjects;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLFilmsubjects {
    
    public static void addXML(Element PK, IFilmsubjectsPK filmsubjectsPK) {
        PK.addContent(XMLElement.newContent("film", filmsubjectsPK.getFilm()));
        PK.addContent(XMLElement.newContent("cat1", filmsubjectsPK.getCat1()));
        PK.addContent(XMLElement.newContent("cat2", filmsubjectsPK.getCat2()));
        PK.addContent(XMLElement.newContent("subject", filmsubjectsPK.getSubject()));
    }

    public static void addXML(Element FilmsubjectsXML, Filmsubjects filmsubjects) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, filmsubjects.getPrimaryKey());
        FilmsubjectsXML.addContent(PK);
    }
}

