package day_032_date_2026_04_05.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        final List<Integer> list = List.of(1, 3, -1, -3, 5, 3, 6, 7);
        System.out.println(slidingMaximum(list, 3));
    }
    public static ArrayList<Integer> slidingMaximum(final List<Integer> nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int len = nums.size(), max = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums.get(i));
            if(i>=k-1){
                
            }
        }

        return ans;
    }
}
