/*
 * XMLMainmenu.java
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
import film.entity.pk.MainmenuPK;
import film.interfaces.entity.pk.IMainmenuPK;
import film.logicentity.Mainmenu;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

/**
 *
 * @author Franky Laseure
 */
public class XMLMainmenu {
    
    /**
     * 
     * @return all keys and fields as XML
     */
    public static void addXML(Element PK, IMainmenuPK mainmenuPK) {
        PK.addContent(XMLElement.newContent("mainmenu", mainmenuPK.getMainmenu()));
    }

    /**
     * 
     * @return all keys and fields in a JSONObject
     */
    public static void addXML(Element MainmenuXML, Mainmenu mainmenu) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, mainmenu.getPrimaryKey());
        MainmenuXML.addContent(PK);
        MainmenuXML.addContent(XMLElement.newContent("popuplabel", mainmenu.getPopuplabel()));
        MainmenuXML.addContent(XMLElement.newContent("icon", mainmenu.getIcon()));
    }
}

