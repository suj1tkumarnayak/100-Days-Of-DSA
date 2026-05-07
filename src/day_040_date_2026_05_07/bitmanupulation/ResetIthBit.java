package day_040_date_2026_05_07.bitmanupulation;

public class ResetIthBit {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(resetIthBit(num, 1));
    }
    public static int resetIthBit(int num, int i){
        return num&(~(1<<i));
    }
}
