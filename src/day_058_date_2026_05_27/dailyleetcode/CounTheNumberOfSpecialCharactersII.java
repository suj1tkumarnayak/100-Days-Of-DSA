package day_058_date_2026_05_27.dailyleetcode;

import java.util.HashMap;

public class CounTheNumberOfSpecialCharactersII {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }
    public static int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c>='A' && c<='Z'){
                if (!map.containsKey(c)){
                    map.put(c, i);
                }
            }else{
                map.put(c, i);
            }
        }

        for (char c = 'a'; c <= 'z'; c++) {
            char upper = Character.toUpperCase(c);

            if (map.containsKey(c) &&
                    map.containsKey(upper) &&
                    map.get(c) < map.get(upper)) {
                count++;
            }
        }


        return count;
    }
}
