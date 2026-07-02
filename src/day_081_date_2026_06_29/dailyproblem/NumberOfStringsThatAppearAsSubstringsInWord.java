package day_081_date_2026_06_29.dailyproblem;

public class NumberOfStringsThatAppearAsSubstringsInWord {

    public static void main(String[] args) {
        NumberOfStringsThatAppearAsSubstringsInWord solver = new NumberOfStringsThatAppearAsSubstringsInWord();

        // ==========================================
        // TEST CASES
        // ==========================================

        // Test Case 1: Standard case with partial matches and duplicates
        String[] patterns1 = {"a", "abc", "bc", "d"};
        String word1 = "abc";
        System.out.println("--- Test Case 1 ---");
        System.out.println("Expected: 3 (a, abc, bc)");
        System.out.println("Brute Force Result: " + solver.numOfStringsBruteForce(patterns1, word1));
        System.out.println("Optimized Result:   " + solver.numOfStringsOptimized(patterns1, word1));
        System.out.println();

        // Test Case 2: No patterns match
        String[] patterns2 = {"xyz", "foo", "bar"};
        String word2 = "abcdef";
        System.out.println("--- Test Case 2 ---");
        System.out.println("Expected: 0");
        System.out.println("Brute Force Result: " + solver.numOfStringsBruteForce(patterns2, word2));
        System.out.println("Optimized Result:   " + solver.numOfStringsOptimized(patterns2, word2));
        System.out.println();

        // Test Case 3: All patterns match, including overlapping and identical patterns
        String[] patterns3 = {"a", "a", "a"};
        String word3 = "ab";
        System.out.println("--- Test Case 3 ---");
        System.out.println("Expected: 3");
        System.out.println("Brute Force Result: " + solver.numOfStringsBruteForce(patterns3, word3));
        System.out.println("Optimized Result:   " + solver.numOfStringsOptimized(patterns3, word3));
    }

    /**
     * Approach 1: Brute Force / Direct Matching
     * Time Complexity: O(N * M), where N is patterns.length and M is word.length().
     * Space Complexity: O(1)
     */
    public int numOfStringsBruteForce(String[] patterns, String word) {
        int count = 0;
        // TODO: Implement using direct string matching (e.g., String.contains())
        return count;
    }

    /**
     * Approach 2: Optimized for Large Scale (Trie-based or Aho-Corasick structure)
     * Useful when 'word' is massive or streamed, and patterns are looked up simultaneously.
     */
    public int numOfStringsOptimized(String[] patterns, String word) {
        int count = 0;
        // TODO: Implement an optimized lookup strategy (e.g., building a suffix structure or Trie)
        return count;
    }
}