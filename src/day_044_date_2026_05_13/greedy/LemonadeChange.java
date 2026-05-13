package day_044_date_2026_05_13.greedy;

public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }
    private static boolean lemonadeChange(int[] bills) {
        int fives = 0, tens = 0;
        boolean flag = true;
        for (int bill : bills) {
            if(bill==5){
                fives++;
            }else if(bill==10){
                if(fives>0){
                    fives--;
                    tens++;
                }else{
                    return false;
                }
            }else{
                if(fives>2){
                    fives-=3;
                }else if(tens>0 && fives>0){
                    fives--;
                    tens--;
                }else{
                    return false;
                }
            }
        }
        return flag;
    }
}
