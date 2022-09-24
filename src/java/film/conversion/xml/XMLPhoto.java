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
import film.entity.pk.PhotoPK;
import film.interfaces.entity.pk.IPhotoPK;
import film.logicentity.Photo;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLPhoto {
    
    public static void addXML(Element PK, IPhotoPK photoPK) {
        PK.addContent(XMLElement.newContent("film", photoPK.getFilm()));
        PK.addContent(XMLElement.newContent("id", photoPK.getId()));
    }

    public static void addXML(Element PhotoXML, Photo photo) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, photo.getPrimaryKey());
        PhotoXML.addContent(PK);
        if(photo.getRoutePK()!=null) {
            Element routePK = XMLElement.newContent("routePK", "");
            XMLRoute.addXML(routePK, photo.getRoutePK());
            PhotoXML.addContent(routePK);
        }
        if(photo.getCreatorPK()!=null) {
            Element creatorPK = XMLElement.newContent("creatorPK", "");
            XMLCreator.addXML(creatorPK, photo.getCreatorPK());
            PhotoXML.addContent(creatorPK);
        }
        PhotoXML.addContent(XMLElement.newContent("format", photo.getFormat()));
        PhotoXML.addContent(XMLElement.newContent("description", photo.getDescription()));
        if(photo.getPhotodate()!=null) {
            PhotoXML.addContent(XMLElement.newContent("photodate", photo.getPhotodate().getTime()));
        }
        if(photo.getPhototime()!=null) {
            PhotoXML.addContent(XMLElement.newContent("phototime", photo.getPhototime().getTime()));
        }
        PhotoXML.addContent(XMLElement.newContent("public", photo.getPublic()));
        PhotoXML.addContent(XMLElement.newContent("composition", photo.getComposition()));
        PhotoXML.addContent(XMLElement.newContent("rotation", photo.getRotation()));
        PhotoXML.addContent(XMLElement.newContent("backup", photo.getBackup()));
        PhotoXML.addContent(XMLElement.newContent("imagebackup", photo.getImagebackup()));
        if(photo.getLocation()!=null) {
            PhotoXML.addContent(XMLElement.newContent("location", GISConversion.toJSON(photo.getLocation()).toJSONString()));
        }
        PhotoXML.addContent(XMLElement.newContent("exactlocation", photo.getExactlocation()));
        PhotoXML.addContent(XMLElement.newContent("locationradius", photo.getLocationradius()));
        PhotoXML.addContent(XMLElement.newContent("reversegeocode", photo.getReversegeocode()));
        PhotoXML.addContent(XMLElement.newContent("streetnumber", photo.getStreetnumber()));
        PhotoXML.addContent(XMLElement.newContent("formattedaddress", photo.getFormattedaddress()));
    }
}

