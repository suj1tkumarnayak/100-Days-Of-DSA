package Day_029_Date_2025_12_21.dynamic_programming;

import java.math.BigInteger;
import java.util.HashMap;

import static java.math.BigInteger.*;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int num = 100000;
        System.out.println(findFibonacciTabulation(num));
    }

    private static BigInteger findFibonacciTabulation(int num) {
        if(num == 0) return ZERO;
        if(num == 1) return ONE;

        BigInteger prev1 = ONE;
        BigInteger prev2 = ZERO;

        for (int i = 2; i <= num ; i++) {
            BigInteger curr = prev1.add(prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    private static BigInteger findFibonacciMemorization(int num) {
        HashMap<Integer, BigInteger> memo = new HashMap<>();
        return findFibonacci(num, memo);
    }

    private static BigInteger findFibonacci(int num, HashMap<Integer, BigInteger> memo ){
        if(!memo.containsKey(num)){
            if(num < 2){
                memo.put(num, valueOf(num));
                return valueOf(num);
            }

            BigInteger fibonacciNum = findFibonacci(num-1, memo).add(findFibonacci(num-2, memo));
            memo.put(num, fibonacciNum);
            return fibonacciNum;
        }
        return memo.get(num);
    }

    private static int findFibonacci(int num) {
        if(num < 2){
            return num;
        }

        return findFibonacci(num-1)+findFibonacci(num-2);
    }
}
