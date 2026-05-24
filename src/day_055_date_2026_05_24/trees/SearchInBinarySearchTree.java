package day_055_date_2026_05_24.trees;

public class SearchInBinarySearchTree {

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
        // Mock BST:
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int target = 2;

        SearchInBinarySearchTree solution = new SearchInBinarySearchTree();
        TreeNode result = solution.searchBST(root, target);

        System.out.println("Found node value: " + (result != null ? result.val : "null"));
    }

    public TreeNode searchBST(TreeNode root, int val) {
        // TODO: Implement your BST search algorithm here
        return null;
    }
}
