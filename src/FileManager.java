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

        Path pa = Path.of(path);
        if(!Files.exists(pa)){
            throw new IOException("файл не найден");
        }
        if(Files.isDirectory(pa)){
            throw new IOException("это директория, а не файл");
        }
        if(!Files.isWritable(pa)){
            throw new IOException("файл недоступен  для чтения");
        }
        Files.writeString(pa,text);
    }
}
