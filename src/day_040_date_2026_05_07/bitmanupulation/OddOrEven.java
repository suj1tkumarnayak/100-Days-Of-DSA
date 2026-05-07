package day_040_date_2026_05_07.bitmanupulation;

public class OddOrEven {
    public static void main(String[] args) {
        int num= 32;
        System.out.println(findOddOrEven(num));
    }
    public static String findOddOrEven(int num){
        return (num&1)==1?"Odd":"Even";
    }
}
