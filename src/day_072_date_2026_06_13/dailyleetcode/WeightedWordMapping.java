package day_072_date_2026_06_13.dailyleetcode;

import java.util.Arrays;

public class WeightedWordMapping {

    public static void main(String[] args) {
        // Test data from Example 1
        String[] words = {"abcd", "def", "xyz"};
        int[] weights = {
                5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7,
                8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2
        };

        System.out.println("Words: " + Arrays.toString(words));

        // Call your method
        String result = mapWordWeights(words, weights);

        // Expected output for Example 1: "rij"
        System.out.println("Your Output: " + result);
        System.out.println("Expected:    rij");
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        // Guard clause for safety
        if (words == null || weights == null || weights.length != 26) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            int weight = 0;
            for (char c : word.toCharArray()) {
                weight+= weights[c-'a'];
            }
            weight%=26;
            sb.append((char)('z'-weight));
        }


        return sb.toString();
    }
}
