package day_039_date_2026_05_04.arrays;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
    public static int maxProductBrute(int[] nums){
        int n = nums.length;
        int maxProduct = nums[0];
        int currProduct = nums[0];
        for (int i = 1; i < n; i++) {
            currProduct = Math.max(nums[i], nums[i]*currProduct);
            maxProduct = Math.max(maxProduct, currProduct);
        }

        return maxProduct;
    }
    public static int maxProduct(int[] nums){
        int n = nums.length;
        int minProd = nums[0];
        int maxProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];

            int tempMinProd = Math.min(curr, Math.min(curr*minProd, curr*maxProd));
            int tempMaxProd = Math.max(curr, Math.max(curr*maxProd, curr*minProd));

            minProd = tempMinProd;
            maxProd = tempMaxProd;
            result = Math.max(result, maxProd);
        }

        return result;
    }
}
