/*
 * SecurityDataServlet.java
 *
 * Created on Dec 23, 2012, 6:33 PM
 * Generated on 24.11.2012 14:11
 *
 */

package film.servlets;

import base.servlets.DataHandler;
import base.servlets.Securitycheck;
import film.BusinessObject.security.Security;
import film.logic.Userprofile;
import general.exception.CustomException;
import general.exception.DBException;
import general.exception.DatahandlerException;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import sitesecurity.logicentity.Sitegroup;

/**
 *
 * @author pelgrim
 */
public abstract class SecurityDataServlet extends DataServlet implements Contextparameters {
//ProjectGenerator: NO AUTHOMATIC UPDATE

    protected Userprofile userprofile = null;
    
    protected void loadAuthorization(HttpServletRequest request) throws IOException {
        userID = null;
        password = null;
        authenticated = false;
        HttpSession session = request.getSession();
        userprofile = (Userprofile)session.getAttribute("userprofile");
        if(userprofile==null) {
            getAuthorisation(request);
            synchronized(getServletContext()) {
                ServletContext context = getServletContext();
                DataHandler.SERVER = "http://localhost:8080/";
                try {
                    authenticated = Securitycheck.checkLogin(userID, password);
                }
                catch(DatahandlerException e) {
                }
                if(authenticated) {
                    Security security = (Security)context.getAttribute(SECURITY);
                    try {
                        ArrayList<Sitegroup> sitegroups = security.getGroups(userID);
                        ArrayList profiles = new ArrayList();
                        for(Sitegroup sitegroup: sitegroups) {
                            profiles.addAll(security.getProfiles(sitegroup.getPrimaryKey().getGroupname()));
                        }
                        userprofile = new Userprofile(sitegroups, profiles);
                        session.setAttribute("userprofile", userprofile);
                    }
                    catch(DBException | DatahandlerException e) {
                    }
                    catch(CustomException e) {
                    }
                }
            }
        } else {
            authenticated = true;
        }
    }

}

