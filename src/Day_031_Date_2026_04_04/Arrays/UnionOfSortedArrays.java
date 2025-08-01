package Day_031_Date_2026_04_04.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = { 1,2,3,4,5 };
        int[] nums2 = { 2,3,4,4,5 };
        System.out.println(Arrays.toString(unionOfSortedArrays(nums1, nums2)));
    }

    private static int[] unionOfSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, len1 = nums1.length, len2 = nums2.length;
        List<Integer> list = new ArrayList<>();

        while (i<len1 && j<len2){
            if(nums1[i]<nums2[j]){
                list.add(nums1[i]);
                i++;
            }else if(nums2[j]<nums1[i]){
                list.add(nums2[j]);
                j++;
            }else{
                int num = nums1[i];
                list.add(num);
                while(i<len1 && nums1[i] == num){
                    i++;
                }
                while (j<len2 && nums2[j] == num){
                    j++;
                }
            }
        }

        while (i<len1){
            list.add(nums1[i]);
            i++;
        }

        while (j<len2){
            list.add(nums2[j]);
            j++;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
