package Day_029_Date_2025_12_21.dynamic_programming;

import java.util.HashMap;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s = "ABCDGH";
        String t = "AEDFHR";
        System.out.println(findLongestCommonSubsequenceTabulation(s, t));
    }

    private static int findLongestCommonSubsequenceTabulation(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        int[][] dp = new int[slen][tlen];

        for (int i = 0; i < slen; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < tlen; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < slen; i++) {
            for (int j = 1; j < tlen; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[slen-1][tlen-1];
    }

    private static int findLongestCommonSubsequenceMemorization(String s, String t) {
        HashMap<String, Integer> memoS = new HashMap<>();
        return findLongestCommonSubsequence(s, t, memoS);
    }

    private static int findLongestCommonSubsequence(String s, String t, HashMap<String, Integer> memo){
        String key = s+"|"+t;
        if(memo.containsKey(key)){
            return memo.get(key);
        }


        if(s.length() == 0 || t.length()==0){
            memo.put(key, 0);
            return 0;
        }

        int val;

        if(s.charAt(0) == t.charAt(0)){
            val = 1 + findLongestCommonSubsequence(s.substring(1), t.substring(1));
        }
        else{
            val = Math.max(
                    findLongestCommonSubsequence(s.substring(1), t, memo),
                    findLongestCommonSubsequence(s, t.substring(1), memo));
        }

        memo.put(key, val);

        return val;
    }

    private static int findLongestCommonSubsequence(String s, String t) {
        if (s.length() == 0 || t.length() == 0){
            return 0;
        }

        if(s.charAt(0) == t.charAt(0)){
            return 1+findLongestCommonSubsequence(s.substring(1), t.substring(1));
        }

        return Math.max(findLongestCommonSubsequence(s.substring(1), t), findLongestCommonSubsequence(s, t.substring(1)));
    }
}
