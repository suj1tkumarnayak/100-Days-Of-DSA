package day_033_date_2026_04_10.hashing;
//https://www.geeksforgeeks.org/problems/frequency-of-elements--111353/1
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FrequencyOfElements {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 5 };
        ArrayList<ArrayList<Integer>> list = countFreq(arr);
        for (ArrayList<Integer> freq : list) {
            System.out.println(freq);
        }
    }
    public static ArrayList<ArrayList<Integer>> countFreq(int[] arr) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            ArrayList<Integer> freq = new ArrayList<>();
            freq.add(entry.getKey());
            freq.add(entry.getValue());
            list.add(freq);
        }
        return list;
    }
}
