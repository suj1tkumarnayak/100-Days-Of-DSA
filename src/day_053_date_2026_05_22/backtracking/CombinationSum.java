package day_053_date_2026_05_22.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result;
    public static void main(String[] args) {
        int[] nums = {2,3,5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(nums, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> combinationSum2(int[] nums, int target){
        //List<List<Integer>> result = new ArrayList<>();
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, temp, 0);
        return result;
    }

    public static void dfs(int[] nums, int target, int total, List<Integer> temp, int index){
        if(total==target){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            int currTotal = total+nums[i];
            if(currTotal>target){
                return;
            }
            temp.add(nums[i]);
            dfs(nums, target, currTotal, temp, i);
            temp.remove(temp.lastIndexOf(nums[i]));
        }
    }

    public static List<List<Integer>> combinationSum1(int[] nums, int target){
        return helper1(nums, target, 0, new ArrayList<>(), new ArrayList<>());
    }

    public static List<List<Integer>> helper1(int[] nums, int target, int index, List<Integer> temp, List<List<Integer>> result){
        if(index >= nums.length) return result;
        if(target==0){
            result.add(List.copyOf(temp));
            return result;
        }
        if(target<0){
            return result;
        }
        //skip
        helper1(nums, target, index+1, temp, result);

        //take
        temp.add(nums[index]);
        helper1(nums, target-nums[index], index, temp, result);
        temp.remove(temp.lastIndexOf(nums[index]));

        return result;
    }
}
