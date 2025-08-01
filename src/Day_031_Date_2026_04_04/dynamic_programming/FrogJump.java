package Day_031_Date_2026_04_04.dynamic_programming;

public class FrogJump {
    public static void main(String[] args) {
        int[] nums = {7, 5, 1, 2, 6};
       // System.out.println(frogJump(nums));
        //pattern7(4);

    }
    public static int frogJump(int[] nums){
        int len = nums.length;
        int[] arr = new int[len+1];

        arr[0] = 0;
        arr[1] = Math.abs(nums[1] - nums[0]);

        for (int i = 2; i < len; i++) {
            arr[i] = Math.min(Math.abs(nums[i-1]-nums[i]), Math.abs(nums[i-2]-nums[i]));
        }
        return arr[len];
    }
//    public static int frogJumpHelper(int[] nums, int i, int j){
//
//    }

}
