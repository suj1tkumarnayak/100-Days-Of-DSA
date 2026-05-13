package day_044_date_2026_05_13.infosys;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaximumTotalModeFrequencyScore {
    public static void main(String[] args) {
        int n = 7;
        int k = 2;
        int[] nums = {1,2,2,3,1,1,1};
        System.out.println(solve(nums, n, k));
    }

    // ============================================================
    // CORE PRECOMPUTATION: modeFreq[l][r] = mode frequency of a[l..r]
    // We precompute all O(N^2) subarray mode frequencies.
    // For each start l, sweep r from l to N-1, maintaining a
    // frequency map. Update max freq as we expand rightward.
    // Time: O(N^2), Space: O(N^2)
    // ============================================================
    static int[][] precomputeModeFreq(int[] a, int n) {
        int[][] mf = new int[n + 1][n + 1]; // 1-indexed: mf[l][r]
        for (int l = 1; l <= n; l++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int maxFreq = 0;
            for (int r = l; r <= n; r++) {
                int val = a[r - 1]; // convert to 0-indexed array
                int f = freq.merge(val, 1, Integer::sum);
                maxFreq = Math.max(maxFreq, f);
                mf[l][r] = maxFreq;
            }
        }
        return mf;
    }

    // ============================================================
    // MAIN DP
    // dp[k][i] = max total mode-frequency score using first i
    //            elements split into exactly k non-empty groups.
    //
    // Base case:  dp[1][i] = modeFreq(1, i)  for all i >= 1
    // Transition: dp[k][i] = max over j in [k-1 .. i-1] of
    //                         dp[k-1][j] + modeFreq(j+1, i)
    //
    // Answer: dp[K][N]
    // Time: O(N^2 * K), Space: O(N * K)
    // ============================================================
    static int solve(int[] a, int n, int K) {
        // Edge: if K >= N, each element alone → score = N
        if (K >= n) return n;

        int[][] mf = precomputeModeFreq(a, n);

        // dp[k][i]: k groups, first i elements
        // Use rolling array optimization: only need previous row
        int[] prev = new int[n + 1]; // dp[k-1][i]
        int[] curr = new int[n + 1]; // dp[k][i]

        // Base case: k=1
        for (int i = 1; i <= n; i++) {
            prev[i] = mf[1][i];
        }

        // Fill for k = 2 to K
        for (int k = 2; k <= K; k++) {
            Arrays.fill(curr, 0);
            for (int i = k; i <= n; i++) {          // need at least k elements
                curr[i] = 0;
                for (int j = k - 1; j < i; j++) {  // last group is a[j+1..i]
                    if (prev[j] > 0 || j == k - 1) {
                        curr[i] = Math.max(curr[i], prev[j] + mf[j + 1][i]);
                    }
                }
            }
            // Swap rows
            int[] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        return prev[n];
    }
}
