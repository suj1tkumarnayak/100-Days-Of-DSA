package day_036_date_2026_04_15.arrays.slidingwindow.revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FirstNegativeInEveryWindowOfSizeK {
    public static void main(String[] args) {
        int[] arr = {-8, 2, 3, -6, 10};
        System.out.println(firstNegInt(arr, 2));
    }
    public static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<0){
                dq.addLast(i);
            }
            if(i>=k-1){
                if(!dq.isEmpty() && dq.peek()<=i-k){
                    dq.poll();
                }

                if(dq.isEmpty()){
                    list.add(0);
                }
                else{
                    list.add(arr[dq.peek()]);
                }
            }
        }

        return list;
    }
}
