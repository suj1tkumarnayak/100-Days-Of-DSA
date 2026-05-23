package day_054_date_2026_05_23.dynamicprogramming;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "11106";
        System.out.println(numDecodings(s));
    }
    public static int numDecodings(String s) {
        int[] dp = new int[s.length()];
        return dfs(s, 0, dp);
    }
    public static int dfs(String s, int i, int[] dp){
        if(i==s.length()){
            return 1;
        }

        if(s.charAt(i)=='0'){
            return 0;
        }

        if(dp[i]!=-1) return dp[i];

        // take one digit
        int res = dfs(s, i+1, dp);

        if(i<s.length()-1){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                res += dfs(s, i+2, dp);
            }
        }

        return dp[i] = res;
    }
}
