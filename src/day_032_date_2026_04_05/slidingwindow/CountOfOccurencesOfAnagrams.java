package day_032_date_2026_04_05.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class CountOfOccurencesOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
    }
    public static int search(String pat, String txt) {
        int count = 0, k = pat.length();
        int[] patFrequency = new int[26];
        int[] windowFrequency = new int[26];

        for (int i = 0; i < pat.length(); i++) {
            patFrequency[pat.charAt(i)-'a']++;
        }

        for (int i = 0; i < txt.length(); i++) {

            windowFrequency[txt.charAt(i)-'a']++;

            if(k-i<=0){
                windowFrequency[txt.charAt(i-k)-'a']--;
            }


            if(match(patFrequency, windowFrequency)){
                count++;
            }
        }

        return count;
    }
    public static boolean match(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
