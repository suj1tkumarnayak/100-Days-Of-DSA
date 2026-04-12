package day_034_date_2026_04_12.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 1, 2, 3, 6, 7 };
        System.out.println(findUnion(arr1, arr2));
    }
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        int i = 0, j = 0, len1 = a.length, len2 = b.length;
        ArrayList<Integer> list = new ArrayList<>();

        while (i<len1 && j<b.length){
            //int val;
            if(a[i]<b[j]){
                //val = a[i++];
                addList(list, a, i);
                i++;
            }else if(a[i]>b[j]){
//                val = b[j++];
                addList(list, b, j);
                j++;
            }else{
//                val = a[i++];
//                j++;
                addList(list, a, i);
                i++;
                j++;
            }
//            if (list.isEmpty() || list.get(list.size()-1) != val){
//                list.add(val);
//            }
        }

        while ( i < len1 ){
//            if (list.isEmpty() || list.get(list.size()-1) != a[i]){
//                list.add(a[i]);
//            }
            addList(list, a, i);
            i++;
        }

        while( j < len2 ){
//            if (list.isEmpty() || list.get(list.size()-1) != b[j]){
//                list.add(b[j]);
//            }
            addList(list, b, j);
            j++;
        }

        return list;
    }
    public static void addList(ArrayList<Integer> list, int[] arr, int i){
        if (list.isEmpty() || list.get(list.size()-1) != arr[i]){
            list.add(arr[i]);
        }
    }
}
