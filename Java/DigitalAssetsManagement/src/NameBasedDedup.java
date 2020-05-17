/* Utility that does the following
*  Finds possible duplicated images/other files in different directories based on name (Not based on content)
*  Each run instance destroys it's storage at the end of the run; so it has no state after the run
* */

import java.io.File;
import java.util.HashMap;

public class NameBasedDedup {

    //using a HashMap as the number of files I am dealing with is a few 100 thousands.
    // Need O(1) lookup as far as possible

    private HashMap<String, Long> nameMap = new HashMap();

    public static void main(String[] args) {

        NameBasedDedup dedup = new NameBasedDedup();
        if (args == null || args.length < 1){
            System.out.println("Usage : java NameBasedDedup <DIR_PATH>");
            System.exit(0);
        }
        else{
            String path = args[0];
            File dir = new File(path);
            if (dir.isDirectory()){
                File[] listOfFiles = dir.listFiles();
                if (listOfFiles != null) {
                    for (File f:listOfFiles) {
                        dedup.processFiles(f);
                    }
                }
            }
            else {
                System.out.println("Usage: the argument has to be a directory");
                System.exit(0);
            }
        }
    }

    private void processFiles(File f) {



    }


}
