package day_063_date_2026_06_01.trees;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val, TreeNode left){
        this.val = val;
        this.left = left;
    }
}
