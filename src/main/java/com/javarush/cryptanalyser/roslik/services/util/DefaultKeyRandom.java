package com.javarush.cryptanalyser.roslik.services.util;

import java.util.Random;

import static com.javarush.cryptanalyser.roslik.constants.CryptoAlphabet.ALPHABET;

public class DefaultKeyRandom {
    public static String randomKey() {
        Random random = new Random();
        return String.valueOf(random.nextInt(1,ALPHABET.length()));
    }
}
