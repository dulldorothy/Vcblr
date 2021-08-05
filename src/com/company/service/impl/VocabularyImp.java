package com.company.service.impl;

import com.company.entity.PairSet;
import com.company.service.FileReader;
import com.company.service.Vocabulary;
import javafx.scene.control.RadioMenuItem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class VocabularyImp implements Vocabulary {
    private final FileReader fileReader;
    private HashMap<String, String> words;


    public VocabularyImp(String fileName) throws IOException {
        this.fileReader = new FileReaderImpl(fileName);
        this.words = this.fileReader.readFile();

    }


    @Override
    public String ruEnTranslate(String ruWord) {

        for (Map.Entry<String, String> wordPair : words.entrySet()) {
            if (wordPair.getValue().equals(ruWord)) {
                System.out.println("English equivalent: " + wordPair.getKey());

                return wordPair.getKey();
            }
        }

        System.out.println("No matches found...");
        return null;

    }

    @Override
    public String enRuTranslate(String enWord) {
        if (words.get(enWord) != null) {
            System.out.println("Russian equivalent: " + words.get(enWord));
            return words.get(enWord);
        }
        System.out.println("No matches found...");
        return null;
    }

    @Override
    public void addWordIntoVocabulary(String enWord, String ruWord) {
        words.put(enWord, ruWord);
        System.out.println("Success!");
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
            System.out.println("Equivalent of : " + word);
            Scanner sc = new Scanner(System.in);
            String answer = sc.nextLine().trim().toLowerCase();
            if (words.get(answer) == null || !words.get(answer).equals(word)) {
                score -= 20;
                wrongAnswers.add(word);
            }
        }
        if (!wrongAnswers.isEmpty()) {
            System.out.println("Your score: " + score);
            System.out.println("Wrong answers: ");
            int i = 0;
            for (String word : wrongAnswers) {
                i++;
                for (Map.Entry<String, String> wordPair : words.entrySet()) {
                    if (wordPair.getValue().equals(word)) {
                        System.out.println(i + ": " + wordPair.getKey() + " - " + wordPair.getValue());
                    }
                }
            }
        } else {
            System.out.println("Your score: " + score + "!!!");
        }
    }

    @Override
    public void showAllWords() {
        for (Map.Entry<String, String> a : words.entrySet()) {
            System.out.println("en: " + a.getKey() + " ru: " + a.getValue());
        }
    }

    @Override
    public void amountOfPairs() {
        System.out.println("Amount of words in vocabulary: " + words.size());
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
