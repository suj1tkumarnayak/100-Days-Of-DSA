package day_060_date_2026_05_29.trees;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DiameterOfTree {
    static int MAX_DIAMETER;
    public static void main(String[] args) {
        // Test your implementation here
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Diameter: " + diameterOfBinaryTree(root));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        MAX_DIAMETER = 0;
        helper(root);
        return MAX_DIAMETER;
    }
    public static int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int diaLeft = helper(root.left);
        int diaRight = helper(root.right);

        MAX_DIAMETER = Math.max(MAX_DIAMETER, diaLeft+diaRight);

        return 1+Math.max(diaLeft, diaRight);
    }
}
