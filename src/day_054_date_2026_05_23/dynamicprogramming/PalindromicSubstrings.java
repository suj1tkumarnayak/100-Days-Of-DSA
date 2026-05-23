package day_054_date_2026_05_23.dynamicprogramming;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            count += odd+even;
        }

        return count;
    }
    public static int expand(String s, int l, int r){
        int count = 0;

        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }

        return count;
    }
}
