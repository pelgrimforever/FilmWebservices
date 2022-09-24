/*
 * Created on Dec 23, 2012, 6:22 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.listeners;

import film.BusinessObject.security.Security;
import film.servlets.Contextparameters;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class FilmContextListener implements ServletContextListener, Contextparameters {
   
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        Security security = new Security();
        context.setAttribute(SECURITY, security);
    }

    public void contextDestroyed(ServletContextEvent event) {

    }
}

