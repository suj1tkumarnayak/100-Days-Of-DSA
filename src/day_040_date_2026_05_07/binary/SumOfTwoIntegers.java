package day_040_date_2026_05_07.binary;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(toBinary(1));
        System.out.println(toBinary(2));
        System.out.println(toBinary(1&2));
        //System.out.println(toBinary(5));

    }
    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;

        for (int bit = 0; bit < 32; bit++) {
            int add = (((a>>1)&1)^((b>>1)&1))^carry;
            carry = (((a>>1)&1)&((b>>1)&1))&carry;
            //res|=()
        }

        return res;
    }
    public static String toBinary(int n) {
        if (n == 0) return "0";
        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary;
            n = n / 2;
        }
        return binary;
    }
}
