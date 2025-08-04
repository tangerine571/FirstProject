import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileManager {
    private FileManager() {
    }

    public static String reader(String path) throws IOException {
        Validator.checkFileReader(path);
        Path pa = Path.of(path);

        StringBuilder sb = new StringBuilder();

//       заменил использование files.readString на BufferedReader через Files.newBufferedReader. хоть мы это нихрена и не проходили, но покопавшись я понял,
//       что при работе с файлами стоит выделить 2 метода : 1) если файл маленький, можно юзать просто Files.readString для получения текста.
//         2) для крупных файлов с максимальной оптимизацией используем BufferedReader через Files.newBufferedReader.
//        так существует множество способов и методов, но они в основном устаревшие.

        try(BufferedReader reader = Files.newBufferedReader(pa)){
            String line;
            while((line = reader.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
        }
        String s = String.valueOf(sb);
        return s;
    }
    public static void writer(String path, String text) throws IOException{
        Validator.checkFileWriter(path);
        Path pa = Path.of(path);


        Files.writeString(pa,text);
    }
}
