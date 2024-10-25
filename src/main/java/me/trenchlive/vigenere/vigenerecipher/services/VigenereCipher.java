package me.trenchlive.vigenere.vigenerecipher.services;

public class VigenereCipher {
    final static String enAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static int convertKey(String key, int pos){
        return enAlphabet.indexOf(key.charAt(mod(pos, key.length())));
    }

    public static String encrypt(String text, String key, boolean isEncode){
        char[] encrypted = text.toCharArray();

        for (int i = 0, pos = 0; i < text.length(); i++) {
            char temp = encrypted[i];

            if(!Character.isAlphabetic(temp))
                continue;

            int temp_key = convertKey(key, pos);

            if (isEncode)
                encrypted[i] = moveC(encrypted[i], temp_key);
            else
                encrypted[i] = moveC(encrypted[i], -temp_key);

            pos++;
        }
        return new String(encrypted);
    }

    private static char moveC(char c, int key){
        if(enAlphabet.indexOf(c) == -1)
            return c;
        int index = mod(enAlphabet.indexOf(c) + key, enAlphabet.length());
        return enAlphabet.charAt(index);
    }

    private static int mod(int index, int length){
        return index >= 0 ? index % length : (length + index % length) % length;
    }
}
