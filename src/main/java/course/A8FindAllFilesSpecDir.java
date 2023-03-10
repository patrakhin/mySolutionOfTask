package course;

import org.apache.log4j.Logger;
import java.io.File;
import java.util.*;

public class A8FindAllFilesSpecDir {
    private static final Logger logger = Logger.getLogger(A8FindAllFilesSpecDir.class);

    public List<String> findFiles(String path) {
        List<String> searchResult = new ArrayList<>();
        File foundFolder = new File(path);
        findFilesRecursive(foundFolder, searchResult);
        return searchResult;
    }

    private void findFilesRecursive(File folder, List<String> searchResult) {
        File[] foundFiles = folder.listFiles();
        if (foundFiles == null) {
            return;
        }
        for (File file : foundFiles) {
            if (file.isFile()) {
                searchResult.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                findFilesRecursive(file, searchResult);
            }
        }
    }

    public static void main(String[] args) {
        A8FindAllFilesSpecDir finder = new A8FindAllFilesSpecDir();
        List<String> files = finder.findFiles("/home/andrey/Загрузки/muSolutionTask/src/main/java/");
        for (String file : files) {
            logger.debug(file);
        }
    }
}

