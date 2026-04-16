package day_037_date_2026_04_16.slidingwindow.revision;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
    }
    public static int search(String pat, String txt) {
        int[] patCount = new int[26];
        int[] anagramCount = new int[26];
        int count = 0, k = pat.length();
        for (char c : pat.toCharArray()) {
            patCount[c-'a']++;
        }

        for (int i = 0; i < txt.length(); i++) {
            anagramCount[txt.charAt(i)-'a']++;
            if(i>=k){
                anagramCount[txt.charAt(i-k)-'a']--;
            }

            if(areEqualArray(patCount, anagramCount)){
                count++;
            }
        }

        return count;
    }
    public static boolean areEqualArray(int[] a, int[] b){
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
}
