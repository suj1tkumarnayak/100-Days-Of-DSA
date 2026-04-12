package day_033_date_date_2026_04_10.hashing;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElements {
    public static void main(String[] args) {
        int[] arr = {12, 1, 14, 3, 16};
        System.out.println(distinct(arr));
    }
    public static int distinct(int arr[]) {
        // code here
        Set<Integer> set = new HashSet<>();

        for (int num: arr){
            set.add(num);
        }

        return set.size();
    }
}
