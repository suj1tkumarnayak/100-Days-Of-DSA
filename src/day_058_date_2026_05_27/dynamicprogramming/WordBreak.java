package day_058_date_2026_05_27.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println(wordBreakRecursion(s, wordDict));
    }
    public static boolean wordBreakRecursion(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, wordDict, 0, dp);
    }
    public static boolean dfs(String s, List<String> wordDict, int i, int[] dp){
        if(i==s.length()){
            return true;
        }

        int memo = dp[i];
        if(memo!=-1) return memo==0?false:true;

        for (String word : wordDict) {
            if((i+word.length())<=s.length() && s.substring(i, i+word.length()).equals(word)){
                if(dfs(s, wordDict, i+word.length(), dp)){
                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = 0;
        return false;
    }
}
