package com.javarush.cryptanalyzer.roslik.constants;

public class CryptoAlphabet {
    private static final String lettersUpperCase = "�����Ũ��������������������������";
    private static final String lettersLowerCase = "��������������������������������";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,\"\":-!? ";

    public static final String ALPHABET = lettersUpperCase + lettersLowerCase + numbers + symbols;

    public static final int LENGTH_ALPHABET = ALPHABET.length();
}
