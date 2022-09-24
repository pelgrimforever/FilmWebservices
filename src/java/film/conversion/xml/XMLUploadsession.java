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
import film.entity.pk.UploadsessionPK;
import film.interfaces.entity.pk.IUploadsessionPK;
import film.logicentity.Uploadsession;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLUploadsession {
    
    public static void addXML(Element PK, IUploadsessionPK uploadsessionPK) {
        PK.addContent(XMLElement.newContent("filename", uploadsessionPK.getFilename()));
    }

    public static void addXML(Element UploadsessionXML, Uploadsession uploadsession) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, uploadsession.getPrimaryKey());
        UploadsessionXML.addContent(PK);
        if(uploadsession.getCreatorPK()!=null) {
            Element creatorPK = XMLElement.newContent("creatorPK", "");
            XMLCreator.addXML(creatorPK, uploadsession.getCreatorPK());
            UploadsessionXML.addContent(creatorPK);
        }
        UploadsessionXML.addContent(XMLElement.newContent("upload", uploadsession.getUpload()));
        UploadsessionXML.addContent(XMLElement.newContent("rotation", uploadsession.getRotation()));
        UploadsessionXML.addContent(XMLElement.newContent("filmgroupid", uploadsession.getFilmgroupid()));
        UploadsessionXML.addContent(XMLElement.newContent("photosubjects", uploadsession.getPhotosubjects()));
        UploadsessionXML.addContent(XMLElement.newContent("description", uploadsession.getDescription()));
    }
}

