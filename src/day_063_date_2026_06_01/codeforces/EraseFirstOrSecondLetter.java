package day_063_date_2026_06_01.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class EraseFirstOrSecondLetter {
    static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter out = new PrintWriter(System.out);

        int t = parseInt(br.readLine());
        while (t-- > 0) {
            // your code here
            int n = parseInt(br.readLine());
            String s = br.readLine();
            int nonEmptyString = findNonEmptyStrings(n, s);
            out.println(nonEmptyString);
        }

        out.flush();
    }
    private static int findNonEmptyStrings(int n, String s) {
        HashSet<Character> seen = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (seen.add(s.charAt(i))) {
                ans += n - i;
            }
        }

        return ans;
    }
    private static int findNonEmptyStrings1(int n, String s){
        set = new HashSet<>();
        helper(n, s);
        return set.size();
    }
    private static void helper(int n, String s) {
        if (s.length() == 0) {
            return;
        }

        // already processed
        if (set.contains(s)) {
            return;
        }

        set.add(s);

        // erase first character
        helper(n, s.substring(1));

        // erase second character
        if (s.length() >= 2) {
            helper(n, s.substring(0, 1) + s.substring(2));
        }
    }
}
