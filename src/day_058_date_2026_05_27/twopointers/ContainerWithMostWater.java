package day_058_date_2026_05_27.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }
    public static int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int area = 0;

        while (i<j){
            int length = Math.min(height[i], height[j]);
            int breadth = j-i;
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
            area = Math.max(area, length*breadth);
        }

        return area;
    }
}
