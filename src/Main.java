import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello");
        while (true) {
            System.out.println("Main menu \n enter : \n 1  to encrypt \n 2 to decrypt \n 0 to exit");
            int state = sc.nextInt();
            sc.nextLine();
            switch (state) {
                case 1:
                    handleEncryption();
                    break;
            }
        }
    }

    private static void handleEncryption() {
        System.out.println("enter a cipher key from 1 to " + (Cipher.getAlphabet().length - 1));
        try {
            String keyy = sc.nextLine();
            int key = Validator.validKey(keyy);              // парсинг и проверка введенного ключа

            System.out.println("enter the path to the file you want to encrypt  ");
            String path = sc.nextLine();                                                    //чтение с файла и шифрование
            String text = FileManager.reader(path);
            String text2 = Cipher.decrypt(text, key);

            System.out.println("enter the path where the encrypted text should be saved ");
            String path2 = sc.nextLine();                                                   // запись в файл итогового текста
            FileManager.writer(path2, text2);
            System.out.println("Encryption completed successfully ");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleDecryption() {

    }
}