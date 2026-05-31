package day_062_date_2026_05_31.dailyleetcode;

import java.util.*;

public class DestroyingAsteroids {

    public static void main(String[] args) {
        // Test Case 1: Planet can successfully destroy all asteroids
        int mass1 = 10;
        int[] asteroids1 = {3, 9, 19, 5, 21};
        // Expected Output: true

        // Test Case 2: Planet gets blocked by a massive asteroid early on
        int mass2 = 5;
        int[] asteroids2 = {4, 9, 23, 4};
        // Expected Output: false

        System.out.println("Test 1 (Expected: true): " + asteroidsDestroyedBrute(mass1, asteroids1));
        System.out.println("Test 2 (Expected: false): " + asteroidsDestroyedBrute(mass2, asteroids2));
    }

    public static boolean asteroidsDestroyedBrute(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for (int num : asteroids) {
            if(num>currMass){
                return false;
            }
            currMass += num;
        }

        return true;
    }
}
