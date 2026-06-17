package day_073_date_2026_06_15;

import java.util.Arrays;

public class MinimumCostToFillGivenWeight {

    public static void main(String[] args) {

        // Basic case: mix 2kg + 3kg = 14
        System.out.println(minCost(new int[]{20, 10, 4, 50, 100}, 5));  // Expected: 14

        // Impossible case: no way to make 5kg from available packets
        System.out.println(minCost(new int[]{-1, -1, 4, 3, -1}, 5));    // Expected: -1

        // Only 1kg packet available
        System.out.println(minCost(new int[]{5}, 3));                    // Expected: 15

        // Edge: w = 1, only 1kg available
        System.out.println(minCost(new int[]{10}, 1));                   // Expected: 10

        // All packets unavailable
        System.out.println(minCost(new int[]{-1, -1}, 2));              // Expected: -1

        // Single packet exactly matching w
        System.out.println(minCost(new int[]{-1, -1, 7}, 3));           // Expected: 7
    }

    public static int minCost(int[] cost, int w) {
        final int INF = Integer.MAX_VALUE / 2;

        // dp[j] = min cost to fill exactly j kg
        int[] dp = new int[w + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // For each target weight j, try every available packet size
        for (int j = 1; j <= w; j++) {
            for (int i = 0; i < cost.length; i++) {
                int packetWeight = i + 1;
                if (cost[i] == -1) continue;              // packet unavailable
                if (j < packetWeight) continue;           // can't use this packet
                if (dp[j - packetWeight] == INF) continue; // can't reach prerequisite state

                dp[j] = Math.min(dp[j], dp[j - packetWeight] + cost[i]);
            }
        }

        return dp[w] == INF ? -1 : dp[w];
    }
}