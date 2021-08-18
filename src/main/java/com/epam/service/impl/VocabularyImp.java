package com.epam.service.impl;


import com.epam.service.FileReader;
import com.epam.service.InputProcessor;
import com.epam.service.Vocabulary;

import java.io.IOException;
import java.util.*;

public class VocabularyImp implements Vocabulary {
    private final FileReader fileReader;
    private HashMap<String, String> words;
    private InputProcessor ip;

    public VocabularyImp(String fileName) throws IOException {
        this.fileReader = new FileReaderImpl(fileName);
        this.words = this.fileReader.readFile();
        ip = new InputProcessorImlp(new Scanner(System.in));

    }


    @Override
    public String ruEnTranslate(String ruWord) {

        for (Map.Entry<String, String> wordPair : words.entrySet()) {
            if (wordPair.getValue().equals(ruWord)) {
                ip.print("English equivalent: " + wordPair.getKey());

                return wordPair.getKey();
            }
        }

        ip.print("No matches found...");
        return null;

    }

    @Override
    public String enRuTranslate(String enWord) {
        if (words.get(enWord) != null) {
            ip.print("Russian equivalent: " + words.get(enWord));
            return words.get(enWord);
        }
        ip.print("No matches found...");
        return null;
    }

    @Override
    public void addWordIntoVocabulary(String enWord, String ruWord) {
        words.put(enWord, ruWord);
        ip.print("Success!");
    }

    @Override
    public void quiz() {
        ArrayList<String> quizWords = new ArrayList<>(words.values());
        int score = 100;
        Random rng = new Random();
        ArrayList<String> wrongAnswers = new ArrayList<>();
        while (quizWords.size() > 5) {
            int index = rng.nextInt(quizWords.size());
            quizWords.remove(index);
        }
        for (String word : quizWords) {
            ip.print("Equivalent of : " + word);

            String answer = ip.getConsoleWordInput().trim().toLowerCase();
            if (words.get(answer) == null || !words.get(answer).equals(word)) {
                score -= 20;
                wrongAnswers.add(word);
            }
        }
        if (!wrongAnswers.isEmpty()) {
            ip.print("Your score: " + score);
            ip.print("Wrong answers: ");
            int i = 0;
            for (String word : wrongAnswers) {
                i++;
                for (Map.Entry<String, String> wordPair : words.entrySet()) {
                    if (wordPair.getValue().equals(word)) {
                        ip.print(i + ": " + wordPair.getKey() + " - " + wordPair.getValue());
                    }
                }
            }
        } else {
            ip.print("Your score: " + score + "!!!");
        }
    }

    @Override
    public void showAllWords() {
        for (Map.Entry<String, String> a : words.entrySet()) {
            ip.print("en: " + a.getKey() + " ru: " + a.getValue());
        }
    }

    @Override
    public void amountOfPairs() {

        ip.print("Amount of words in vocabulary: " + words.size());
    }

    @Override
    public void save() {
        try {
            fileReader.saveIntoFile(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
