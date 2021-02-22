/*
 * PhotoImage.java
 *
 * Created on Feb 08, 2021, 15:22 PM
 * Custom Image retriever in addition to REST services
 *
 */

package film.servlets.data;

import base.interfaces.servlet.IDataServlet;
import data.conversion.JSONConversion;
import film.BusinessObject.Logic.*;
import film.conversion.json.JSONPhoto;
import general.exception.CustomException;
import film.interfaces.entity.pk.*;
import film.interfaces.servlet.IPhotoOperation;
import film.restservices.RSsecurity;
import film.servlets.DataServlet;
import film.servlets.SecurityDataServlet;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Franky Laseure
 */
@WebServlet(name="PhotoImage", urlPatterns={"/film.PhotoImage"})
public class PhotoImage extends javax.servlet.http.HttpServlet implements IDataServlet, SingleThreadModel {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String result = "";
        BLphoto blphoto = new BLphoto();
        StringBuffer jsonstring = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
              jsonstring.append(line);
            }
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject)parser.parse(jsonstring.toString());        
            JSONObject jsonoperation = (JSONObject)json.get("operation");
            byte operationtype = JSONConversion.getbyte(jsonoperation, "type");
            byte operation = JSONConversion.getbyte(jsonoperation, "operation");
            boolean loggedin = RSsecurity.check(json);
            blphoto.setAuthenticated(loggedin);

            IPhotoPK photoPK = (IPhotoPK)JSONPhoto.toPhotoPK((JSONObject)json.get("photopk"));
            switch(operationtype) {
                case DataServlet.OPERATIONTYPE_SELECT:
                    switch(operation) {
                        case IPhotoOperation.GETTHUMBNAIL:
                            response.setContentType("image/jpeg");
                            BufferedImage bi = ImageIO.read(blphoto.getThumbnail(photoPK));
                            OutputStream out = response.getOutputStream();
                            ImageIO.write(bi, "jpg", out);
                            out.close();
                        case IPhotoOperation.GETSMALL:
                            response.setContentType("image/jpeg");
                            BufferedImage bismall = ImageIO.read(blphoto.getSmall(photoPK));
                            OutputStream outsmall = response.getOutputStream();
                            ImageIO.write(bismall, "jpg", outsmall);
                            outsmall.close();
                    }
            }
        } 
        catch(ParseException e) {
            result = returnstatus(e.getMessage());
        }
        catch(CustomException e) {
            result = returnstatus(e.getMessage());
        }
        finally {
        }
    } 

    private String returnstatus(String status) {
        JSONObject json = new JSONObject();
        json.put("status", status);
        return json.toJSONString();
    }

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }  	

    /* (non-Java-doc)
     * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }   	  	  

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "photo";
    }

}

