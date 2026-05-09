package day_042_date_2026_05_09.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple","pen");
        System.out.println(wordBreakRecursion(s, wordDict));
    }
    public static boolean wordBreakBottomUp(String s, List<String> wordDict){
        int n = s.length();
        boolean[] dp = new boolean[n+1];

        dp[0] = true;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
    public static boolean wordBreakMemoization(String s, List<String> wordDict){
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return wordBreakMemoizationHelper(s, wordDict, 0, dp);
    }
    public static boolean wordBreakMemoizationHelper(String s, List<String> wordDict, int index, int[] dp){
        if(index == s.length()) return true;

        if(dp[index]!=-1) return dp[index]==0?false:true;

        for (String word : wordDict) {
            if(s.startsWith(word, index)){
                if(wordBreakMemoizationHelper(s,wordDict, index+word.length(), dp)){
                    dp[index] = 1;
                    return true;
                }
            }
        }
        dp[index] = 0;
        return false;
    }
    public static boolean wordBreakRecursion(String s, List<String> wordDict) {
        return wordBreakRecursionHelper(s,0, wordDict);
    }
    public static boolean wordBreakRecursionHelper(String s, int index, List<String> wordDict){
        if(index == s.length()) return true;

        for (String word : wordDict) {
            if(s.startsWith(word, index)){
                if(wordBreakRecursionHelper(s, index+word.length(), wordDict)){
                    return true;
                }
            }
        }

        return false;
    }
}
