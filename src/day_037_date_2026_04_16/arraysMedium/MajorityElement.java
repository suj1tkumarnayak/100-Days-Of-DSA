package day_037_date_2026_04_16.arraysMedium;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {6, 5, 5};
        System.out.println(majorityElement(nums));
    }

    private static int majorityElementbrute(int[] nums) {
        int majorityElement = -1;
        int majorCount = -1;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i]==nums[j] && i!=j){
                    count++;
                }
            }
            if(majorCount<count){
                majorityElement = nums[i];
                majorCount = count;
            }
        }
        return majorityElement;
    }

    public static int majorityElement2(int[] nums){
        int majorityElement  = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                majorityElement = nums[i];
                count++;
            }else if(count>nums.length/2){
                return majorityElement;
            }else if(nums[i]!=majorityElement){
                count--;
            }else{
                count++;
            }
        }
        return majorityElement;
    }
    public static int majorityElement(int[] nums){
        int candidate  = 0;
        int count = 0;

        for (int num : nums) {
            if(count==0){
                candidate = num;
            }
            if(num == candidate){
                count++;
            }else{
                count--;
            }
        }


        return candidate;
    }
}
