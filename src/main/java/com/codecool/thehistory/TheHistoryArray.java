package com.codecool.thehistory;

import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
//        text = text.replaceAll("\\s+", " ");
//        int currentSize = wordsArray.length;
//        int newSize = currentSize + 1;
//        String[] tempArray = new String[newSize];
//
//        for(int i = 0;i < currentSize;i++){
//            System.out.println(wordsArray[i]);
//            tempArray[i] = wordsArray[i];
//        }
//
//        tempArray[currentSize] = text;
//        wordsArray = tempArray;

        String words = text.replaceAll("\\s+", " ");
        String[] wordsSplit = words.split(" ");

        System.arraycopy(wordsArray, 0, wordsSplit, 0, wordsArray.length);

        wordsArray = wordsSplit;


    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        String finalString = "";
        for(int i = 0; i < wordsArray.length;i++){
            if(!wordsArray[i].equals(wordToBeRemoved)){
                finalString += wordsArray[i] + " ";
            }
        }
        wordsArray = finalString.split(" ");
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for(int i = 0; i < wordsArray.length;i++){
            if(wordsArray[i].equals(from)){
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
        String words = String.join(" ", wordsArray);
        String from = String.join(" ", fromWords);
        String to = String.join(" ", toWords);
        String finalString = words.replaceAll(from, to);

        wordsArray = finalString.split(" ");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
