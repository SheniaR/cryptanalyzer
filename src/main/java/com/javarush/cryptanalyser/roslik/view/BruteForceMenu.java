package com.javarush.cryptanalyser.roslik.view;

import java.io.*;

import static com.javarush.cryptanalyser.roslik.constants.TextConstants.*;
import static com.javarush.cryptanalyser.roslik.services.BruteForce.bruteForce;
import static com.javarush.cryptanalyser.roslik.services.IsCheck.*;

public class BruteForceMenu {
    public static void bruteForceMenu(){

        String pathInput = isPathInputDecode(TEXT_PATH_INPUT_DECODE);

        String pathOutputDecode = isPathOutputDecode(TEXT_PATH_OUTPUT_DECODE);

//        работаем с InputStreamReader и OutputStreamReader
        File reader = new File(pathInput);
        File writer = new File(pathOutputDecode);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader)));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writer)))){
            while (bufferedReader.ready()) {
                bufferedWriter.write(bruteForce(bufferedReader.readLine()));
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("Текст расшифрован в файл %s.%n", pathOutputDecode);
        System.out.println(DELIMITER);
    }
}
