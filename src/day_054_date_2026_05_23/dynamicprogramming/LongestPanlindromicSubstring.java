package day_054_date_2026_05_23.dynamicprogramming;

public class LongestPanlindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindromeTwoPointer(s));
    }

    public static String longestPalindromeBrute(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String subString = s.substring(i, j);
                if(isPanlindrome(subString)){
                    if(subString.length()>ans.length()){
                        ans = subString;
                    }
                }
            }
        }
        return ans;
    }
    public static boolean isPanlindrome(String s){
        int i = 0, j = s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static String longestPalindromeDP(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
//           babad
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len -1 < n; i++) {
                int j = i + len - 1;
                if(s.charAt(i)==s.charAt(j)){
                    if(len <= 2 || dp[i+1][j-1]){
                        dp[i][j] = true;

                        if (len > ans.length()){
                            ans = s.substring(i, j+1);
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    public static String longestPalindromeTwoPointer(String s) {
        int n = s.length();
        // babad
        if(n < 2) return s;
        String ans = "";
        for (int i = 0; i < n; i++) {
            // assume i is the odd center
            String odd = expand(s, i, i);
            // assume i is the even center
            String even = expand(s, i, i+1);

            if(odd.length()>ans.length()){
                ans = odd;
            }
            if(even.length()>ans.length()){
                ans = even;
            }
        }
        return ans;
    }
    public static String expand(String s, int l, int r){
        while( l>=0 && r<=s.length()-1 && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
