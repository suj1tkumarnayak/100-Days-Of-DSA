package day_061_date_2026_05_30.binarysearch;

import java.util.*;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        // Test Case 1: Target exists in the matrix
        int[][] matrix1 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target1 = 3;
        // Expected Output: true

        // Test Case 2: Target does not exist in the matrix
        int[][] matrix2 = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target2 = 13;
        // Expected Output: false

        System.out.println("Test 1 (Expected: true): " + searchMatrix(matrix1, target1));
        System.out.println("Test 2 (Expected: false): " + searchMatrix(matrix2, target2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m*n-1;

        while (l<=h){
            int mid = l + ((h-l)/2);
            int r = mid/n;
            int c = mid%n;
            int element = matrix[r][c];
            if(element==target){
                return true;
            }else if(element>target){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }

        return false;
    }
}
