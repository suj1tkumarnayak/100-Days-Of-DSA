package day_053_date_2026_05_22.bitmanipulation;

public class CountBits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(hammingWeight(n));
    }
    public static int hammingWeight(int n){
        int count = 0;

        while (n>0){
            n = n & (n-1);
            count++;
        }

        return count;
    }
}
