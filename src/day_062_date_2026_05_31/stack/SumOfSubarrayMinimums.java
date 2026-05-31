package day_062_date_2026_05_31.stack;

public class SumOfSubarrayMinimums {

    public static int sumSubarrayMins(int[] arr) {
        int sum = 0;



        return sum;
    }

    public static void main(String[] args) {
        // Test Case 1: From problem statement
        int[] test1 = {10, 20};
        System.out.println("Input:    [10, 20]");
        System.out.println("Output:   " + sumSubarrayMins(test1));
        System.out.println("Expected: 40\n");

        // Test Case 2: From problem statement
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Input:    [1, 2, 3, 4]");
        System.out.println("Output:   " + sumSubarrayMins(test2));
        System.out.println("Expected: 20\n");

        // Test Case 3: Handling duplicate values (Crucial edge case!)
        int[] test3 = {3, 1, 2, 4, 1};
        System.out.println("Input:    [3, 1, 2, 4, 1]");
        System.out.println("Output:   " + sumSubarrayMins(test3));
        System.out.println("Expected: 25\n");
    }
}
