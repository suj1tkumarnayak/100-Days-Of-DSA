package Day_031_Date_2026_04_04.dynamic_programming;

public class CountingStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countStairs(n));
    }

    private static int countStairs(int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        return countStairs(n-1)+countStairs(n-2);
    }

    private static int countStairsDp(int n){
        int[] arr = new int[n+1];
        if(n==0){
            return 0;
        }
        arr[0] = 0;
        if(n==1){
            return 1;
        }
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }

        return arr[n];
    }
}
