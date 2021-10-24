/*
 * XMLUploadsession.java
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
import film.entity.pk.UploadsessionPK;
import film.interfaces.entity.pk.IUploadsessionPK;
import film.logicentity.Uploadsession;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLUploadsession {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IUploadsessionPK uploadsessionPK) {
        PK.addContent(XMLElement.newContent("filename", uploadsessionPK.getFilename()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
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

