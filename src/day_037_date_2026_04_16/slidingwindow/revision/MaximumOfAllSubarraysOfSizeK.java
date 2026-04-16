package day_037_date_2026_04_16.slidingwindow.revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MaximumOfAllSubarraysOfSizeK {
    public static void main(String[] args) {
        List<Integer> A = List.of(1, 3, -1, -3, 5, 3, 6, 7);
        int B = 3;
        System.out.println(slidingMaximum(A, B));
    }
    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> list = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < A.size(); i++) {
            if(dq.isEmpty()){
                dq.add(i);
            }else{
                int num = A.get(i);
                while(!dq.isEmpty() && A.get(dq.peek())<num){
                    dq.poll();
                }
                dq.addLast(i);
            }

            if(i>=B-1){
                while(!dq.isEmpty() && dq.peek()<i-B+1){
                    dq.poll();
                }
                if(!dq.isEmpty()){
                    list.add(A.get(dq.peek()));
                }
            }
        }

        return list;
    }
}
