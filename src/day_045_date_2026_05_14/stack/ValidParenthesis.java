package day_045_date_2026_05_14.stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "()[]{}";
        //System.out.println((char)('a'+1));
        System.out.println(isValid(s));
    }
    private static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }

                char top = stack.pop();

                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
                if(c == ')' && top != '(') return false;
            }
        }

        return stack.isEmpty();
    }
}
