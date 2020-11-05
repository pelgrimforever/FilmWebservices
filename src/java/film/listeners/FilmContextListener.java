/*
 * FilmContextListener.java
 *
 * Created on Dec 23, 2012, 6:22 PM
 * Generated on 25.9.2020 11:35
 *
 */

package film.listeners;

import film.BusinessObject.security.Security;
import film.servlets.Contextparameters;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Laseure Franky
 */
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

