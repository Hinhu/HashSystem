public final class CryptoWilku {
    private CryptoWilku(){}

    public static String encrypt(String text, String password){

        KeyGenerator keygen = new KeyGenerator(password);
        int seed = 0;
        int passLength = password.length();
        String subkey = "";
        StringBuilder encryptedText = new StringBuilder();
        for(int i=0; i<text.length(); i++){
            if(i%passLength == 0) {
                subkey = keygen.createSubKey(seed);
                seed++;
            }
            encryptedText.append((char) (text.charAt(i) ^ subkey.charAt(i%passLength)));
        }
        return encryptedText.toString();
    }


    public static String decrypt(String encryptedText, String password){
        KeyGenerator keygen = new KeyGenerator(password);
        int seed = 0;
        int passLength = password.length();
        String subkey = "";

        StringBuilder decryptedText = new StringBuilder();
        for(int i=0; i<encryptedText.length(); i++){
            if(i%passLength == 0) {
                subkey = keygen.createSubKey(seed);
                seed++;
            }
            decryptedText.append((char) (encryptedText.charAt(i) ^ subkey.charAt(i%passLength)));
        }
        return decryptedText.toString();
    }


}
