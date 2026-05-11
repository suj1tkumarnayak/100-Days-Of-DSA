package Day_008_Date_2024_12_12.greedyTechnique;

import java.util.HashMap;

public class LemonadeChange {
    public static void main(String[] args) {

//        int[] bills = {5,5,5,10,20};
        int[] bills = {10,10};

        System.out.println(lemonadeChange2(bills));

    }

    private static boolean lemonadeChange2(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;

        for(int bill: bills){
            switch (bill){
                case 5:
                    fiveCount++;
                    break;
                case 10:
                    if(fiveCount>0){
                        fiveCount--;
                        tenCount++;
                    }else {
                        return false;
                    }
                    break;
                case 20:
                    if(tenCount>0 && fiveCount>0){
                        fiveCount--;
                        tenCount--;
                    }else if(fiveCount>2){
                        fiveCount-=3;
                    }else {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }

    private static boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int num : bills){

            // add the denomination or update the count
            map.put(num, map.getOrDefault(num,0)+1);

//            track the money you have until now
            sum += 5;

            // change we need to give back
            int change = num-5;

            // if change is greater than what we have until now just return false right back
            if(change> sum){
                return false;
            }

            switch (change){
                case 5 :
                    if(map.getOrDefault(5,0)>0){
                        map.put(5, map.get(5)-1);
                    }else{
                        return false;
                    }
                case 10 :
                    if(map.getOrDefault(5,0)>0){
                        map.put(5, map.get(5)-1);
                    }else{
                        return false;
                    }
                    break;
                case 15 :
                    if(map.getOrDefault(10,0)>0){
                        if(map.getOrDefault(5,0)>0){
                            map.put(10, map.get(10)-1);
                            map.put(5, map.get(5)-1);
                        }else{
                            return false;
                        }
                    }else if( map.getOrDefault(5,0) > 2){
                        map.put(5, map.get(5)-3);
                    }else {
                        return false;
                    }
                    break;
                default:
                    break;
            }

        }

        return true;
    }
}
