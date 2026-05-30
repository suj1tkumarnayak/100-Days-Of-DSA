package day_061_date_2026_05_30.stack;

import java.util.*;

public class DailyTemperatures {

    public static void main(String[] args) {
        // Test cases
        int[] temps1 = {73, 74, 75, 71, 69, 72, 76, 73};
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]

        int[] temps2 = {30, 40, 50, 60};
        // Expected: [1, 1, 1, 0]

        int[] temps3 = {30, 60, 90};
        // Expected: [1, 1, 0]

        System.out.println("Test 1: " + Arrays.toString(dailyTemperatures(temps1)));
        System.out.println("Test 2: " + Arrays.toString(dailyTemperatures(temps2)));
        System.out.println("Test 3: " + Arrays.toString(dailyTemperatures(temps3)));
    }
    public static int[] dailyTemperaturesBrute(int[] temperatures) {
        int n = temperatures.length;
        int[] dailyTemp = new int[n];

        for (int i = 0; i < n-1; i++) {
            int count = 0;
            for (int j = i+1; j < n; j++) {
                count++;
                if(temperatures[j]>temperatures[i]){
                    dailyTemp[i] = count;
                    break;
                }
            }
        }

        return dailyTemp;
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t>temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                res[prevIndex] = i-prevIndex;
            }
            stack.push(i);
        }

        return res;
    }
}
