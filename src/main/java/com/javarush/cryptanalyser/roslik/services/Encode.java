package com.javarush.cryptanalyser.roslik.services;

import static com.javarush.cryptanalyser.roslik.constants.CryptoAlphabet.*;

public class Encode {
    //      Шифрование текста
    public static String encode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charRightOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      Шифрование по символьно вправо
    public static char charRightOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }

}
