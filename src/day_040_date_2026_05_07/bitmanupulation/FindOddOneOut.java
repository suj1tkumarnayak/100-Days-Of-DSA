package day_040_date_2026_05_07.bitmanupulation;

public class FindOddOneOut {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,5,3,3,3,4,4,4};
        System.out.println(findOddOneOut(nums,3));
    }
    public static int findOddOneOut(int[] nums, int k){
        int result=0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;

            for(int num:nums){
                if(((num>>bit)&1)==1){
                    count++;
                }
            }

            if(count%k!=0){
                result |= (1<<bit);
            }
        }

        return result;
    }
}
