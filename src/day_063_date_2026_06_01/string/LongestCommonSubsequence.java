package day_063_date_2026_06_01.string;

public class LongestCommonSubsequence {

    /**
     * Finds the length of the longest common subsequence between two strings.
     *
     * @param text1 The first input string.
     * @param text2 The second input string.
     * @return The length of the longest common subsequence.
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // TODO: Implement your logic here (Dynamic Programming or Recursion)
        return 0;
    }

    public int longestCommonSubsequenceRecursion(String text1, String text2) {

        return 0;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        // Test Case 1: Standard case with matching characters
        // Expected Output: 3 (Subsequence is "ace")
        runTest(lcs, "abcde", "ace", 3);

        // Test Case 2: Entire string matches
        // Expected Output: 3 (Subsequence is "abc")
        runTest(lcs, "abc", "abc", 3);

        // Test Case 3: No common characters
        // Expected Output: 0
        runTest(lcs, "abc", "def", 0);

        // Test Case 4: Out of order matching characters
        // Expected Output: 2 (Subsequence is "at" or "at")
        runTest(lcs, "cat", "act", 2);
    }

    private static void runTest(LongestCommonSubsequence solver, String text1, String text2, int expected) {
        int result = solver.longestCommonSubsequence(text1, text2);
        System.out.printf("Text1: \"%s\", Text2: \"%s\" -> Expected: %d, Got: %d | %s%n",
                text1, text2, expected, result, (result == expected ? "PASS" : "FAIL"));
    }
}
