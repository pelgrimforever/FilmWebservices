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
import film.entity.pk.MenuPK;
import film.interfaces.entity.pk.IMenuPK;
import film.logicentity.Menu;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLMenu {
    
    public static void addXML(Element PK, IMenuPK menuPK) {
        PK.addContent(XMLElement.newContent("mainmenu", menuPK.getMainmenu()));
        PK.addContent(XMLElement.newContent("menu", menuPK.getMenu()));
    }

    public static void addXML(Element MenuXML, Menu menu) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, menu.getPrimaryKey());
        MenuXML.addContent(PK);
    }
}

