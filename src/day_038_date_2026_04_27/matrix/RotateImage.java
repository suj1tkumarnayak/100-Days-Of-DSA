package day_038_date_2026_04_27.matrix;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateBrute(matrix);
        for(int[] num:matrix){
            System.out.println(Arrays.toString(num));
        }
    }
    public static void rotateBrute(int[][] matrix){
        int len = matrix.length;
        int[][] result=new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[j][len-1-i] = matrix[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                matrix[i][j] = result[i][j];
            }
        }
    }
}
