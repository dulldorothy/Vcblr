package com.company.service;

public interface Vocabulary {
    void ruEnTranslate(String ruWord);

    void enRuTranslate(String enWord);

    void addWordIntoVocabulary(String enWord, String ruWord);

    void quiz();

    void showAllWords();

    void amountOfPairs();
}
