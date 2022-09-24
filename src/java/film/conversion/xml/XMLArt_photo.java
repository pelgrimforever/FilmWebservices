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
import film.entity.pk.Art_photoPK;
import film.interfaces.entity.pk.IArt_photoPK;
import film.logicentity.Art_photo;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLArt_photo {
    
    public static void addXML(Element PK, IArt_photoPK art_photoPK) {
        PK.addContent(XMLElement.newContent("film", art_photoPK.getFilm()));
        PK.addContent(XMLElement.newContent("photo", art_photoPK.getPhoto()));
    }

    public static void addXML(Element Art_photoXML, Art_photo art_photo) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, art_photo.getPrimaryKey());
        Art_photoXML.addContent(PK);
        if(art_photo.getArt_subgroupPK()!=null) {
            Element art_subgroupPK = XMLElement.newContent("art_subgroupPK", "");
            XMLArt_subgroup.addXML(art_subgroupPK, art_photo.getArt_subgroupPK());
            Art_photoXML.addContent(art_subgroupPK);
        }
        if(art_photo.getArt_academyPK()!=null) {
            Element art_academyPK = XMLElement.newContent("art_academyPK", "");
            XMLArt_academy.addXML(art_academyPK, art_photo.getArt_academyPK());
            Art_photoXML.addContent(art_academyPK);
        }
        if(art_photo.getArt_groupPK()!=null) {
            Element art_groupPK = XMLElement.newContent("art_groupPK", "");
            XMLArt_group.addXML(art_groupPK, art_photo.getArt_groupPK());
            Art_photoXML.addContent(art_groupPK);
        }
        Art_photoXML.addContent(XMLElement.newContent("selection", art_photo.getSelection()));
        Art_photoXML.addContent(XMLElement.newContent("width", art_photo.getWidth()));
        Art_photoXML.addContent(XMLElement.newContent("height", art_photo.getHeight()));
        Art_photoXML.addContent(XMLElement.newContent("comment", art_photo.getComment()));
        Art_photoXML.addContent(XMLElement.newContent("seqno", art_photo.getSeqno()));
        Art_photoXML.addContent(XMLElement.newContent("archive", art_photo.getArchive()));
        Art_photoXML.addContent(XMLElement.newContent("surround", art_photo.getSurround()));
        Art_photoXML.addContent(XMLElement.newContent("surrounddir", art_photo.getSurrounddir()));
    }
}

