import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello");
        boolean exit = true;
        while (exit) {
            System.out.println("Main menu \n enter : \n 1  to encrypt \n 2 to decrypt \n 0 to exit");
            int state = sc.nextInt();
            sc.nextLine();
            switch (state) {
                case 1:
                    handleEncryption();
                    break;
                case 2:
                    handleDecryption();
                    break;
                case 0:
                    exit = false;
            }
        }
    }

    private static void handleEncryption() {

        try {
            System.out.println("enter a cipher key from 1 to " + (Cipher.getAlphabet().length - 1));
            String keyy = sc.nextLine();
            int key = Validator.validKey(keyy);              // парсинг и проверка введенного ключа

            System.out.println("enter the path to the file you want to encrypt ");
            String path = sc.nextLine();                                                    //чтение с файла и шифрование
            String text = FileManager.reader(path);
            String text2 = Cipher.encrypt(text, key);

            System.out.println("enter the path where the encrypted text should be saved ");
            String path2 = sc.nextLine();                                                   // запись в файл итогового текста
            FileManager.writer(path2, text2);
            System.out.println("Encryption completed successfully");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleDecryption() {
        try {
            int key = 0;                                                                             // парсинг и проверка введенного ключа
            System.out.println("enter a cipher key from 1 to " + (Cipher.getAlphabet().length - 1));
            String keyy = sc.nextLine();
            key = Validator.validKey(keyy);

            System.out.println("enter the path to the file you want to decrypt ");
            String path = sc.nextLine();                                                    //чтение с файла и дешифрование
            String text = FileManager.reader(path);
            String text2 = Cipher.decrypt(text, key);

            System.out.println("enter the path where the decrypted text should be saved ");
            String path2 = sc.nextLine();                                                   // запись в файл итогового текста
            FileManager.writer(path2, text2);
            System.out.println("decryption completed successfully");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}