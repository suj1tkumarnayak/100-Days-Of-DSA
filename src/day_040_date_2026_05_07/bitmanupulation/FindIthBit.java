package day_040_date_2026_05_07.bitmanupulation;

public class FindIthBit {
    public static void main(String[] args) {
        int num = 10;
        int i = 3;
        System.out.println(findIthBit(num, i));
    }
    public static int findIthBit(int num, int i){
        return (num>>i)&1;
        //return num&(1<<i);
    }
}
