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
import film.entity.pk.PhotosubjectsPK;
import film.interfaces.entity.pk.IPhotosubjectsPK;
import film.logicentity.Photosubjects;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLPhotosubjects {
    
    public static void addXML(Element PK, IPhotosubjectsPK photosubjectsPK) {
        PK.addContent(XMLElement.newContent("film", photosubjectsPK.getFilm()));
        PK.addContent(XMLElement.newContent("id", photosubjectsPK.getId()));
        PK.addContent(XMLElement.newContent("cat1", photosubjectsPK.getCat1()));
        PK.addContent(XMLElement.newContent("cat2", photosubjectsPK.getCat2()));
        PK.addContent(XMLElement.newContent("subject", photosubjectsPK.getSubject()));
    }

    public static void addXML(Element PhotosubjectsXML, Photosubjects photosubjects) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, photosubjects.getPrimaryKey());
        PhotosubjectsXML.addContent(PK);
    }
}

