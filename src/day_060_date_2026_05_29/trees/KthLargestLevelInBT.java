package day_060_date_2026_05_29.trees;

import java.util.*;

public class KthLargestLevelInBT {

    public static void main(String[] args) {
        // Test case setup
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        int k = 2;
        // Level sums: Level 1 = 5, Level 2 = 17, Level 3 = 13
        // Sorted level sums descending: 17, 13, 5
        // 2nd largest should be 13

        System.out.println("Kth Largest Level Sum: " + kthLargestLevelSum(root, k));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // FIX 1: Use Long to prevent integer overflow
        List<Long> levelSums = new ArrayList<>();

        while (!queue.isEmpty()){
            int size = queue.size();
            long sum = 0; // FIX 1: Accumulate as long

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            levelSums.add(sum);
        }

        // Check if the tree has fewer levels than k
        if (levelSums.size() < k) {
            return -1;
        }

        // FIX 2: Sort ascendingly to find the Kth largest element accurately
        Collections.sort(levelSums);

        // The Kth largest element is located at (Total Levels - K)
        return levelSums.get(levelSums.size() - k);
    }
}
