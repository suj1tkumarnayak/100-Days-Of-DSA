package day_062_date_2026_05_31.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int i = 1;
//      4, 5, 2, 25
        while (!stack.isEmpty() && i<n){
            int num = arr[i];
            while (!stack.isEmpty() && num>arr[stack.peek()]){
                result[stack.pop()] = num;
            }
            stack.add(i);
            i++;
        }

        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: Standard case
        int[] test1 = {4, 5, 2, 25};
        System.out.println("Input:  " + Arrays.toString(test1));
        System.out.println("Output: " + Arrays.toString(nextGreaterElement(test1)));
        // Expected: [5, 25, 25, -1]

        System.out.println();

        // Test Case 2: Decreasing array
        int[] test2 = {13, 7, 6, 1};
        System.out.println("Input:  " + Arrays.toString(test2));
        System.out.println("Output: " + Arrays.toString(nextGreaterElement(test2)));
        // Expected: [-1, -1, -1, -1]
    }
}
