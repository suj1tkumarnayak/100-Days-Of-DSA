package day_033_date_2026_04_10.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumOfAllSubArraysWithSumK {
    public static void main(String[] args) {
        List<Integer> A = List.of(1, 3, -1, -3, 5, 3, 6, 7 );
        System.out.println(slidingMaximum(A, 3));
    }
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B){
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int len = A.size();

        for (int i = 0; i < len; i++) {
            // remove elements which are out of the window B
            if(!dq.isEmpty() && dq.getFirst()<=i-B){
                dq.pollFirst();
            }

            // remove elements from the last which are less than A.get(i)
            while (!dq.isEmpty() && A.get(dq.getLast()) <= A.get(i)){
                dq.pollLast();
            }

            dq.addLast(i);

            if(!dq.isEmpty() && i>=B-1){
                ans.add(A.get(dq.peek()));
            }
        }

        return ans;
    }
}
