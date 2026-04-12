package day_033_date_2026_04_10.slidingwindow;

public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(countOccurencesOfAnagrams(txt, pat));
    }

    private static int countOccurencesOfAnagrams(String txt, String pat) {
        int[] patCount = new int[26];
        int[] txtCount = new int[26];
        int len = txt.length(), k = pat.length(), count = 0;

        for (char c : pat.toCharArray()) {
            patCount[c-'a']++;
        }

        for (int i = 0; i < len; i++) {
            txtCount[txt.charAt(i)-'a']++;

            if(i>=k-1){
                if(checkCount(txtCount, patCount)){
                    count++;
                }
                txtCount[txt.charAt(i-k+1)-'a']--;
            }
        }

        return count;
    }

    private static boolean checkCount(int[] a, int[] b) {
        int len = a.length;

        for (int i = 0; i < len; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
