package day_041_date_2026_05_08.bitmanipulation;

public class HammingWeight {
    public static void main(String[] args) {
        int num = Integer.MAX_VALUE;
        System.out.println(hammingWeight(num));
    }
    public static int hammingWeight(int num){
        int sum = 0;
        while(num>0){
            sum += (num&1);
            num>>=1;
        }
        return sum;
    }
}
