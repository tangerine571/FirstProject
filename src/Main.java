import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String s = "Опа ";
        String result = Cipher.encrypt(s, 7);
        System.out.println(result);

        System.out.println("-----------------------");

        String decResult = Cipher.decrypt(result, 7);
        System.out.println(decResult);

        System.out.println("-----------------------");

        String str = null;
        try {
            str = FileManager.reader("C:\\Users\\manda\\OneDrive\\Desktop\\example.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(str);


        System.out.println("----------------------------");


        try {
            FileManager.writer("C:\\Users\\manda\\OneDrive\\Desktop\\example.txt", "лежать плюс сосать");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}