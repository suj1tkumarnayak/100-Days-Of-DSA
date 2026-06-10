package day_070_date_2026_06_09.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        // TODO: Write your sliding window logic here
        return 0;
    }

    public static void main(String[] args) {
        // Test cases to check your code
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";

        System.out.println("Test 1 (Expected: 3): " + lengthOfLongestSubstring(test1));
        System.out.println("Test 2 (Expected: 1): " + lengthOfLongestSubstring(test2));
        System.out.println("Test 3 (Expected: 3): " + lengthOfLongestSubstring(test3));
        System.out.println("Test 4 (Expected: 0): " + lengthOfLongestSubstring(test4));
    }
}
