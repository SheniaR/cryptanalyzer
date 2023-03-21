package com.javarush.cryptanalyser.roslik.view;

import static com.javarush.cryptanalyser.roslik.constants.TextConstants.*;
import static com.javarush.cryptanalyser.roslik.services.IsCheck.isMode;
import static com.javarush.cryptanalyser.roslik.view.BruteForceMenu.bruteForceMenu;
import static com.javarush.cryptanalyser.roslik.view.DecodeMenu.decodeMenu;
import static com.javarush.cryptanalyser.roslik.view.EncodeMenu.encodeMenu;

public class MainMenu {

    //      Главное меню
    public static void mainMenu() {

        welcome();

        int process = isMode(TEXT_MODE_CHECK);

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
