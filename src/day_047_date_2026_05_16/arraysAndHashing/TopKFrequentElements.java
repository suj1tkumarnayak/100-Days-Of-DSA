package day_047_date_2026_05_16.arraysAndHashing;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(topKFrequent1(nums, 2)));
    }
    public static int[] topKFrequent1(int[] nums, int k){
        int n = nums.length;
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[n+1];

        for (int i = 0; i < n+1; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length-1; i >=0 && index<k ; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
                if(index==k){
                    return res;
                }
            }

        }

        return res;
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0)+1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(heap.size()>k){
                heap.poll();
            }
        }


        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }
        return res;
    }
}
