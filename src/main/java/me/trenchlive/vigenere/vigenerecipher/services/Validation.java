package me.trenchlive.vigenere.vigenerecipher.services;

public class Validation{
    public static boolean valid(String key){
        return isUpperCaseEnglishLetters(key);
    }

    public static boolean isUpperCaseEnglishLetters(String str) {
        return str.matches("[A-Z]+");
    }
}

