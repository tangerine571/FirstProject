public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ','А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З',
            'И','К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ',
            'Ъ', 'Ы', 'Ь', 'Э', 'Я'};

    public static String encrypt(String s, int key){
        char[] text = s.toCharArray();
        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < ALPHABET.length ; j++) {
                if(text[i] == ALPHABET[j]){
                    text[i] = ALPHABET[(j+key)%ALPHABET.length];
                    break;
                }
            }
        }
        String result = String.valueOf(text);
        return result;
    }
    public static String decrypt(String s, int key){
        char[] text = s.toCharArray();

        for (int i = 0; i < text.length; i++) {
            for (int j = 0; j < ALPHABET.length ; j++) {
                if(text[i] == ALPHABET[j]){
                    int newIndex = ((j-key)%ALPHABET.length) < 0 ? ((j-key)%ALPHABET.length) + ALPHABET.length : ((j-key)%ALPHABET.length);
                    text[i] = ALPHABET[newIndex];
                    break;
                }
            }
        }

        String result = String.valueOf(text);
        return result;
    }
    public static char[] getAlphabet(){
        return ALPHABET;
    }
}
