import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Scanner;

public class Validator {

    private Validator() {
    }

    public static int validKey(String keyy) throws IOException {
        int key;
        try {
            key = Integer.parseInt(keyy);
        } catch (NumberFormatException e) {
            throw new IOException("uncorrected key");
        }
        if (key > (Cipher.getAlphabet().length - 1) || key <= 0) {
            throw new IOException("uncorrected key");
        }
        return key;
    }

    public static void checkFileReader(String path) throws IOException {

        Path pa;
        try {
            pa = Path.of(path);
        } catch (InvalidPathException e) {
            throw new IOException("uncorrected path ");
        }

        if (!Files.exists(pa)) {
            throw new IOException("file wasn't found");
        }
        if (Files.isDirectory(pa)) {
            throw new IOException("it's directory");
        }
        if (!Files.isReadable(pa)) {
            throw new IOException("file isn't available");
        }
    }

    public static void checkFileWriter(String path) throws IOException {
        Path pa = null;
        try {
            pa = Path.of(path);
        } catch (InvalidPathException e) {
            throw new IOException("uncorrected path");
        }
        if (!Files.exists(pa)) {
            throw new IOException("file wasn't found");
        }
        if (Files.isDirectory(pa)) {
            throw new IOException("it's directory");
        }
        if (!Files.isWritable(pa)) {
            throw new IOException("file isn't available");
        }
    }

}
