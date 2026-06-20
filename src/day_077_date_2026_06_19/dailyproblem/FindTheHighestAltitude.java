package day_077_date_2026_06_19.dailyproblem;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        // Test Case 1: Road goes up and down
        int[] gain1 = {-5, 1, 5, 0, -7};
        // Altitudes: [0, -5, -4, 1, 1, -6]. Highest is 1.
        System.out.println("Test 1: " + largestAltitude(gain1) + " (Expected: 1)");

        // Test Case 2: Road keeps going down
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        // Altitudes: [0, -4, -7, -9, -10, -6, -3, -1]. Highest is 0.
        System.out.println("Test 2: " + largestAltitude(gain2) + " (Expected: 0)");

        // Test Case 3: Road keeps going up
        int[] gain3 = {2, 3, 4};
        // Altitudes:. Highest is 9.
        System.out.println("Test 3: " + largestAltitude(gain3) + " (Expected: 9)");
    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;

        for (int num : gain) {
            curr += num;
            max = Math.max(max, curr);
        }

        return max;
    }
}
