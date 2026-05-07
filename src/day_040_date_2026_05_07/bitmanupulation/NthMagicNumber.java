package day_040_date_2026_05_07.bitmanupulation;

public class NthMagicNumber {
    public static void main(String[] args) {
        int num = 3;
        System.out.println(findNthMagicNumber(num));
    }
    public static int findNthMagicNumber(int num){
        int sum = 0, mult = 5;
        while (num>0){
            sum += (num&1)*mult;
            mult*=5;
            num>>=1;
        }
        return sum;
    }
}
