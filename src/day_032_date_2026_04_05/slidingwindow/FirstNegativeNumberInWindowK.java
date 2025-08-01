package day_032_date_2026_04_05.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeNumberInWindowK {
    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(firstNegInt(nums, 3));
    }
    public static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if(arr[i] < 0){
                neg.add(i);
            }

            if(!neg.isEmpty() && neg.getFirst() <= i-k){
                neg.removeFirst();
            }

            if(i>=(k-1)){
                if(!neg.isEmpty()){
                    list.add(arr[neg.getFirst()]);
                }else{
                    list.add(0);
                }
            }
        }
        
        return list;
    }
}
