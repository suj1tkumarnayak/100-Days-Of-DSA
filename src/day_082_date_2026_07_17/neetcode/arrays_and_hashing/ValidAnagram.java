package day_082_date_2026_07_17.neetcode.arrays_and_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ValidAnagram {

    public static void main(String[] args) {
        // Test Cases: {String s, String t, Expected Boolean Output}
        Object[][] testCases = {
                {"anagram", "nagaram", true},   // Standard valid lowercase anagram
                {"rat", "car", false},          // Same length, different characters
                {"a", "ab", false},             // Different lengths
                {"", "", true},                 // Edge Case: Empty strings
                {"listen", "silent", true}     // Case sensitivity check (L vs l)
        };

        ValidAnagram solver = new ValidAnagram();

        // Run tests across all three approaches
        runTests("1. Sorting (O(N log N))", solver::isAnagramSorting, testCases);
        runTests("2. Frequency Array (O(N))", solver::isAnagramFrequencyArray, testCases);
        runTests("3. HashMap (O(N))", solver::isAnagramHashMap, testCases);
    }

    /**
     * Helper method to run and print the test results dynamically.
     */
    private static void runTests(String approachName, BiFunction<String, String, Boolean> algorithm, Object[][] testCases) {
        System.out.println("==================================================");
        System.out.println(" RUNNING TESTS FOR: " + approachName);
        System.out.println("==================================================");

        int passed = 0;
        for (int i = 0; i < testCases.length; i++) {
            String s = (String) testCases[i][0];
            String t = (String) testCases[i][1];
            boolean expected = (boolean) testCases[i][2];

            boolean result = algorithm.apply(s, t);

            if (result == expected) {
                passed++;
                System.out.println("Test " + (i + 1) + ": PASS | s = \"" + s + "\", t = \"" + t + "\" -> Output: " + result);
            } else {
                System.out.println("Test " + (i + 1) + ": FAIL | s = \"" + s + "\", t = \"" + t + "\" | Expected: " + expected + " | Got: " + result);
            }
        }
        System.out.println("Result: " + passed + "/" + testCases.length + " tests passed.\n");
    }

    /**
     * Approach 1: Sorting
     * Time Complexity: O(N log N) | Space Complexity: O(N) to convert strings to char arrays
     * * Strategy:
     * - If lengths are different, return false immediately.
     * - Convert both strings to character arrays.
     * - Sort both arrays and compare if they are equal.
     */
    public boolean isAnagramSorting(String s, String t) {
        if(s.length()!=t.length()) return false;

        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);

        for (int i = 0; i < s.length(); i++) {
            if(sArray[i]!=tArray[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 2: Frequency Array (Optimal for lowercase English letters)
     * Time Complexity: O(N) | Space Complexity: O(1) (fixed array size of 26)
     * * Strategy:
     * - If lengths are different, return false immediately.
     * - Initialize a tracker array of size 26 for English letters.
     * - Increment positions for characters in `s` and decrement for characters in `t`.
     * - If all elements in the tracker array end up as 0, they are anagrams!
     */
    public boolean isAnagramFrequencyArray(String s, String t) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c-'a']--;
        }

        for (int count : freq) {
            if(count!=0) return false;
        }

        return true;
    }

    /**
     * Approach 3: HashMap (Optimal for Unicode/Universal inputs)
     * Time Complexity: O(N) | Space Complexity: O(K) where K is unique characters
     * * Strategy:
     * - Works exactly like the frequency array, but handles any characters (including spaces, symbols, and Unicode).
     * - Count frequencies using a Map, decrementing with the second string.
     */
    public boolean isAnagramHashMap(String s, String t) {
        HashMap<Character, Integer> freqCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqCount.put(c, freqCount.getOrDefault(c, 0)+1);
        }

        for (char c : t.toCharArray()) {
            freqCount.put(c, freqCount.getOrDefault(c, 0)-1);
        }

        for (Map.Entry<Character, Integer> e : freqCount.entrySet()) {
            if(e.getValue()!=0) return false;
        }


        return true;
    }
}