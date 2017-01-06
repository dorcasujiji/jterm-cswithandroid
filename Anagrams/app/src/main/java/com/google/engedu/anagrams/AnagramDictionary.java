/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.engedu.anagrams;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import android.util.*;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    private HashSet<String> wordSet = new HashSet<>();
    private HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();

    @VisibleForTesting
    public AnagramDictionary(String[] words) {
        Log.d("Testing constructor", "reading test dictionary");
        for (int i = 0; i < words.length; i++) {
            update(words[i]); // Your code here
        }
    }

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim().toLowerCase();
            //
            //  Your code here
            //
            update(word);

        }
        //Log.d("dictionary", wordList.get(10));
    }

    // Update wordSet and lettersToWord
    private void update(String word){
        String sortedWord = sortLetters(word);
        wordSet.add(word);
        if(lettersToWord.containsKey(sortedWord)){
            // add to list of words
            lettersToWord.get(sortedWord).add(word);
        }
        else{
            // add sorted word and add to list of words
            ArrayList<String> storedWords = new ArrayList<>();
            storedWords.add(word);
            lettersToWord.put(sortedWord,storedWords);
        }
    }

    public boolean isGoodWord(String word, String base) {
//        boolean quest = false;
//
//        if(wordSet.contains(word)){
//            if(base.contains(word)){
//                quest = true;
//            }
//        }
//        return quest;
        if (!wordSet.contains(word)) {
            return false;
        }
        if (word.contains(base)) {
            return false;
        }
        return true;
    }

    public ArrayList<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        //
        // Your code here
        //
        //gets list of anagrams from HashMap
        result = lettersToWord.get(sortLetters(targetWord));
        // return list of anagrams
        return result;
    }

    static String sortLetters(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        String sortWord = new String(chars);
        // add here
        return sortWord;
    }

    @VisibleForTesting
    static boolean isAnagram(String first, String second) {
        boolean quest = false;
        //
        // Your code here
        if(sortLetters(first).equals(sortLetters(second))){
            quest = true;
        }
        return quest;
    }


    public ArrayList<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        //
        // Your code here
        char[] chars = word.toCharArray();
        ;
        Arrays.sort(chars);
        String sortWord = new String(chars);
        //
        return result;
    }

    public String pickGoodStarterWord() {
        //
        // Your code here
        //

        return "stop";
    }
}
