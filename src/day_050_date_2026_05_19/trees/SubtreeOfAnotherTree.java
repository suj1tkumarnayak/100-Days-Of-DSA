package day_050_date_2026_05_19.trees;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(4);
        p.right = new TreeNode(5);
        p.left.left = new TreeNode(1);
        p.left.right = new TreeNode(2);
        p.right.left = new TreeNode(2);
        p.right.right = new TreeNode(3);


        TreeNode q = new TreeNode(4);
        q.left = new TreeNode(2);
        q.right = new TreeNode(1);
//        q.left.left = new TreeNode();
//        q.left.right = new TreeNode();
//        q.right.left = new TreeNode(15);
//        q.right.right = new TreeNode(7);

        System.out.println(isSubtree(p, q));
    }
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;

        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null & q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }

        return p.val==q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
