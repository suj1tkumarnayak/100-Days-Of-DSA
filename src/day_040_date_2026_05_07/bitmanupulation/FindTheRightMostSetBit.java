package day_040_date_2026_05_07.bitmanupulation;

public class FindTheRightMostSetBit {
    public static void main(String[] args) {
        int num = 100;
        System.out.println(findTheRightMSB(num));
    }
    // find the index of the right most set bit
//    public static int findTheRightMSB(int num){
//        int count = 0;
//
//        while(num>0 && (num&1)==0){
//            count++;
//            num>>=1;
//        }
//
//        return count;
//    }
    public static int findTheRightMSB(int num){
        return num&(-num);
    }
}
