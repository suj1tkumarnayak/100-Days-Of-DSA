package day_032_date_2026_04_05.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String s = "ABC";
        // ABC ACB BAC BCA CAB CBA
        List<String> res = new ArrayList<>();
        permutes(s,new boolean[s.length()], "", res);
    }

    private static List<String> permutes(String s, boolean[] used, String anagram, List<String> res) {
        if(anagram.length() == s.length()){
            res.add(anagram);
            return res;
        }

        for (int i = 0; i < s.length(); i++) {
            if(used[i]){
                continue;
            }

            used[i] = true;
            anagram += s.charAt(i);
            permutes(s, used, anagram, res);
        }

        return null;
    }
}
