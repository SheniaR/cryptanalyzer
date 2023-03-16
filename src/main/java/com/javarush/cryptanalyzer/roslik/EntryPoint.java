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


    //      2. �����������
    public static void welcome() {
        System.out.println("- ".repeat(40));
        System.out.println("����� ���������� � \"���� ������\".");
        System.out.println("������ ��������� ������� � ��������� ����� ���������� ������.");
        System.out.println("������� ������ ������� �� ����� input.txt, ������� ��������� � ����� resources");
        System.out.println("- ".repeat(40));
    }


    //      3. �������� ����� ���� 1-2-3
    public static int isMode(String message) {
        String mess;
        while (true) {
            System.out.println(message);
            Scanner in = new Scanner(System.in);
            mess = in.nextLine();
            if (mess.equals("1") || mess.equals("2") || mess.equals("3")) {
                break;
            } else {
                System.out.println("ERROR: ����� ������� ������ 1, 2 ��� 3.");
            }
        }
        return Integer.parseInt(mess);
    }


    //      4. ���������� ������
    public static String encode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charRightOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      4.1 ���������� ������ �� ���������
    public static char charRightOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }


    //      5. ������������ ������
    public static String decode(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        for (int i = 0; i < textInput.length(); i++) {
            textOutput.append(charLeftOffset(textInput.charAt(i), key));
        }
        return textOutput.toString();
    }

    //      5.1 ������������ ������ �� ���������
    public static char charLeftOffset(char symbol, int key) {
        if(ALPHABET.indexOf(symbol) != -1) {
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + LENGTH_ALPHABET - key) % LENGTH_ALPHABET);
        } else {
            return symbol;
        }
    }


    //      6. ������� ����
    public static void main_menu() {
        welcome();
        int process = isMode("""
                ������� 1, ���� ������ ����������� �����.
                ������� 2, ���� ������ ����������� ����� � �� ������ ����.
                ������� 3, ���� ������ ����������� ����� ������� Brute force.""");

        switch (process) {
            case 1 -> encodeMenu();
            case 2 -> decodeMenu();
//            case 3 -> bruteForceMenu();
        }
    }


    //    7. ���� ���������� (1 - encodeMenu)
    public static void encodeMenu(){
        System.out.printf("""
                ������� ����:
                ������ ����� ���� ����� ����� �� 1 �� %d.
                %n""", LENGTH_ALPHABET);

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                key = in.nextInt();
                if (key >= 1 && key <= LENGTH_ALPHABET) {
                    in.close();
                    break;
                } else {
                    System.out.printf("ERROR: ����� ������� ������ ����� �� 1 �� %d.\n", LENGTH_ALPHABET);
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ����� ������� ������ ����������� �����.");
            }
        }

//        ����� �������� � InputStreamReader � OutputStreamReader
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

        System.out.println("����� ���������� � ���� encoded.txt � ��������� � ����� resources");
        System.out.println("- ".repeat(30));
    }

    //    8. ���� ������������ (2 - encodeMenu)
    public static void decodeMenu(){
        System.out.printf("""
                ������� ����:
                ������ ����� ���� ����� ����� �� 1 �� %d.""", LENGTH_ALPHABET);

        while (true) {
            try {
                Scanner in = new Scanner(System.in);
                key = in.nextInt();
                if (key >= 1 && key <= LENGTH_ALPHABET) {
                    in.close();
                    break;
                } else {
                    System.out.printf("ERROR: ����� ������� ������ ����� �� 1 �� %d.\n", LENGTH_ALPHABET);
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: ����� ������� ������ ����������� �����.\n");
            }
        }

        System.out.println();
//        ����� �������� � InputStreamReader � OutputStreamReader
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

        System.out.println("����� ���������� � ���� output.txt � ��������� � ����� resources");
        System.out.println("- ".repeat(40));
    }




}