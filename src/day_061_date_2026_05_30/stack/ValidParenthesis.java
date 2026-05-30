package day_061_date_2026_05_30.stack;

import java.util.*;

public class ValidParenthesis {

    public static void main(String[] args) {
        // Test cases
        String test1 = "()";     // True
        String test2 = "()[]{}"; // True
        String test3 = "(]";     // False
        String test4 = "([)]";   // False
        String test5 = "{[]}";   // True

        System.out.println("Test 1: " + isValid(test1));
        System.out.println("Test 2: " + isValid(test2));
        System.out.println("Test 3: " + isValid(test3));
        System.out.println("Test 4: " + isValid(test4));
        System.out.println("Test 5: " + isValid(test5));
    }

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if("{[(".contains(c+"")){
                st.push(c);
            }else{
                if(st.isEmpty()) return false;
                char currChar = st.pop();
                switch (c){
                    case ')': if(currChar!='(') return false;
                                else continue;
                    case '}': if(currChar!='{') return false;
                                else continue;
                    case ']': if(currChar!='[') return false;
                                else continue;
                }
            }
        }


        return st.isEmpty();
    }
}
