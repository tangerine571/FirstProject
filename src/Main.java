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
                                                                             // знаю, метод слишком большой и надо бы вынести логику в отдельные методы с каким-нибудь Service классов, но думаю, что итааак сойдет
        int key = 0;
        while (true) {
            try {
                System.out.println("enter a cipher key from 1 to " + (Cipher.getAlphabet().length - 1));          // парсинг и проверка введенного ключа
                String keyy = sc.nextLine();
                key = Validator.validKey(keyy);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        String text2 = null;
        while (true) {
            try {
                System.out.println("enter the path to the file you want to encrypt ");
                String path = sc.nextLine();                                                    //чтение с файла и шифрование
                String text = FileManager.reader(path);
                text2 = Cipher.encrypt(text, key);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("enter the path where the encrypted text should be saved ");
                String path2 = sc.nextLine();                                                   // запись в файл итогового текста
                FileManager.writer(path2, text2);
                System.out.println("Encryption completed successfully");
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

        private static void handleDecryption() {
            int key = 0;
            while (true) {
                try {
                    key = 0;
                    System.out.println("enter a cipher key from 1 to " + (Cipher.getAlphabet().length - 1));      // парсинг и проверка введенного ключа
                    String keyy = sc.nextLine();
                    key = Validator.validKey(keyy);
                    break;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            String text2 = null;
            while (true) {
                try {
                    System.out.println("enter the path to the file you want to decrypt ");
                    String path = sc.nextLine();                                                    //чтение с файла и дешифрование
                    String text = FileManager.reader(path);
                    text2 = Cipher.decrypt(text, key);
                    break;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

            while (true) {
                try {
                    System.out.println("enter the path where the decrypted text should be saved ");
                    String path2 = sc.nextLine();                                                   // запись в файл итогового текста
                    FileManager.writer(path2, text2);
                    System.out.println("decryption completed successfully");
                    break;
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
    }
