package W13.W13.demo113.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.logging.Logger;


public class CreateDir {
    private static Logger logger = Logger.getLogger(CreateDir.class.getName());

    public static void createDir(String path) {
        File dir = new File(path);
        dir.mkdir();
        String osName = System.getProperty("os.name");
    
        if (!osName.contains("Windows")) {
            try {
                String perm = "rwxrwx---";
                Set<PosixFilePermission> permission = PosixFilePermissions.fromString(perm);
                Files.setPosixFilePermissions(dir.toPath(), permission);
            } catch (IOException e) {
                logger.warning("Cannot create directory!");
            }
        }
    }
}
