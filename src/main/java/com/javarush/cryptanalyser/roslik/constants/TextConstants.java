package com.javarush.cryptanalyser.roslik.constants;

import static com.javarush.cryptanalyser.roslik.constants.CryptoAlphabet.LENGTH_ALPHABET;

public class TextConstants {

    public static final String TEXT_KEY = String.format("""
                Введите ключ:
                Ключом может быть целое число от 1 до %d.
                Или нажмите Enter для установки ключа по умолчанию.""", LENGTH_ALPHABET);
    public static final String TEXT_PATH_INPUT_ENCODE = """
                Введите путь к файлу, который хотите зашифровать.
                Или нажмите Enter для установки файла по умолчанию.""";

    public static final String TEXT_PATH_INPUT_DECODE = """
                Введите путь к файлу, который хотите расшифровать.
                Или нажмите Enter для установки файла по умолчанию.""";

    public static final String TEXT_PATH_OUTPUT_ENCODE = """
                Введите путь к файлу, куда записать зашифрованный файл.
                Или нажмите Enter для установки файла по умолчанию.""";

    public static final String TEXT_PATH_OUTPUT_DECODE = """
                Введите путь к файлу, куда записать расшифрованный файл.
                Или нажмите Enter для установки файла по умолчанию.""";

    public static final int DELIMITER_COUNT = 40;

    public static final String DELIMITER = "- ".repeat(DELIMITER_COUNT);


}
