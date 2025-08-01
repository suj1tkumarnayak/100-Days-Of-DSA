package Day_030_Date_2026_02_06.dynamic_programming;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(fibonacciRecursion(num));
    }

    private static int fibonacciRecursion(int num) {
        if(num<2){
            return num;
        }
        
        return fibonacciRecursion(num-1)+fibonacciRecursion(num-2);
    }
}
