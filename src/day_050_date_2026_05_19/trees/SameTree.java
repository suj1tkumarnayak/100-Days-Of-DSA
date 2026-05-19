package day_050_date_2026_05_19.trees;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(9);
        p.right = new TreeNode(20);
        p.left.left = new TreeNode();
        p.left.right = new TreeNode();
        p.right.left = new TreeNode(15);
        p.right.right = new TreeNode(7);


        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(9);
        q.right = new TreeNode(201);
        q.left.left = new TreeNode();
        q.left.right = new TreeNode();
        q.right.left = new TreeNode(15);
        q.right.right = new TreeNode(7);

        System.out.println(isSameTree(p, q));
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
