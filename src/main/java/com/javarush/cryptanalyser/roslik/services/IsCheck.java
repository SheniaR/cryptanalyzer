package com.javarush.cryptanalyser.roslik.services;

import java.util.Scanner;

import static com.javarush.cryptanalyser.roslik.constants.CryptoAlphabet.LENGTH_ALPHABET;
import static com.javarush.cryptanalyser.roslik.services.util.DefaultKeyRandom.randomKey;
import static com.javarush.cryptanalyser.roslik.constants.DefaultPath.*;

public class IsCheck {

    static Scanner in = new Scanner(System.in);
    //      3. Проверка ввода мода 1-2-3
    public static int isMode(String message) {
        String mess;
        while (true) {
            System.out.println(message);
            mess = in.nextLine();
            if (mess.equals("1") || mess.equals("2") || mess.equals("3")) {
                return Integer.parseInt(mess);
            } else {
                System.out.println("ERROR: можно вводить только 1, 2 или 3.");
            }
        }
    }

    public static int isKey(String message) {
        String key;
        while (true) {
            System.out.println(message);
            key = in.nextLine();
            if (key.equals("")) {
                //key по умолчанию
                key = randomKey();
                return Integer.parseInt(key);
            } else if (Integer.parseInt(key) >= 1 && Integer.parseInt(key) <= LENGTH_ALPHABET) {
                return Integer.parseInt(key);
            } else {
                System.out.printf("ERROR: можно вводить только числа от 1 до %d.\n", LENGTH_ALPHABET);
            }
        }
    }

    public static String isPathInputEncode(String message) {
        System.out.println(message);
        String pathInput = in.nextLine();
        if (pathInput.equals("")) {
            pathInput = INPUT;
        }
        return pathInput;
    }

    public static String isPathOutputEncode(String message) {
        System.out.println(message);
        String pathOutputDecode = in.nextLine();
        if (pathOutputDecode.equals("")) {
            pathOutputDecode = ENCODED;
        }
        return pathOutputDecode;
    }


    public static String isPathInputDecode(String message) {
        System.out.println(message);
        String pathOutputDecode = in.nextLine();
        if (pathOutputDecode.equals("")) {
            pathOutputDecode = ENCODED;
        }
        return pathOutputDecode;
    }

    public static String isPathOutputDecode(String message) {
        System.out.println(message);
        String pathOutputDecode = in.nextLine();
        if (pathOutputDecode.equals("")) {
            pathOutputDecode = OUTPUT;
        }
        return pathOutputDecode;
    }


}
