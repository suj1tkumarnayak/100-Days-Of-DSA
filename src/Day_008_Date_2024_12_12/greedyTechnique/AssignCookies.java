package Day_008_Date_2024_12_12.greedyTechnique;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        System.out.println(findContentChildren(g,s));
    }
    private static int findContentChildren(int[] g, int[] s) {
        int count = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i=0, j=0;

        while( i < g.length && j < s.length ){
            if(g[i]<=s[j]){
                count++;
                i++;
            }
            j++;
        }

        return count;
    }
}
