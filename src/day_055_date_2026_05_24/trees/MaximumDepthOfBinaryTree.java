package day_055_date_2026_05_24.trees;

public class MaximumDepthOfBinaryTree {

    // Definition for a binary tree node.
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // Mock Tree:
        //      3
        //     / \
        //    9  20
        //       / \
        //      15  7
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        int maxDepth = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + maxDepth);
    }

    public int maxDepth(TreeNode root) {
        // TODO: Implement your maximum depth algorithm here
        if(root==null) return 0;

        int leftDept = 1+maxDepth(root.left);
        int rightDept = 1+maxDepth(root.right);

        return Math.max(leftDept, rightDept);
    }
}
