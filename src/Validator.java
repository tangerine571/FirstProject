import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {

    private Validator() {
    }
    public static boolean validKey(int key){
        if(key < (Cipher.getAlphabet().length - 1) && key > 0){
            return true;
        }
            return false;
    }

    public static void checkFileReader(String path) throws IOException {
        Path pa = Path.of(path);
        if (!Files.exists(pa)) {
            throw new IOException("файл не найден");
        }
        if (Files.isDirectory(pa)) {
            throw new IOException("это директория, а не файл");
        }
        if (!Files.isReadable(pa)) {
            throw new IOException("файл недоступен  для чтения");
        }
    }

}
