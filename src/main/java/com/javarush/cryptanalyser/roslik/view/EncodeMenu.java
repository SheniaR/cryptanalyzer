package com.javarush.cryptanalyser.roslik.view;

import java.io.*;

import static com.javarush.cryptanalyser.roslik.constants.TextConstants.*;
import static com.javarush.cryptanalyser.roslik.services.Encode.encode;
import static com.javarush.cryptanalyser.roslik.services.IsCheck.*;

public class EncodeMenu {
    public static void encodeMenu(){

        int key = isKey(TEXT_KEY);

        String pathInput = isPathInputEncode(TEXT_PATH_INPUT_ENCODE);

        String pathOutputEncode = isPathOutputEncode(TEXT_PATH_OUTPUT_ENCODE);

//        Здесь работаем с InputStreamReader и OutputStreamReader
        File reader = new File(pathInput);
        File writer = new File(pathOutputEncode);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader)));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writer)))){
            while (bufferedReader.ready()) {
                bufferedWriter.write(encode(bufferedReader.readLine(), key));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Текст зашифрован в файл %s, с ключом %d.%n", pathOutputEncode, key);
        System.out.println(DELIMITER);
    }


}
