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
import film.entity.pk.SecurityuserprofilePK;
import film.interfaces.entity.pk.ISecurityuserprofilePK;
import film.logicentity.Securityuserprofile;
import film.searchentity.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Iterator;
import org.jdom2.Element;

public class XMLSecurityuserprofile {
    
    public static void addXML(Element PK, ISecurityuserprofilePK securityuserprofilePK) {
        PK.addContent(XMLElement.newContent("siteusername", securityuserprofilePK.getSiteusername()));
        PK.addContent(XMLElement.newContent("userprofile", securityuserprofilePK.getUserprofile()));
    }

    public static void addXML(Element SecurityuserprofileXML, Securityuserprofile securityuserprofile) {
        Element PK = XMLElement.newContent("PK", "");
        addXML(PK, securityuserprofile.getPrimaryKey());
        SecurityuserprofileXML.addContent(PK);
    }
}

