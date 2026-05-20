package day_051_date_2026_05_20.trees;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(6);
        p.left = new TreeNode(2);
        p.right = new TreeNode(8);
        p.left.left = new TreeNode(0);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(9);
        p.left.right.left = new TreeNode(3);
        p.left.right.right = new TreeNode(5);


//        TreeNode q = new TreeNode(3);
//        q.left = new TreeNode(9);
//        q.right = new TreeNode(201);
//        q.left.left = new TreeNode();
//        q.left.right = new TreeNode();
//        q.right.left = new TreeNode(15);
//        q.right.right = new TreeNode(7);
//        System.out.println(lowestCommonAncestor(p, p.left, p.right).val);
    }
//    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root==null) return false;
//    }
}
