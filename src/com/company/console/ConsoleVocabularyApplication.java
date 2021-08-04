package com.company.console;


import com.company.service.Vocabulary;

import java.util.Scanner;

public class ConsoleVocabularyApplication {

    private static final String MENU_MESSAGE =
            "1 - RU-EN \n" +
                    "2 - EN-RU \n" +
                    "3 - Add words to vocabulary \n" +
                    "4 - Quiz\n" +
                    "5 - Show all words\n" +
                    "6 - Amount of pairs\n" +
                    "0 - EXIT\n";
    private static final String DELIMITER = "\n****************\n";
    private static final int RESTART_VALUE = 13;
    private final Vocabulary vocabulary;
    private final Scanner sc;

    {
        sc = new Scanner(System.in);
    }


    public ConsoleVocabularyApplication(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;

    }

    public void start() {
        menu();
    }

    public void menu() {
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            print(MENU_MESSAGE);
            choice = getConsoleIntInput();
            print(DELIMITER);

            switch (choice) {
                case 1:
                    print("RU-EN");
                    String ruWord;
                    ruWord = getConsoleWordInput();
                    this.vocabulary.enRuTranslate(ruWord);
                    break;
                case 2:
                    print("EN-RU");
                    String enWord;
                    enWord = getConsoleWordInput();
                    this.vocabulary.enRuTranslate(enWord);
                    break;
                case 3:
                    String enWordInput;
                    String ruWordInput;
                    print("Enter English word: ");
                    enWordInput = getConsoleWordInput();
                    print("Enter Russian equivalent: ");
                    ruWordInput = getConsoleWordInput();
                    vocabulary.addWordIntoVocabulary(enWordInput,ruWordInput);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    isRunning = false;
                    print("Closing app...");
                    break;
            }
        }
    }

    private String getConsoleWordInput() {
        String result;
        if (sc.hasNextLine()) {
            result = sc.nextLine();
            if (result.contains("\\d+")) {
                print("Incorrect word! Try again...");
                result = getConsoleWordInput();
            } else {
                return result;
            }
        }else{
            print("Input cannot be null.");
            result = getConsoleWordInput();
        }
        return result;
    }

    private void print(String message) {
        System.out.println(message);
    }

    private int getConsoleIntInput() {
        int result;
        if (sc.hasNextInt()) {
            result = sc.nextInt();
        } else {
            result = RESTART_VALUE;
            clearIncorrectConsoleInput();
        }
        return result;
    }

    private void clearIncorrectConsoleInput() {
        String rubbish;
        rubbish = sc.nextLine();
        System.out.println("Incorrect input:[" + rubbish + "]");
    }
}
