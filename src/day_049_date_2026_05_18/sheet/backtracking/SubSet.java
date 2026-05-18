package day_049_date_2026_05_18.sheet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        {}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}
        List<List<Integer>> subSets = generateSubsets(nums);
        for (List<Integer> list : subSets) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> generateSubsets(int[] nums){
        List<List<Integer>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());
        for (int num : nums) {
            int currentSize = subSets.size();

            for (int i = 0; i < currentSize; i++) {
                List<Integer> list = new ArrayList<>(subSets.get(i));
                list.add(num);
                subSets.add(list);
            }
        }
        return subSets;
    }
}
