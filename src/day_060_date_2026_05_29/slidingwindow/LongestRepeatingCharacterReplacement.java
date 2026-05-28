package day_060_date_2026_05_29.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int maxLength = 0;
        // TODO: 1. Create a frequency array/map to count characters in the window (e.g., int[26])
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }

        // TODO: 2. Track the maximum frequency of any single character inside the current window



        // TODO: 3. Use a sliding window with a 'left' and 'right' pointer

        // TODO: 4. If (window_length - max_frequency > k), shrink the window from the left

        // TODO: 5. Update maxLength with the largest valid window found

        return maxLength;
    }

    public int characterReplacementSlidingWindow(String s, int k) {
        int res = 0;
        int n = s.length();

        return res;
    }

    public int characterReplacementBruteForce(String s, int k) {
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> count = new HashMap<>();
            int maxf = 0;
            for (int j = i; j < n; j++) {
                count.put(s.charAt(j), count.getOrDefault(s.charAt(j), 0)+1);
                maxf = Math.max(maxf, count.get(s.charAt(j)));
                if((j-i+1)-maxf<=k){
                    res = Math.max(res, j-i+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement solver = new LongestRepeatingCharacterReplacement();

        // Test Case 1: Standard case where replacing one character bridges two groups
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println("Test 1 Result: " + solver.characterReplacement(s1, k1));
        // Expected Output: 4 (Replace both 'B's or both 'A's to get "AAAA" or "BBBB")

        // Test Case 2: Substring optimization with multiple distinct characters
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("Test 2 Result: " + solver.characterReplacement(s2, k2));
        // Expected Output: 4 (Replace the 'A' at index 2 to get "BBBB")

        // Test Case 3: k is larger than needed or string is uniform
        String s3 = "AAAA";
        int k3 = 2;
        System.out.println("Test 3 Result: " + solver.characterReplacement(s3, k3));
        // Expected Output: 4
    }
}
