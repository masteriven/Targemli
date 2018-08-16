package com.contactlist.tal.targemli;

public class WordClass {
    String[] englishWords;
    String[] hebrewWords;

    public WordClass(String[] englishWords, String[] hebrewWords) {
        this.englishWords = englishWords;
        this.hebrewWords = hebrewWords;
    }

    public String[] getEnglishWords() {
        return this.englishWords;
    }

    public String[] getHebrewWords() {
        return this.hebrewWords;
    }

    public void setEnglishWords(String[] englishWords) {
        this.englishWords = englishWords;
    }

    public void setHebrewWords(String[] hebrewWords) {
        this.hebrewWords = hebrewWords;
    }
}
