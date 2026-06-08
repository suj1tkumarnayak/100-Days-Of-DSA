package day_069_date_2026_06_08.slidingwindow;

// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

public class NumberOfSubarrayWithAvgGreaterThanK {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int currSum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if(i>=k-1){
                int currAvg = currSum/k;
                if(currAvg>=threshold){
                    count++;
                }
                currSum -= arr[i-k+1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NumberOfSubarrayWithAvgGreaterThanK solver = new NumberOfSubarrayWithAvgGreaterThanK();

        // Test Case 1
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        int k1 = 3;
        int threshold1 = 4;
        System.out.println("Test 1 - Expected: 3, Actual: " + solver.numOfSubarrays(arr1, k1, threshold1));

        // Test Case 2
        int[] arr2 = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        int k2 = 3;
        int threshold2 = 5;
        System.out.println("Test 2 - Expected: 6, Actual: " + solver.numOfSubarrays(arr2, k2, threshold2));
    }
}
