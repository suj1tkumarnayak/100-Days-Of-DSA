package day_051_date_2026_05_20.examquestion;

public class RobotQuestion {
    public static void main(String[] args) {
        int[] v = {5, 3, 10, -5, 7, 8};
        //int[] v = {1, 2, 3, 4, 5, 6};
        System.out.println(findMaxValue(v));
    }
    public static int findMaxValue(int[] v){
        return helper(v, 0, v.length-1);
    }
    public static int helper(int[] v, int i, int j){
        if(i<v.length-1 && j>=0 && i>=j){
            return 0;
        }
        //take one step for A and one step for B
        int a = v[i]+helper(v, i+1, j-1);
        //take one step for A and two step for B
        int b= v[i]+helper(v, i+1, j-2);
        //take two step for A and one step for B
        int c = v[i]+helper(v, i+2, j-1);
        //take two step for A and two step for B
        int d = v[i]+helper(v, i+2, j-2);
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
