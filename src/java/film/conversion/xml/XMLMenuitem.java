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
import film.entity.pk.MenuitemPK;
import film.interfaces.entity.pk.IMenuitemPK;
import film.logicentity.Menuitem;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLMenuitem {
    
    public static void addXML(Element PK, IMenuitemPK menuitemPK) {
        PK.addContent(XMLElement.newContent("mainmenu", menuitemPK.getMainmenu()));
        PK.addContent(XMLElement.newContent("menu", menuitemPK.getMenu()));
        PK.addContent(XMLElement.newContent("menuitem", menuitemPK.getMenuitem()));
    }

    public static void addXML(Element MenuitemXML, Menuitem menuitem) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, menuitem.getPrimaryKey());
        MenuitemXML.addContent(PK);
        MenuitemXML.addContent(XMLElement.newContent("tabpanel", menuitem.getTabpanel()));
        MenuitemXML.addContent(XMLElement.newContent("editpanel", menuitem.getEditpanel()));
        MenuitemXML.addContent(XMLElement.newContent("servlet", menuitem.getServlet()));
    }
}

