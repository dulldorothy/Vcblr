package com.epam.service;

public interface Vocabulary {
    String ruEnTranslate(String ruWord);

    String enRuTranslate(String enWord);

    void addWordIntoVocabulary(String enWord, String ruWord);

    void quiz();

    void showAllWords();

    void amountOfPairs();

    void save();
}
