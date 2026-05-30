package day_061_date_2026_05_30.stack;

import java.util.*;

public class MinStack {

    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();

    }

    public void push(int val) {
    }

    public void pop() {
    }

    public int top() {
        return 0;
    }

    public int getMin() {
        return 0;
    }

    public static void main(String[] args) {
        // Test Case execution
        MinStack minStack = new MinStack();

        System.out.println("Pushing: -2, 0, -3");
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Current Min (Expected: -3): " + minStack.getMin());

        System.out.println("Popping top element...");
        minStack.pop();

        System.out.println("Current Top (Expected: 0): " + minStack.top());
        System.out.println("Current Min (Expected: -2): " + minStack.getMin());
    }
}
