package day_073_date_2026_06_14.dailyquestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExitPointInAMatrix {
    static int[][] direction = {
            {0, 1}, // r
            {1, 0}, // d
            {0, -1},// l
            {-1, 0} // u
    };
    public static void main(String[] args) {
        int mat[][] = {
                {0, 1, 0},
                {0, 1, 1},
                {0, 0, 0}
        };
        System.out.println(exitPoint(mat));
    }
    public static List<Integer> exitPoint(int[][] mat) {
        return dfs(mat, 0, 0, 0);
    }
    public static List<Integer> dfs(int[][] mat, int r, int c, int d){
        if(r<0){
            List<Integer> list = new ArrayList<>();
            list.add(r+1);
            list.add(c);
            return list;
        }
        if(r>= mat.length){
            List<Integer> list = new ArrayList<>();
            list.add(r-1);
            list.add(c);
            return list;
        }
        if(c<0){
            List<Integer> list = new ArrayList<>();
            list.add(r);
            list.add(c+1);
            return list;
        }
        if(c>=mat[0].length){
            List<Integer> list = new ArrayList<>();
            list.add(r);
            list.add(c-1);
            return list;
        }
        int num = mat[r][c];
        int[] dir = direction[d];
        if(num==1){
            d =(d+1)%4;
            dir = direction[d];
            mat[r][c] = 0;
        }

        return dfs(mat, r+dir[0], c+dir[1], d);
    }
}
