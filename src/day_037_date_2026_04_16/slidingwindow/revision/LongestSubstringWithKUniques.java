package day_037_date_2026_04_16.slidingwindow.revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithKUniques {
    public static void main(String[] args) {
        String s = "aaaaabce";//"aabacbebebe";
        int k = 3;
        System.out.println(longestKSubstr(s, k));
    }
    public static int longestKSubstr(String s, int k) {
        int maxCount = 0, j = 0;
        HashMap<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.size()<=k){
                map.put(c, map.getOrDefault(c, 0)+1);
            }else{
                char d = s.charAt(j);
                int sum = 0;
                for (int num : map.values()) {
                    sum+=num;
                }
                maxCount = Math.max(maxCount, sum);
                map.remove(d);
                j = i-1;
                while(j>=0 && s.charAt(j)!=d){
                    j--;
                }
                j++;
            }
        }
        if(maxCount==0){
            for (int num : map.values()) {
                maxCount+=num;
            }
        }
        return maxCount;
    }
}
