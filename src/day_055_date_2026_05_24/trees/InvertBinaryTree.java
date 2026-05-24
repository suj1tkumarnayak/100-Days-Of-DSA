package day_055_date_2026_05_24.trees;

public class InvertBinaryTree {

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
        //      4
        //     / \
        //    2   7
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode invertedRoot = solution.invertTree(root);

        // Print root and its inverted children to verify setup
        if (invertedRoot != null) {
            System.out.println("Root: " + invertedRoot.val);
            System.out.println("Left: " + (invertedRoot.left != null ? invertedRoot.left.val : "null"));
            System.out.println("Right: " + (invertedRoot.right != null ? invertedRoot.right.val : "null"));
        }
    }

    public TreeNode invertTree(TreeNode root) {
        // TODO: Implement your tree inversion algorithm here
        if(root==null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
