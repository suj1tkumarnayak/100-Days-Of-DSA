package day_055_date_2026_05_24.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: Implement the backtracking logic here
        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        // Expected: [[2, 2, 3], [7]]
        System.out.println("Test 1 Result: " + combinationSumRecursion(candidates1, target1));

        // Test Case 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        // Expected: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]
        System.out.println("Test 2 Result: " + combinationSumRecursion(candidates2, target2));

        // Test Case 3
        int[] candidates3 = {2};
        int target3 = 1;
        // Expected: []
        System.out.println("Test 3 Result: " + combinationSumRecursion(candidates3, target3));
    }

    public static List<List<Integer>> combinationSumRecursion(int[] candidates, int target) {
        List<List<Integer>> result = recursionHelper(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
        // TODO: Implement the backtracking logic here
        return result;
    }

    public static List<List<Integer>> recursionHelper(int[] candidates, int target,int i,
                                                      List<Integer> temp, List<List<Integer>> result){
        if(target<0 || i>=candidates.length){
            return result;
        }
        if(target==0){
            List<Integer> list= new ArrayList<>(temp);
            result.add(list);
            return result;
        }


        recursionHelper(candidates, target, i+1, temp, result);

        // take the candidate
        temp.add(candidates[i]);
        recursionHelper(candidates, target-candidates[i], i, temp, result);
        temp.remove(temp.size()-1);
        // skip the candidate

        return result;
    }
}
