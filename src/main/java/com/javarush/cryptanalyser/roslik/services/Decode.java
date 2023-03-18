package com.javarush.cryptanalyser.roslik.services;

import static com.javarush.cryptanalyser.roslik.constants.CryptoAlphabet.*;

public class Decode {
    //      Дешифрование текста
    public static String decode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charLeftOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      Дешифрование по символьно влево
    public static char charLeftOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + LENGTH_ALPHABET - key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }
}
