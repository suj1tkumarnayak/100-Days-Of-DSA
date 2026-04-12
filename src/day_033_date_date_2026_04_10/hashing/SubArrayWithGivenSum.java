package day_033_date_date_2026_04_10.hashing;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 5 };
        int target = 12;
        System.out.println(subarraysum(arr, target));
    }
    public static ArrayList<Integer> subarraysum(int[] arr, int target){
        int len = arr.length, prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            prefixSum += arr[i];

            if( prefixSum == target ){
                list.add(1);
                list.add(i+1);
                return list;
            }

            int num = prefixSum - target;

            if(map.containsKey(num)){
                list.add(map.get(num)+2);
                list.add(i+1);
                return list;
            }

            map.put(prefixSum, i);
        }
        list.add(-1);
        return list;
    }
}
