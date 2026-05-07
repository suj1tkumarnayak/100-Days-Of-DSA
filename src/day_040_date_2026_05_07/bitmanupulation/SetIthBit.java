package day_040_date_2026_05_07.bitmanupulation;

public class SetIthBit {
    public static void main(String[] args) {
        int num = 10;
        //ystem.out.println(1<<3);
        //System.out.println(setIthBit(num, 0));
    }
    public static int setIthBit(int num, int i){
        return num|(1<<i);
    }
}
