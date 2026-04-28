package day_038_date_2026_04_27.matrix;

import java.util.Arrays;

public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        transpose(matrix);
        for(int[] num:matrix){
            System.out.println(Arrays.toString(num));
        }
    }
    public static void transpose(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i==j) continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
