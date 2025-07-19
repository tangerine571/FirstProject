public class Cipher {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

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
}
