package day_053_date_2026_05_22.bitmanipulation;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(getSumXOR(a, b));
    }
    public static int getSumXOR(int a, int b){
        while (b!=0){
            int carry = (a&b)<<1;
            a ^= b;
            b = carry;
        }
        return a;
    }
    public static int getSum(int a, int b){
        int res = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int bitA = (a>>i)&1;
            int bitB = (b>>i)&1;

            int sum = bitA+bitB+carry;

            if(sum==0){
                carry = 0;
            }else if(sum==1){
                carry = 0;
                res |= (1<<i);
            }else if(sum==2){
                carry = 1;
            } else if(sum==3){
                carry = 1;
                res |= (1<<i);
            }
        }

        return res;
    }
}
