/*
 * XMLArt_subgroup.java
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
import film.entity.pk.Art_subgroupPK;
import film.interfaces.entity.pk.IArt_subgroupPK;
import film.logicentity.Art_subgroup;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLArt_subgroup {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IArt_subgroupPK art_subgroupPK) {
        PK.addContent(XMLElement.newContent("subgroupid", art_subgroupPK.getSubgroupid()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element Art_subgroupXML, Art_subgroup art_subgroup) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, art_subgroup.getPrimaryKey());
        Art_subgroupXML.addContent(PK);
        if(art_subgroup.getArt_groupPK()!=null) {
            Element art_groupPK = XMLElement.newContent("art_groupPK", "");
            XMLArt_group.addXML(art_groupPK, art_subgroup.getArt_groupPK());
            Art_subgroupXML.addContent(art_groupPK);
        }
        Art_subgroupXML.addContent(XMLElement.newContent("subgroupname", art_subgroup.getSubgroupname()));
        Art_subgroupXML.addContent(XMLElement.newContent("lastseqno", art_subgroup.getLastseqno()));
    }
}

