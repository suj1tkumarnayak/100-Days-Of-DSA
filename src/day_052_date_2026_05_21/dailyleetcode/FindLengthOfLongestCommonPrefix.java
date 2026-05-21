package day_052_date_2026_05_21.dailyleetcode;

import java.util.HashSet;

//https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/?envType=daily-question&envId=2026-05-21
public class FindLengthOfLongestCommonPrefix {
    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2){
        HashSet<Integer> prefixes = new HashSet<>();
        int maxLen = 0;
        for (int val : arr1) {
            while (val>0){
                prefixes.add(val);
                val/=10;
            }
        }

        for (int val : arr2) {
            while (val>0){
                if(prefixes.contains(val)){
                    maxLen = Math.max(maxLen, Integer.toString(val).length());
                    break;
                }
                val/=10;
            }
        }
        return maxLen;
    }
    public static int longestCommonPrefixBrute(int[] arr1, int[] arr2) {
        int m = arr1.length, n = arr2.length;
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxLen = Math.max(maxLen, commonPrefixDigts(arr1[i], arr2[j]));
            }
        }

        return maxLen;
    }

    public static int commonPrefixDigts(int num1, int num2){
        String s1 = Integer.toString(num1);
        String s2 = Integer.toString(num2);

        int i = 0, j = 0;
        int len = 0;
        while (i < s1.length() && j < s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                len++;
            }else{
                break;
            }
            i++;
            j++;
        }
        return len;
    }
}
