package com.epam.console;


import com.epam.service.InputProcessor;
import com.epam.service.Vocabulary;
import com.epam.service.impl.InputProcessorImlp;

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
    private final InputProcessor ip;

    public ConsoleVocabularyApplication(Vocabulary vocabulary) {
        this.vocabulary = vocabulary;
        ip = new InputProcessorImlp(new Scanner(System.in));

    }

    public void start() {
        menu();
    }

    public void menu() {
        boolean isRunning = true;
        int choice;

        while (isRunning) {
            ip.print(MENU_MESSAGE);
            choice = ip.getConsoleIntInput();
            ip.print(DELIMITER);

            switch (choice) {
                case 1:
                    ip.print("RU-EN");
                    String ruWord;
                    ruWord = ip.getConsoleWordInput();
                    vocabulary.ruEnTranslate(ruWord);
                    ip.print(DELIMITER);
                    break;
                case 2:
                    ip.print("EN-RU");
                    String enWord;
                    enWord = ip.getConsoleWordInput();
                    vocabulary.enRuTranslate(enWord);
                    ip.print(DELIMITER);
                    break;
                case 3:
                    String enWordInput;
                    String ruWordInput;
                    ip.print("Enter English word: ");
                    enWordInput = ip.getConsoleWordInput();
                    ip.print("Enter Russian equivalent: ");
                    ruWordInput = ip.getConsoleWordInput();
                    vocabulary.addWordIntoVocabulary(enWordInput, ruWordInput);
                    ip.print(DELIMITER);
                    break;
                case 4:
                    ip.print("Quiz");
                    vocabulary.quiz();
                    ip.print(DELIMITER);
                    break;
                case 5:
                    ip.print("All words: ");
                    vocabulary.showAllWords();
                    ip.print(DELIMITER);
                    break;
                case 6:
                    vocabulary.amountOfPairs();
                    ip.print(DELIMITER);
                    break;
                case 0:
                    isRunning = false;
                    ip.print("Closing app...");
                    vocabulary.save();
                    break;
            }
        }
    }


}
