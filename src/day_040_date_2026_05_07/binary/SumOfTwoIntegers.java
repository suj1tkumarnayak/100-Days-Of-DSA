package day_040_date_2026_05_07.binary;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(toBinary(1));
        System.out.println(toBinary(2));
        System.out.println(toBinary(1&2));
        //System.out.println(toBinary(5));
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
