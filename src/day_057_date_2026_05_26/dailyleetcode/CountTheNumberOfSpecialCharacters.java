package day_057_date_2026_05_26.dailyleetcode;

import java.util.HashSet;

public class CountTheNumberOfSpecialCharacters {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }
    public static int numberOfSpecialChars(String word) {
        HashSet<Character> capletters = new HashSet<>();
        for (char c: word.toCharArray()) {
            if(c>='A' && c<='Z'){
                capletters.add(c);
            }
        }

        HashSet<Character> specialCharacter = new HashSet<>();

        for (char c : word.toCharArray()) {
            if(c>='a' && c<='z'){
                Character ch = Character.toUpperCase(c);
                if(capletters.contains(ch)) specialCharacter.add(c);
            }
        }

        return specialCharacter.size();
    }
}
