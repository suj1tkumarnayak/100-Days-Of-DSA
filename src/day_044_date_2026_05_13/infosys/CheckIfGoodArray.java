package day_044_date_2026_05_13.infosys;

import java.util.HashMap;

public class CheckIfGoodArray {
    public static void main(String[] args) {
        int[] nums = {2,2, 2};
        System.out.println(isGood(nums));
    }
    public static boolean isGood(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            if(num>n-1) return false;
            if(map.containsKey(num)){
                if(num<n-1){
                    return false;
                }else if(num==n-1 && map.get(num)>2){
                    return false;
                }
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        return true;
    }
}
