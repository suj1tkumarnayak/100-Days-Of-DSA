package day_061_date_2026_05_30.stack;

import java.util.*;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        // Test Case 1: (2 + 1) * 3 = 9
        String[] tokens1 = {"2", "1", "+", "3", "*"};

        // Test Case 2: 4 + (13 / 5) = 6
        String[] tokens2 = {"4", "13", "5", "/", "+"};

        // Test Case 3: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        String[] tokens3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println("Test 1 Result (Expected: 9): " + evalRPN(tokens1));
        System.out.println("Test 2 Result (Expected: 6): " + evalRPN(tokens2));
        System.out.println("Test 3 Result (Expected: 22): " + evalRPN(tokens3));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if(s.equals("+")){
                int p = stack.pop();
                int q = stack.pop();
                stack.push(p+q);
            }
            else if(s.equals("/")){
                int p = stack.pop();
                int q = stack.pop();
                stack.push(q/p);
            }
            else if( s.equals("*")){
                int p = stack.pop();
                int q = stack.pop();
                stack.push(p*q);
            }
            else if(s.equals("-")){
                int p = stack.pop();
                int q = stack.pop();
                stack.push(q-p);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}
