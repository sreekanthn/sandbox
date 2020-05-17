import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class Cleaner
{
    private File dirForCleanup;
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();

        if (args == null || args.length < 2){
            System.out.println("Usage : java Cleaner <DIR_PATH> <FILE_EXTENSION>");
            System.exit(0);
        }
        else{
            String path = args[0];
            File dir = new File(path);
            String fileExtension = args[1];
            if (dir.isDirectory()){
                File[] listOfFiles = dir.listFiles();
                if (listOfFiles != null) {
                    for (File f:listOfFiles) {
                        cleaner.processFiles(f, fileExtension);
                    }
                }
            }
            else {
                System.out.println("Usage: the argument has to be a directory");
                System.exit(0);
            }
        }
    }

    public void processFiles(File fileOrDir, String fileExtension) {
        if (fileOrDir.isDirectory()){ //nested directories
            File[] listOfFiles = fileOrDir.listFiles();
            if (listOfFiles != null) {
                for (File file: listOfFiles){
                    if (file.isDirectory()){
                        //call recursively for all sub directories
                        processFiles(file, fileExtension);
                    }
                    else{
                        // it is a file, and clean it up
                        cleanupFile(file, fileExtension);
                    }
                }
            }
        }
        else {
            // it is a file, and clean it up
            cleanupFile(fileOrDir, fileExtension);

        }
    }

    // if this is an unwanted file, clean it up

    private void cleanupFile(File file, String fileExtension) {
        //cleanup the unwanted files by checking the file type
        String fileExt = FilenameUtils.getExtension(String.valueOf(file));
        if (fileExt != null){
            if (fileExt.equalsIgnoreCase(fileExtension)) {
                file.delete();
                System.out.println("File has been deleted " + file.getPath());
            }
        }
    }
}