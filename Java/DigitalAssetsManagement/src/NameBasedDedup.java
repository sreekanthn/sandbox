/* Utility that does the following
*  Finds possible duplicated images/other files in different directories based on name (Not based on content)
*  Each run instance destroys it's storage at the end of the run; so it has no state after the run
* */

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.io.FilenameUtils;

public class NameBasedDedup {

    //using a HashMap as the number of files I am dealing with is a few 100 thousands.
    // Need O(1) lookup as far as possible

    private HashMap<String, ArrayList<String>> nameMap = new HashMap();


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
        dedup.printResults();
    }

    private void processFiles(File f) {

        // it is a file, and clean it up
        if (f.isDirectory()){ //nested directories
            File[] listOfFiles = f.listFiles();
            if (listOfFiles != null) {
                for (File file: listOfFiles){
                    if (file.isDirectory()){
                        //call recursively for all sub directories
                        processFiles(file);
                    }
                    else{
                        // it is a file, and clean it up
                        dedupFiles(file);
                    }
                }
            }
        }
        else dedupFiles(f);

    }

    private void dedupFiles(File file) {
        String path = file.getAbsolutePath();
        String fileName = FilenameUtils.getBaseName(String.valueOf(file));
        ArrayList<String> pathList;

        if  (!nameMap.containsKey(fileName)){
            pathList = new ArrayList<>();
            pathList.add(path);
            nameMap.put(fileName, pathList);
        }
        else {
            pathList = nameMap.get(fileName);
            pathList.add(path);
        }

    }

    private void printResults() {
        for (String key:nameMap.keySet()) {
            ArrayList<String> value = nameMap.get(key);
            if (value.size() > 1)
            {
                System.out.printf( "File %s has been found at multiple locations \n", key);
                for (String path:value) {
                    System.out.printf("%s \n" , path);
                }
                System.out.println();
            }
        }
    }

}
