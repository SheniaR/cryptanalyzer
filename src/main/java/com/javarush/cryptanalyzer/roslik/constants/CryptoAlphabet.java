package com.javarush.cryptanalyzer.roslik.constants;

public class CryptoAlphabet {
    private static final String lettersUpperCase = "ÀÁÂÃÄÅ¨ÆÇÈÉÊËÌÍÎÏĞÑÒÓÔÕÖ×ØÙÚÛÜİŞß";
    private static final String lettersLowerCase = "àáâãäå¸æçèéêëìíîïğñòóôõö÷øùúûüışÿ";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,\"\":-!? ";

    public static final String ALPHABET = lettersUpperCase + lettersLowerCase + numbers + symbols;

    public static final int LENGTH_ALPHABET = ALPHABET.length();
}
