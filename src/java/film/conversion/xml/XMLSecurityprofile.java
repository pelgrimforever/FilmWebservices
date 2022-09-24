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
import film.entity.pk.SecurityprofilePK;
import film.interfaces.entity.pk.ISecurityprofilePK;
import film.logicentity.Securityprofile;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLSecurityprofile {
    
    public static void addXML(Element PK, ISecurityprofilePK securityprofilePK) {
        PK.addContent(XMLElement.newContent("userprofile", securityprofilePK.getUserprofile()));
    }

    public static void addXML(Element SecurityprofileXML, Securityprofile securityprofile) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, securityprofile.getPrimaryKey());
        SecurityprofileXML.addContent(PK);
        SecurityprofileXML.addContent(XMLElement.newContent("privateaccess", securityprofile.getPrivateaccess()));
    }
}

