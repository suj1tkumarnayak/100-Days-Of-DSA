package day_038_date_2026_04_27.recursion;

public class PowerOfNBaseX {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = -10;
        System.out.println(myPow(x, n));
    }

    private static double myPow(double x, int n) {
        return helper(x, n, 1);
    }

    private static double helper(double x, int n, int result){
        if(n==0 || x == 1){
            return result;
        }
        if(n%2==0){

        }
        return 1;
    }

    public static double myPowBrute(double x, int n) {
        double result = 1;
        if(n==0 || x == 1){
            return result;
        }

        for (int i = 0; i < n; i++) {
            result *= x;
        }

        for(int i = n; i<0;i++){
            result*=x;
        }

        return n<0?1/result:result;
    }
}
