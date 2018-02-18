import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * Created by arman12 on 15/10/2015.
 * this app creates n number folders and copies file into them
 */
public class FolderCreator {

    public static void main(String[] args) throws InterruptedException, IOException{

        String fileName="";
        Path source = Paths.get("/home/arman12/Dropbox/time5/out/production/time5/file.pdf");
        // create folders and copy files
        for(int i=1;i<11;i++) {
            String strDirectoy = Integer.toString(i);
            try {
                boolean success = (new File(strDirectoy)).mkdir();
                if (success) {
                    System.out.println("Directory: " + strDirectoy + " created");
                    // copy files
                    Path destination = Paths.get("/home/arman12/Dropbox/time5/"+i+"/"+i+".pdf");

                    try {
                        Files.copy(source, destination);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {//Catch exception if any
                System.err.println("Error: " + e.getMessage());
            } // end of catch
        } // end of for loop
    } // end of main
}
