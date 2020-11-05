package film.schedule;

import film.BusinessObject.Logic.BLphoto;
import general.log.ProjectLog;
import java.io.File;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author pelgrim
 */
@Singleton
public class Cleanuptemptask implements Runnable {
    
    @Schedule(hour="1", minute="0", second="0", persistent=false)
    public void run() {
        //construct "max" filename for files 2 days old
        long result = 0;
        Date t = new Date();
        result = t.getYear() % 1000;							//3 positions
        result = result * 100 + t.getMonth() + 1;		//5
        result = result * 100 + t.getDate()-2;			//7
        result = result * 100 + t.getHours();			//9
        result = result * 100 + t.getMinutes();			//11
        result = result * 100 + t.getSeconds();			//13
        result = result * 1000 + (t.getTime() % 1000);	//16
        result = result * 1000; //19 = positions of a signed long

        ProjectLog log = new ProjectLog(this);
        
        //compare with existing files, delete all that are < then result
        File tempfolder = new File(BLphoto.TEMPdestinationpath);
        log.info("Cleanuptemptask in directory " + tempfolder.getAbsolutePath());
        File[] files = tempfolder.listFiles();
        File file;
        String filename;
        long number;
        for(int i=0, l=files.length; i<l; i++) {
            file = files[i];
            if(file.isFile() && file.getName().endsWith(".jpg")) {
                filename = file.getName().substring(0, file.getName().indexOf("."));
                try {
                    number = Long.valueOf(filename).longValue();
                    if(number<result) {
                        file.delete();
                    }
                }
                catch(Exception e) {
                    System.out.println(filename + " error in conversion or deletion.");
                }
            }
        }
    }

    
}
