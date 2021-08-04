package com.company;

import com.company.console.ConsoleVocabularyApplication;
import com.company.service.Vocabulary;
import com.company.service.impl.VocabularyImp;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        Vocabulary vocabulary = null;
        try {
            vocabulary = new VocabularyImp("test.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ConsoleVocabularyApplication app = new ConsoleVocabularyApplication(vocabulary);
        app.start();
    }
}
