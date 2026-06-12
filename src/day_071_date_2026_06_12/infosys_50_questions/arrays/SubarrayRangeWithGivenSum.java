package day_071_date_2026_06_12.infosys_50_questions.arrays;

public class SubarrayRangeWithGivenSum {
    // Write your logic inside this method
    static int subArraySum(int arr[], int tar) {
        // code here
        return bruteforce(arr, tar);
    }

    static int bruteforce(int arr[], int tar){
        int count = 0;
        int n = arr.length;

        // outer loop is for the start element
        for (int i = 0; i < n; i++) {
            // inner loop for the end element
            for (int j = i; j < n; j++) {
                int sum = 0;
                // to do the sum
                for (int k = i; k < j; k++) {
                    sum+= arr[k];
                }
                if(sum==tar) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test case 1: Standard mix with positive numbers
        int[] test1 = {10, 2, -2, -20, 10};
        int target1 = -10;
        System.out.println("Test 1 Result: " + subArraySum(test1, target1)); // Expected output: 3 (Subarrays: [10, 2, -2, -20], [2, -2, -20, 10], [-20, 10])

        // Test case 2: Simple array with zeroes
        int[] test2 = {1, 0, 1, 0, 1};
        int target2 = 1;
        System.out.println("Test 2 Result: " + subArraySum(test2, target2)); // Expected output: 7
    }
}
