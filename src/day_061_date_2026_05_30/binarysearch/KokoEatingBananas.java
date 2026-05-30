package day_061_date_2026_05_30.binarysearch;

import java.util.*;

public class KokoEatingBananas {

    public static void main(String[] args) {
        // Test Case 1: Standard bounds
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        // Expected Output: 4

        // Test Case 2: Hours equal number of piles (must pick max pile size)
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        // Expected Output: 30

        // Test Case 3: Ample time available
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        // Expected Output: 23

        System.out.println("Test 1 Speed (Expected: 4): " + minEatingSpeed(piles1, h1));
        System.out.println("Test 2 Speed (Expected: 30): " + minEatingSpeed(piles2, h2));
        System.out.println("Test 3 Speed (Expected: 23): " + minEatingSpeed(piles3, h3));
    }

    public static int minEatingSpeed(int[] piles, int h) {

        return 0;
    }
}
