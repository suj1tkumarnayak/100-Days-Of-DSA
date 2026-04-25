package day_038_date_2026_04_27.recursion;

import java.math.BigInteger;

public class ImplementationOfAtoi {
    public static void main(String[] args) {
        String s = "-042";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s){
        int n = s.length();
        int i = 0;
        if(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n){
            return 0;
        }
        int sign = 1;
        if(s.charAt(i)=='-'){
            sign*=-1;
        }

        if(s.charAt(i)=='-' || s.charAt(i)=='+'){
            i++;
        }
        int num = 0;

        while (i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            if(num>=(Integer.MAX_VALUE-digit)/10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num=num*10+digit;
            i++;
        }

        return num*sign;
    }
    public static int myAtoiRecursive(String s) {
        s = s.trim().replaceFirst("^0+", "");
        int num=0;
        if(s.length()==0){
            return num;
        }
        if(s.charAt(0)=='-'){
            num = helper(s.substring(1), 0, 0, true);
        }else if(s.charAt(0)=='+'){
            num = helper(s.substring(1), 0, 0, false);
        }else{
            num = helper(s, 0, 0, false);
        }
        return num;
    }
    public static int helper(String s, long num, int i, boolean neg){
        if(num==Integer.MAX_VALUE){
            return neg?Integer.MIN_VALUE+1:Integer.MAX_VALUE;
        }
        if(num>Integer.MAX_VALUE){
            if(neg){
                return Integer.MIN_VALUE;
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(i>=s.length()){
            return neg?(int)num*-1:(int)num;
        }
        if(s.charAt(i)<'0' || s.charAt(i)>'9'){
            return neg?(int)num*-1:(int)num;
        }else{
            num = num*10+(s.charAt(i)-'0');
        }
        return helper(s, num, i+1,  neg);
    }
}
