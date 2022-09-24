/*
 * Created on March 26, 2007, 5:44 PM
 * Generated on 23.8.2022 14:35
 * @author Franky Laseure
 */

package film.HTTPtools.fileUpload;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class rawData {

    private HttpServletRequest thisRequest= null;

    public rawData(HttpServletRequest request) {
        thisRequest = request;
    }

    public String getData2HTML() throws IOException {
        String result = "<table>";
        //Get all lines and put them to html
        ServletInputStream servletData = thisRequest.getInputStream();
        byte[] b = new byte[8164];
        int len=0;
        int i=0;
        String line;
        while( (len = servletData.readLine(b, 0, b.length)) != -1 ) {
            line = new String(b, 0, len, "ISO-8859-1");
            result += "<tr><td>" + i + "</td>";
            result += "<td>" + line + "</td></tr>";
        }
        result += "</table>";
        return result;
    }
}
