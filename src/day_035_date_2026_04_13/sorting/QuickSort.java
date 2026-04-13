package day_035_date_2026_04_13.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        quickSort(nums, 0, nums.length-1);
    }
    public static void quickSort(int[] nums, int low, int high){
        if(low<high){
            int pi = partition(nums, low, high);
            quickSort(nums, low, pi-1);
            quickSort(nums, pi+1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        while (low<high){
            
        }
    }
}
