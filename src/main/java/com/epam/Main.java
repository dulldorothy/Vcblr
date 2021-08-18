package com.epam;

import com.epam.console.ConsoleVocabularyApplication;
import com.epam.service.Vocabulary;
import com.epam.service.impl.VocabularyImp;


import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Vocabulary vocabulary = null;
        try {
            vocabulary = new VocabularyImp("wordlist.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConsoleVocabularyApplication app = new ConsoleVocabularyApplication(vocabulary);
        app.start();
    }
}
