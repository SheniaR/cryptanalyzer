package com.javarush.cryptanalyzer.roslik;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.javarush.cryptanalyzer.roslik.constants.CryptoAlphabet.*;

public class EntryPoint {


    private static int key;

    public static void main(String[] args) {
        main_menu();
    }


    //      2. Приветствие
    public static void welcome() {
        System.out.println("- ".repeat(40));
        System.out.println("Добро пожаловать в \"Шифр Цезаря\".");
        System.out.println("Данная программа шифрует и дешифрует текст алгоритмом Цезаря.");
        System.out.println("Входные данные берутся из файла input.txt, который находится в папке resources");
        System.out.println("- ".repeat(40));
    }


    //      3. Проверка ввода мода 1-2-3
    public static int isMode(String message) {
        String mess;
        while (true) {
            System.out.println(message);
            Scanner in = new Scanner(System.in);
            mess = in.nextLine();
            if (mess.equals("1") || mess.equals("2") || mess.equals("3")) {
                break;
            } else {
                System.out.println("ERROR: можно вводить только 1, 2 или 3.");
            }
        }
        return Integer.parseInt(mess);
    }


    //      4. Шифрование текста
    public static String encode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charRightOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      4.1 Шифрование текста по символьно
    public static char charRightOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }


    //      5. Дешифрование текста
    public static String decode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charLeftOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      5.1 Дешифрование текста по символьно
    public static char charLeftOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + LENGTH_ALPHABET - key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }


    //      6. Главное меню
    public static void main_menu() {
        welcome();
        int process = isMode("""
                Введите 1, если хотите зашифровать текст.
                Введите 2, если хотите дешифровать текст и вы знаете ключ.
                Введите 3, если хотите дешифровать текст методом Brute force.""");

        switch (process) {
            case 1 -> encodeMenu();
            case 2 -> decodeMenu();
//            case 3 -> bruteForceMenu();
        }
    }


    //    7. Меню шифрования (1 - encodeMenu)
    public static void encodeMenu(){
        System.out.printf("""
                Введите ключ:
                Ключом может быть целое число от 1 до %d.
                %n""", LENGTH_ALPHABET);

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                key = in.nextInt();
                if (key >= 1 && key <= LENGTH_ALPHABET) {
                    in.close();
                    break;
                } else {
                    System.out.printf("ERROR: можно вводить только числа от 1 до %d.\n", LENGTH_ALPHABET);
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: можно вводить только натуральные числа.");
            }
        }

//        Здесь работаем с InputStreamReader и OutputStreamReader
        File src = new File("./src/main/resources/input.txt");
        File dst = new File("./src/main/resources/encoded.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst)))){

            while (bufferedReader.ready()) {
                bufferedWriter.write(encode(bufferedReader.readLine(), key));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Текст зашифрован в файл encoded.txt и находится в папке resources");
        System.out.println("- ".repeat(30));
    }

    //    8. Меню дешифрования (2 - encodeMenu)
    public static void decodeMenu(){
        System.out.printf("""
                Введите ключ:
                Ключом может быть целое число от 1 до %d.""", LENGTH_ALPHABET);

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                key = in.nextInt();
                if (key >= 1 && key <= LENGTH_ALPHABET) {
                    in.close();
                    break;
                } else {
                    System.out.printf("ERROR: можно вводить только числа от 1 до %d.\n", LENGTH_ALPHABET);
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: можно вводить только натуральные числа.\n");
            }
        }

        System.out.println();
//        Здесь работаем с InputStreamReader и OutputStreamReader
        File src = new File("./src/main/resources/input.txt");
        File dst = new File("./src/main/resources/output.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dst)))){

            while (bufferedReader.ready()) {
                bufferedWriter.write(decode(bufferedReader.readLine(), key));
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Текст дешифрован в файл output.txt и находится в папке resources");
        System.out.println("- ".repeat(40));
    }




}