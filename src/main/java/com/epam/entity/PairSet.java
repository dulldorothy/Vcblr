package com.epam.entity;



public class PairSet {
    private final String enWord;
    private final String ruWord;

    public PairSet(String key, String value) {
        this.enWord = key;
        this.ruWord = value;
    }

    public String getEnWord() {
        return enWord;
    }

    public String getRuWord() {
        return ruWord;
    }

    public static PairSet toPairSet(String line){
        PairSet result;
        String[] words = line.split(";");
        result = new PairSet(words[0], words[1]);
        return result;
    }
}
