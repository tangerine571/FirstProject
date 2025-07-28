import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    private FileManager() {
    }

    public static String reader(String path) throws IOException {
        Validator.checkFileReader(path);
        Path pa = Path.of(path);
        String s = Files.readString(pa);
        return s;
    }
    public static void writer(String path, String text) throws IOException{
        Validator.checkFileWriter(path);
        Path pa = Path.of(path);
        Files.writeString(pa,text);
    }
}
