package com.company.service.impl;

import com.company.service.FileReader;
import com.company.service.Vocabulary;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class VocabularyImp implements Vocabulary {
    private final FileReader fileReader;
    private Map words;
    {
        words = new HashMap();
    }

    public VocabularyImp(String fileName) throws FileNotFoundException {
        this.fileReader = new FileReaderImpl(fileName);
        this.words = this.fileReader.readFile();

    }

    @Override
    public void ruEnTranslate(String ruWord) {

    }

    @Override
    public void enRuTranslate(String enWord) {

    }

    @Override
    public void addWordIntoVocabulary(String enWord, String ruWord) {

    }

    @Override
    public void quiz() {

    }

    @Override
    public void showAllWords() {

    }

    @Override
    public void amountOfPairs() {

    }
}
