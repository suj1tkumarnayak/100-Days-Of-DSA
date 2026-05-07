package day_040_date_2026_05_07.bitmanupulation;

public class NoOfDigitsInBaseB {
    public static void main(String[] args) {
        int num = 112;
        System.out.println(noOfDigitsInBaseB(num, 2));
    }
    public static int noOfDigitsInBaseB(int num, int base){
        return (int)(Math.log(num)/Math.log(base))+1;
    }
}
