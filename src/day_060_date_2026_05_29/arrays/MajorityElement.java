package day_060_date_2026_05_29.arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = nums[0];
        int count = 1;
        int i = 1;
        while (i<n){
            int num = nums[i];
            if(count>0){
                if(num==candidate){
                    count++;
                }else{
                    count--;
                }
            }else{
                candidate = num;
                count = 1;
            }
            i++;
        }

        return candidate;
    }
}
