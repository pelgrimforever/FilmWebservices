/*
 * XMLSpatial_ref_sys.java
 *
 * Created on March 26, 2007, 5:44 PM
 * Generated on 5.5.2022 10:45
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
import film.entity.pk.Spatial_ref_sysPK;
import film.interfaces.entity.pk.ISpatial_ref_sysPK;
import film.logicentity.Spatial_ref_sys;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLSpatial_ref_sys {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, ISpatial_ref_sysPK spatial_ref_sysPK) {
        PK.addContent(XMLElement.newContent("srid", spatial_ref_sysPK.getSrid()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Spatial_ref_sysXML, Spatial_ref_sys spatial_ref_sys) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, spatial_ref_sys.getPrimaryKey());
        Spatial_ref_sysXML.addContent(PK);
        Spatial_ref_sysXML.addContent(XMLElement.newContent("auth_name", spatial_ref_sys.getAuth_name()));
        Spatial_ref_sysXML.addContent(XMLElement.newContent("auth_srid", spatial_ref_sys.getAuth_srid()));
        Spatial_ref_sysXML.addContent(XMLElement.newContent("srtext", spatial_ref_sys.getSrtext()));
        Spatial_ref_sysXML.addContent(XMLElement.newContent("proj4text", spatial_ref_sys.getProj4text()));
    }
}

