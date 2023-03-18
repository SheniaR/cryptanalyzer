package com.javarush.cryptanalyser.roslik.view;

import static com.javarush.cryptanalyser.roslik.constants.TextConstants.DELIMITER;
import static com.javarush.cryptanalyser.roslik.services.IsCheck.isMode;
import static com.javarush.cryptanalyser.roslik.view.BruteForceMenu.bruteForceMenu;
import static com.javarush.cryptanalyser.roslik.view.DecodeMenu.decodeMenu;
import static com.javarush.cryptanalyser.roslik.view.EncodeMenu.encodeMenu;

public class MainMenu {

    //      Главное меню
    public static void mainMenu() {

        welcome();

        int process = isMode("""
                Введите 1, если хотите зашифровать текст.
                Введите 2, если хотите расшифровать текст и вы знаете ключ.
                Введите 3, если хотите расшифровать текст методом Brute force.""");

        switch (process) {
            case 1 -> encodeMenu();
            case 2 -> decodeMenu();
            case 3 -> bruteForceMenu();
        }
    }

    //      Приветствие
    public static void welcome() {
        System.out.println(DELIMITER);
        System.out.println("Добро пожаловать в \"Шифр Цезаря\".");
        System.out.println("Данная программа шифрует и дешифрует текст алгоритмом Цезаря.");
        System.out.println(DELIMITER);
    }
}
