/*
 * XMLUploadsessionsettings.java
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
import film.entity.pk.UploadsessionsettingsPK;
import film.interfaces.entity.pk.IUploadsessionsettingsPK;
import film.logicentity.Uploadsessionsettings;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLUploadsessionsettings {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IUploadsessionsettingsPK uploadsessionsettingsPK) {
        PK.addContent(XMLElement.newContent("directory", uploadsessionsettingsPK.getDirectory()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element UploadsessionsettingsXML, Uploadsessionsettings uploadsessionsettings) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, uploadsessionsettings.getPrimaryKey());
        UploadsessionsettingsXML.addContent(PK);
        UploadsessionsettingsXML.addContent(XMLElement.newContent("uploadtype", uploadsessionsettings.getUploadtype()));
        UploadsessionsettingsXML.addContent(XMLElement.newContent("filmgroups", uploadsessionsettings.getFilmgroups()));
        UploadsessionsettingsXML.addContent(XMLElement.newContent("lastposition", uploadsessionsettings.getLastposition()));
        UploadsessionsettingsXML.addContent(XMLElement.newContent("copymode", uploadsessionsettings.getCopymode()));
        UploadsessionsettingsXML.addContent(XMLElement.newContent("uploadingposition", uploadsessionsettings.getUploadingposition()));
    }
}

