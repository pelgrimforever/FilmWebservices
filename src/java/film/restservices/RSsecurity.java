/*
 * RSsecurity.java
 *
 * Generated on 24.9.2021 14:50
 *
 */

package film.restservices;

import base.servlets.DataHandler;
import base.servlets.Securitycheck;
import general.exception.DatahandlerException;
import java.io.IOException;
import org.json.simple.JSONObject;

/**
 *
 * @author Franky Laseure
 */
public class RSsecurity {
    
    public static boolean check(JSONObject json) throws DatahandlerException {
//Custom code, do not change this line   
//Change security check to your own needs
        try {
            String auth = (String)json.get("auth");
            if(auth!=null) {
                DataHandler.SERVER = "http://localhost:8080/";
                return Securitycheck.checkLoginstring(auth);
            } else return false;
        } 
        catch(IOException e) {
            return false;
        }        
/*
//This code can replace the above code for custom security check 
//if the project has a custom user table filmuser
        BLfilmuser blfilmuser = new BLfilmuser();
        String authstring = null;
        String username = "";
        String password = "";
        try {
            authstring = Securitycheck.decode((String)json.get("auth"));
        }
        catch(IOException ioe) {
        }
        catch(NullPointerException ioe) {
        }
        finally {
            username = Securitycheck.filterUsername(authstring);
            password = Securitycheck.filterPassword(authstring);
        }
        if(authstring!=null) {
            Filmuser founduser = blfilmuser.authenticate(username, password);
            return founduser!=null;
        } else return false;
*/
//Custom code, do not change this line   
    }
}
