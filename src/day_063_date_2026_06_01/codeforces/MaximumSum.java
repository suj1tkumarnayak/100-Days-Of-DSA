package day_063_date_2026_06_01.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

public class MaximumSum {
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        PrintWriter out = new PrintWriter(System.out);

        int t = parseInt(br.readLine());
        while (t-- > 0) {
            // your code here
            int n = br.read();
            int k = br.read();
            StringTokenizer st = new StringTokenizer(br.readLine());
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                int num = parseInt(st.nextToken());
                maxHeap.offer(num);
                minHeap.offer(num);
            }
            System.out.println(maximumSum(n, k));
        }

        out.flush();
    }
    private static int maximumSum(int n, int k){
        int sum = 0;

        for (int i = 0; i < k; i++) {
        }

        return sum;
    }
}
