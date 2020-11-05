/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package film.restservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

/**
 * REST Web Service
 *
 * @author vlindertje
 */
@Path("test")
public class Test {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public Test() {
    }

    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html><body><h1>jippie</body></h1></html>";
/*        return "[{\"startdate\":964821600000,\"iso\":\"200\",\"PK\":{\"id\":\"590185\"},\"owner\":\"Kristien & Filip\",\"filmtypePK\":{\"type\":\"DIA\"},\"public\":false,\"enddate\":964994400000,\"backup\":true,\"cd\":\"590185\"}"
+ ",{\"startdate\":965512800000,\"iso\":\"200\",\"PK\":{\"id\":\"590190\"},\"owner\":\"Kristien & Filip\",\"filmtypePK\":{\"type\":\"DIA\"},\"public\":false,\"enddate\":965685600000,\"backup\":true,\"cd\":\"590190\"}"
+ ",{\"startdate\":999208800000,\"iso\":\"200\",\"PK\":{\"id\":\"896896\"},\"owner\":\"Kristien & Filip\",\"filmtypePK\":{\"type\":\"DIA\"},\"public\":false,\"enddate\":1030226400000,\"backup\":true,\"cd\":\"952158\"}"
+ ",{\"startdate\":964994400000,\"iso\":\"200\",\"PK\":{\"id\":\"896897\"},\"owner\":\"Kristien & Filip\",\"filmtypePK\":{\"type\":\"DIA\"},\"public\":false,\"enddate\":965080800000,\"backup\":true,\"cd\":\"651568\"}"
                + "]";*/
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
