package day_050_date_2026_05_19.trees;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int left = 1+maxDepth(root.left);
        int right = 1+maxDepth(root.right);

        return Math.max(left, right);
    }
}
