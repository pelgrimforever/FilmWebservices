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
import film.entity.pk.PhototagsPK;
import film.interfaces.entity.pk.IPhototagsPK;
import film.logicentity.Phototags;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLPhototags {
    
    public static void addXML(Element PK, IPhototagsPK phototagsPK) {
        PK.addContent(XMLElement.newContent("film", phototagsPK.getFilm()));
        PK.addContent(XMLElement.newContent("id", phototagsPK.getId()));
        PK.addContent(XMLElement.newContent("tag", phototagsPK.getTag()));
    }

    public static void addXML(Element PhototagsXML, Phototags phototags) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, phototags.getPrimaryKey());
        PhototagsXML.addContent(PK);
        PhototagsXML.addContent(XMLElement.newContent("tagformat", phototags.getTagformat()));
        PhototagsXML.addContent(XMLElement.newContent("tagvalue", phototags.getTagvalue()));
    }
}

