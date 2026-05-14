package day_046_date_2026_05_15.twopointers;

public class ContainingMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height){
        int i = 0, j = height.length-1;
        int area = 0;

        while (i<j){
            int minHeight = Math.min(height[i], height[j]);
            int temp = minHeight*(j-i);
            //System.out.println(temp);
            area = Math.max(temp, area);

            while(i<j && height[i]<=minHeight){
                i++;
            }
            while(i<j && height[j]<=minHeight){
                j--;
            }
//            if(height[i]>height[j]){
//                j--;
//            }else{
//                i++;
//            }
        }

        return area;
    }

    private static int maxAreaBrute(int[] height) {
        int area = 0;
        for(int i=0; i<height.length; i++){
            for(int j=i+1; j<height.length; j++){
                int temp = Math.min(height[i], height[j])*(j-i);
                area = Math.max(temp, area);
            }
        }
        return area;
    }
}
