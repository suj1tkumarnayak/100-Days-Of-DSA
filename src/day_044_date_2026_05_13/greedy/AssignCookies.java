package day_044_date_2026_05_13.greedy;


import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findContentChildren(g, s));
    }
    private static int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int cont = 0;
        int i = 0, j =0;
        while (i<g.length && j<s.length){
            if(g[i]<=s[j]) {
                cont++;
                i++;
            }
            j++;
        }

        return cont;
    }
}
