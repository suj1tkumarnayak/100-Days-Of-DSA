package day_055_date_2026_05_24.trees;

public class SameTree {

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
        // Mock Tree 1:
        //      1
        //     / \
        //    2   3
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Mock Tree 2:
        //      1
        //     / \
        //    2   3
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        SameTree solution = new SameTree();
        boolean isSame = solution.isSameTree(p, q);

        System.out.println("Are the trees the same? " + isSame);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // TODO: Implement your tree structural equality algorithm here
        if(p==null && q==null){
            return true;
        }

        if((p==null && q!=null) || (p!=null && q==null) || p.val!=q.val){
            return false;
        }


        // left same?
        boolean leftSame = isSameTree(p.left, q.left);
        // right same?
        boolean rightSame = isSameTree(p.right, q.right);

        return leftSame && rightSame;
    }
}
