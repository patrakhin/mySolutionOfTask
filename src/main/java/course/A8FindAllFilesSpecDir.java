package course;

import org.apache.log4j.Logger;
import java.io.File;
import java.util.*;

public class A8FindAllFilesSpecDir {
    private static final Logger logger = Logger.getLogger(A8FindAllFilesSpecDir.class);

    public void findFiles(String path, List<String> searchResult) {
        File foundFolder = new File(path);
        File[] foundFiles = foundFolder.listFiles();
        assert foundFiles != null;
        for (File file : foundFiles) {
            if (file.isFile()) {
                searchResult.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                findFiles(file.getAbsolutePath(), searchResult);
            }
        }
    }

    public static void main(String[] args) {
        A8FindAllFilesSpecDir findAllFilesSpecDir = new A8FindAllFilesSpecDir();
        String path = "/home/andrey/Загрузки/muSolutionTask/src/main/java/";
        List<String> fileList = new ArrayList<>();
        findAllFilesSpecDir.findFiles (path, fileList);
        logger.debug(fileList);
    }
}

