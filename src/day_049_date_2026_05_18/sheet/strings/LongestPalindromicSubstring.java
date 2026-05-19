package day_049_date_2026_05_18.sheet.strings;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeOptimized(s));
    }

    public static String longestPalindromeOptimized(String s){
        if(s==null || s.length()<2) return s;

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd center
            int len1 = expand(s, i, i);

            // for even center
            int len2 = expand(s, i, i+1);

            int maxLen = Math.max(len1, len2);

            if(maxLen>end-start+1){
                start = i - (maxLen-1)/2;
                end = i+maxLen/2;
            }
        }
        return s.substring(start, end+1);
    }
    private static int expand(String s, int left, int right){
        while(left>=0 && right<=s.length()-1 && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return right-left-1;
    }

    public static String longestPalindrome(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j+1);

                if(isPalindrom(sub)){
                    if(sub.length()>ans.length()){
                        ans = sub;
                    }
                }
            }
        }

        return ans;
    }
    public static boolean isPalindrom(String s){
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }


    //copied
    public static String longestPalindrome1(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd length palindrome
            int len1 = expand1(s, i, i);

            // even length palindrome
            int len2 = expand1(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start + 1) {

                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expand1(String s, int left, int right) {

        while (left >= 0 &&
                right < s.length() &&
                s.charAt(left) == s.charAt(right)) {

            left--;
            right++;
        }

        return right - left - 1;
    }
}
