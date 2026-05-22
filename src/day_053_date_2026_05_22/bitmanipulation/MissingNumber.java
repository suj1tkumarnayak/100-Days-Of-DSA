package day_053_date_2026_05_22.bitmanipulation;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumberMath(nums));
    }
    public static int missingNumberArrays(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if(nums[i]!=i){
                return i;
            }
        }
        return -1;
    }
    public static int missingNumberHashSet(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if(!set.contains(i)){
                return i;
            }
        }

        return -1;
    }
    public static int missingNumberXOR(int[] nums){
        int xor=nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i]^i;
        }
        return xor;
    }
    public static int missingNumberMath(int[] nums){
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i-nums[i];
        }
        return res;
    }
}
