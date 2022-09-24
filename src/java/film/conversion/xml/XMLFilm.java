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
import film.entity.pk.FilmPK;
import film.interfaces.entity.pk.IFilmPK;
import film.logicentity.Film;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLFilm {
    
    public static void addXML(Element PK, IFilmPK filmPK) {
        PK.addContent(XMLElement.newContent("id", filmPK.getId()));
    }

    public static void addXML(Element FilmXML, Film film) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, film.getPrimaryKey());
        FilmXML.addContent(PK);
        if(film.getFilmtypePK()!=null) {
            Element filmtypePK = XMLElement.newContent("filmtypePK", "");
            XMLFilmtype.addXML(filmtypePK, film.getFilmtypePK());
            FilmXML.addContent(filmtypePK);
        }
        FilmXML.addContent(XMLElement.newContent("iso", film.getIso()));
        if(film.getStartdate()!=null) {
            FilmXML.addContent(XMLElement.newContent("startdate", film.getStartdate().getTime()));
        }
        if(film.getEnddate()!=null) {
            FilmXML.addContent(XMLElement.newContent("enddate", film.getEnddate().getTime()));
        }
        FilmXML.addContent(XMLElement.newContent("owner", film.getOwner()));
        FilmXML.addContent(XMLElement.newContent("cd", film.getCd()));
        FilmXML.addContent(XMLElement.newContent("public", film.getPublic()));
        FilmXML.addContent(XMLElement.newContent("backup", film.getBackup()));
    }
}

