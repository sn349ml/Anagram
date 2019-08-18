package com.sn349ml;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * This class takes argument as a given source
 * Parse the character and find all anagrams words in dictionary
 */
public class AnagramSearcher {
    private int[] inputChars;
    //private final String dictionaryPath = "/usr/share/dict/words";
    private final String dictionaryPath = "https://raw.githubusercontent.com/lad/words/master/words";
    private final String abnormalCharException = "User input has abnormal character";
    private int stringSize;
    private String originalString;

    public AnagramSearcher(String userInput) throws IOException {
        if(!validInput(userInput)) throw new IOException(abnormalCharException);
        inputChars = new int[26];
        stringSize = 0;
        originalString = userInput.toLowerCase();
        for(char c: userInput.toLowerCase().toCharArray()) {
            inputChars[(int) c - 'a']++;
            stringSize++;
        }
    }

    private boolean validInput(String userInput) {
        if(userInput == null) return false;
        for(char c: userInput.toLowerCase().toCharArray()) {
            int charRange = (int) c - 'a';
            if(charRange < 0 || charRange > 26) return false;
        }
        return true;
    }

    public Set<String> findALlWords() {
        return searchDictionary();
    }

    private Set<String> searchDictionary() {
        Set<String> res = new HashSet<>();
        BufferedReader reader = null;
        try {
            URL url = new URL(dictionaryPath);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if(line.length() != stringSize || originalString.equals(line) || res.contains(line)) continue;
                if(isMatch(line)) res.add(line);
                else continue;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    private boolean isMatch(String line) {
        int[] lineCharCount = new int[26];
        for(char c: line.toCharArray()) lineCharCount[c - 'a']++;
        for(int i = 0; i < lineCharCount.length; i++) if(lineCharCount[i] != inputChars[i]) return false;
        return true;
    }

}
