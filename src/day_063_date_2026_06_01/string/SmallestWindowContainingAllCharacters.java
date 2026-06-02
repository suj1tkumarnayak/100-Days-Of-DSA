package day_063_date_2026_06_01.string;

public class SmallestWindowContainingAllCharacters {
    public static void main(String[] args) {
        //SmallestWindowContainingAllCharacters obj = new SmallestWindowContainingAllCharacters();
        String s = "timetopractice";
        String p = "toc";
        System.out.println(minWindowBrute(s, p));
    }
    public static String minWindowBrute(String s, String p) {
        // code here
        String ans = "";
        int m = s.length(), n = p.length();
        for (int i = 0; i < m; i++) {
            int k = 0;
            char currChar = p.charAt(k);
            for (int j = i+1; j < m; j++) {
                if(k<n && currChar==p.charAt(j)){

                }
            }
        }

        return ans;
    }
}
