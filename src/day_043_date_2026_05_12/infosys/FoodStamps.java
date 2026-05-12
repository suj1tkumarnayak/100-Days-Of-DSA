package day_043_date_2026_05_12.infosys;

import java.util.Scanner;

public class FoodStamps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] vi = new int[n];
        int[] di = new int[n];

        for (int i = 0; i < n; i++) {
            vi[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            di[i] = sc.nextInt();
        }

        System.out.println(tastePoints(n, m, vi, di));
    }
    public static int tastePoints(int n, int m, int[] vi, int[] di){
        return 1;
    }
}
