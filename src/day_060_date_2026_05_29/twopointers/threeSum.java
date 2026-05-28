package day_060_date_2026_05_29.twopointers;

import java.util.*;

public class threeSum {

    public List<List<Integer>> threeSumTwopointer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if(nums[i]>0) break;
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i+1, r = n-1;
            while (l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                }
            }
        }

        return res;
    }

    public List<List<Integer>> threeSumHashmap(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.get(nums[i])-1);
            if(i>0 && nums[i]==nums[i-1]) continue;

            for (int j = i+1; j < n; j++) {
                count.put(nums[j], count.get(nums[j])-1);
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int target = -(nums[i]+nums[j]);
                if(count.getOrDefault(target, 0)>0){
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }

            for (int j = i+1; j < n; j++) {
                count.put(nums[j], count.get(nums[j])+1);
            }
        }

        return res;
    }

    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        result.add(list);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        threeSum solver = new threeSum();

        // Test Case 1: Standard case with multiple triplets and duplicates
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test 1 Result: " + solver.threeSumTwopointer(nums1));
        // Expected Output: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2: No valid triplets possible
        int[] nums2 = {0, 1, 1};
        System.out.println("Test 2 Result: " + solver.threeSumTwopointer(nums2));
        // Expected Output: []

        // Test Case 3: All zeros
        int[] nums3 = {0, 0, 0};
        System.out.println("Test 3 Result: " + solver.threeSumTwopointer(nums3));
        // Expected Output: [[0, 0, 0]]
    }
}
